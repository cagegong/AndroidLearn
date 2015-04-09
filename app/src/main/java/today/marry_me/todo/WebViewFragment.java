package today.marry_me.todo;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFragment extends Fragment {

    private String brazil_url = "http://2014.qq.com";
    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // layout布局文件转换为view对象
        // resource Fragment 需要加载的布局文件
        // root 加载layout的ViewGroup
        // attachToRoot: false, 不返回父viewGroup
        View view = inflater.inflate(R.layout.web_view_fragment, container, false);

        webView = (WebView) view.findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/index.html");

        // 支持js
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        // webView.loadUrl("http://baidu.com");
        // 覆盖WebView默认通过第三方或者系统浏览器打开WebView
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 返回值是true的时候在webview中打开，否则用第三方打开
                view.loadUrl(url);
                return true;
            }
            // WebViewClient帮助WebView处理一些页面控制和请求通知
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100)
                {
                    closeDialog();
                }
                else
                {
                    openDialog(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        view.findViewById(R.id.open_url).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(brazil_url);
            }
        });

        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

        view.findViewById(R.id.forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
            }
        });

        return view;
    }

    private void closeDialog() {
        if(progressDialog!=null&&progressDialog.isShowing())
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private void openDialog(int newProgress) {
        if (progressDialog == null)
        {
            progressDialog = new ProgressDialog(this.getActivity());
            progressDialog.setTitle("正在加载");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setProgress(newProgress);
            progressDialog.show();
        }
        else
        {
            progressDialog.setProgress(newProgress);
        }
    }
}
package today.marry_me.todo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarFragment extends Fragment implements View.OnClickListener {

    private ProgressBar progressBar4;
    private Button add;
    private Button reduce;
    private Button reset;
    private ProgressDialog progressDialog;
    private Button show;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.progress_bar_fragment, container, false);
        progressBar4 = (ProgressBar) view.findViewById(R.id.progressBar4);
        showProgress();
        reset = (Button) view.findViewById(R.id.reset);
        reduce = (Button) view.findViewById(R.id.reduce);
        add = (Button) view.findViewById(R.id.add);
        show = (Button) view.findViewById(R.id.show);
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);
        return view;
    }

    private void showProgress() {
        int first = progressBar4.getProgress();
        int second = progressBar4.getSecondaryProgress();
        int max = progressBar4.getMax();
        Toast.makeText(this.getActivity(), (int) (first / (float) max * 100) + "%, " + (int) (second / (float) max * 100) + "%", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add: {
                progressBar4.incrementProgressBy(10);
                progressBar4.incrementSecondaryProgressBy(10);
                break;
            }
            case R.id.reduce: {
                progressBar4.incrementProgressBy(-10);
                progressBar4.incrementSecondaryProgressBy(-10);
                break;
            }
            case R.id.reset: {
                progressBar4.setProgress(50);
                progressBar4.setSecondaryProgress(80);
                break;
            }
            case R.id.show: {
                // 新建progress dialog对象
                progressDialog = new ProgressDialog(this.getActivity());
                // 设置显示风格
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("cagegong");
                progressDialog.setMessage("欢迎cagegong");
                progressDialog.setIcon(R.drawable.ic_launcher);

                // 设置进度条属性
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);

                // 设定一个确定按钮
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressBarFragment.this.getActivity(), "欢迎大家支持cagegong", Toast.LENGTH_SHORT).show();
                    }
                });

                // 可以通过返回取消对话框
                progressDialog.setCancelable(true);

                // 显示对话框
                progressDialog.show();
            }
        }
        showProgress();
    }
}

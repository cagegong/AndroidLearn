package today.marry_me.todo;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseListFragment extends Fragment {
    public CourseListFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("Main", "Fragment1---onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("Main", "Fragment1---onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // layout布局文件转换为view对象
        // resource Fragment 需要加载的布局文件
        // root 加载layout的ViewGroup
        // attachToRoot: false, 不返回父viewGroup
        Log.i("Main", "Fragment1---onCreateView()");
        return inflater.inflate(R.layout.course_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Main", "Fragment1---onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Main", "Fragment1---onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Main", "Fragment1---onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Main", "Fragment1---onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Main", "Fragment1---onStop()");
        super.onStop();
    }

    /*
     * 销毁Fragment包含的View
     */
    @Override
    public void onDestroyView() {
        Log.i("Main", "Fragment1---onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Main", "Fragment1---onDestroy()");
        super.onDestroy();
    }

    // Fragment 从Activity中删除时会回调该方法
    @Override
    public void onDetach() {
        Log.i("Main", "Fragment1---onDetach()");
        super.onDetach();
    }
}

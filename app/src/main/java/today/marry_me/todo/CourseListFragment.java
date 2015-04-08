package today.marry_me.todo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseListFragment extends Fragment {
    public CourseListFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // layout布局文件转换为view对象
        // resource Fragment 需要加载的布局文件
        // root 加载layout的ViewGroup
        // attachToRoot: false, 不返回父viewGroup
        return inflater.inflate(R.layout.course_list_fragment, container, false);
    }
}

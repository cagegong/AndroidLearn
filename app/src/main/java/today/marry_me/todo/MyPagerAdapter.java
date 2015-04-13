package today.marry_me.todo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<String> titleList;
    private List<View> viewList;

    public MyPagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    public MyPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    //  返回页卡的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

//  view 是否来自于这个队形
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

//  实例化一个页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }


//  销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

package cn.edu.pku.lx.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by sun67 on 16.12.21.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> viewList;
    private Context context;
    @Override
    public int getCount() {
        return viewList.size();
    }
    public ViewPagerAdapter(List<View> views,Context context){
        this.viewList=views;
        this.context=context;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}

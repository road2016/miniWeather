package cn.edu.pku.lx.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.lx.adapter.ViewPagerAdapter;


public class Guide extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private List<View> views;
    private Button button;
    private ImageView[] dots;
    private int[] ids={R.id.iv1,R.id.iv2,R.id.iv3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_viewpager);
        initViews();
        initDots();
        button=(Button) views.get(2).findViewById(R.id.button_intoTheApp);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /*
                * 修改首次登录信息
                * */
                SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
                if(sharedPreferences.getBoolean("isFirstOpen",true)){
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("isFirstOpen",false);
                    editor.commit();
                }

                Intent intent =new Intent(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initViews(){
        LayoutInflater layoutInflater= LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(layoutInflater.inflate(R.layout.first_guide,null));
        views.add(layoutInflater.inflate(R.layout.second_guide,null));
        views.add(layoutInflater.inflate(R.layout.third_guide,null));
        viewPagerAdapter=new ViewPagerAdapter(views,this);
        viewPager=(ViewPager) findViewById(R.id.guild_viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    void initDots(){   //初始化
        dots=new ImageView[views.size()];
        for(int i=0;i<views.size();i++){
            dots[i]=(ImageView)findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0;i<ids.length;i++){
            if(i ==position){
                dots[i].setImageResource(R.drawable.page_indicator_focused);
            }
            else{
                dots[i].setImageResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

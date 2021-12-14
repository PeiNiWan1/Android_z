package com.example.learningplatform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.learningplatform.fragment.CityModleFragment;
import com.example.learningplatform.fragment.FilmFragment;
import com.example.learningplatform.fragment.MyFragment;
import com.example.learningplatform.fragment.TakeOutFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;

    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;


    private CityModleFragment ctFragment=new CityModleFragment();
    private FilmFragment flFragment=new FilmFragment();
    private TakeOutFragment tkFragment=new TakeOutFragment();
    private MyFragment myFragment=new MyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init()
    {
        mViewPager=findViewById(R.id.fragment_vp);
        mTabRadioGroup=findViewById(R.id.tabs_rg);
        mFragments=new ArrayList<>(4);
        mFragments.add(ctFragment);
        mFragments.add(flFragment);
        mFragments.add(tkFragment);
        mFragments.add(myFragment);
        mViewPager.setAdapter(new DFragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mFragments));
        mViewPager.addOnPageChangeListener(pageChangeListener);
        mTabRadioGroup.setOnCheckedChangeListener(radiogroupListener);
        myfragment_get();
    }

    private void myfragment_get()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("data",0);
        String token= sharedPreferences.getString("token",null);
        ScHttp scHttp=new ScHttp("http://124.93.196.45:10001/prod-api/api/common/user/getInfo");
        scHttp.Token=token;
        scHttp.setCallData(new ScHttp.CallData() {
            @Override
            public void CallData(String data) {
                Log.d("", "CallData: "+data);
                Bundle bundle=new Bundle();
                bundle.putString("Data",data);
                myFragment.setArguments(bundle);
            }
        });
        scHttp.Start();
    }










    private RadioGroup.OnCheckedChangeListener radiogroupListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                if (radioGroup.getChildAt(i).getId() == checkedId) {
                    mViewPager.setCurrentItem(i);
                    return;
                }
            }

        }
    };

    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                RadioButton radioButton=(RadioButton) mTabRadioGroup.getChildAt(position);
                radioButton.setChecked(true);
        }



        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private class DFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> DataList;
        public DFragmentPagerAdapter(@NonNull FragmentManager fm, int b, List<Fragment> list) {
            super(fm,b);
            DataList=list;


        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return DataList.get(position);
        }

        @Override
        public int getCount() {
            return DataList.size();
        }
    }
}
package com.geektech.boredapp.intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.geektech.boredapp.R;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    ViewPager viewPager;
    IntroPagerAdapter adapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ArrayList<IntroPageConfig> pages = new ArrayList<>();

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_2,
                R.drawable.ic_launcher_foreground));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_4,
                R.drawable.ic_launcher_foreground));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_1,
                R.drawable.ic_launcher_foreground));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_4,
                R.drawable.ic_launcher_foreground));

        pages.add(new IntroPageConfig(
                R.string.title_activity_intro_page_3,
                R.drawable.ic_launcher_foreground));

        adapter = new IntroPagerAdapter(getSupportFragmentManager(), pages);

        viewPager = findViewById(R.id.intro_pager);
        viewPager.setAdapter(adapter);
    }

    public class IntroPagerAdapter extends FragmentPagerAdapter {

        List<IntroPageConfig> pages;

        IntroPagerAdapter(
                FragmentManager fm,
                List<IntroPageConfig> pages
        ) {
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            return IntroPageFragment.newInstance(pages.get(position));
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }
}

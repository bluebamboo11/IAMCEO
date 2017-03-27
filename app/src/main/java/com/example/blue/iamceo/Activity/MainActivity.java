package com.example.blue.iamceo.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.blue.iamceo.Fragment.CEOFragment;
import com.example.blue.iamceo.Fragment.KyThuatFragment;
import com.example.blue.iamceo.Fragment.NhanSuFragment;
import com.example.blue.iamceo.Fragment.NghienCuuFragment;
import com.example.blue.iamceo.R;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ky Thuat");
        setupViewPage();

    }

    @Override
    protected void onResume() {
        mSectionsPagerAdapter.notifyDataSetChanged();

        super.onResume();
    }

    private void setupViewPage() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle("Ky Thuat");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Nhan Su");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Ngien Cuu");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Quan Ly");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new KyThuatFragment();
                    break;
                case 1:
                    fragment = new NhanSuFragment();
                    break;
                case 2:
                    fragment = new NghienCuuFragment();
                    break;
                case 3:
                    fragment = new CEOFragment(mSectionsPagerAdapter);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {

            return 4;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            setupTablayout();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "";
                case 1:
                    return "";
                case 2:
                    return "";
            }
            return null;
        }

        private void setupTablayout() {
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_local_cafe_black_24dp);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_person_add_24dp);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_wb_sunny_24dp);
            tabLayout.getTabAt(3).setIcon(R.drawable.ic_star_24dp);
        }
    }
}

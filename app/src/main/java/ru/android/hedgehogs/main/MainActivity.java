package ru.android.hedgehogs.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.load.LoadFragment;
import ru.android.hedgehogs.main.settings.SettingsFragment;
import ru.android.hedgehogs.main.videos.VideoFragment;

/**
 * Created by yasina on 20.03.18.
 */

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private Fragment mFragment;
    Toolbar mToolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           return setFragment(item.getItemId());
        }
    };

    private boolean setFragment(int id){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.addToBackStack(null);
        switch (id) {
            case R.id.navigation_video:
                mFragment = new VideoFragment();
                break;
            case R.id.navigation_load:
                mFragment = new LoadFragment();
                break;
            case R.id.navigation_settings:
                mFragment = new SettingsFragment();
                break;
        }
        transaction.replace(R.id.fl_main, mFragment);
        transaction.commit();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setTitle(R.string.app_name);
            mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        }
        setFragment(R.id.navigation_video);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

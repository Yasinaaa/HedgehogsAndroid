package ru.android.hedgehogs.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.main.load.LoadFragment;
import ru.android.hedgehogs.main.settings.SettingsFragment;
import ru.android.hedgehogs.main.videos.VideoFragment;

/**
 * Created by yasina on 20.03.18.
 */

public class MainActivity extends BaseActivity<MainView.View, MainView.Presenter>
        implements MainView.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    @BindView(R.id.container)
    ConstraintLayout mContainer;

    private FragmentManager mFragmentManager;
    private Fragment mFragment;

    @NonNull
    @Override
    public MainView.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return setFragment(item.getItemId());
        }
    };

    private boolean setFragment(int id) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.addToBackStack(null);
        switch (id) {
            case R.id.navigation_video:
                mFragment = new VideoFragment();
                mToolbar.setTitle(R.string.videos);
                break;
            case R.id.navigation_load:
                mFragment = new LoadFragment();
                mToolbar.setTitle(R.string.load);
                break;
            case R.id.navigation_settings:
                mFragment = new SettingsFragment();
                mToolbar.setTitle(R.string.settings);
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
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setTitle(R.string.videos);
            mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        }
        setFragment(R.id.navigation_video);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

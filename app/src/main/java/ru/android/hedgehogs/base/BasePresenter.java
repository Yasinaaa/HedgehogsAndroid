package ru.android.hedgehogs.base;


import android.content.Context;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.android.hedgehogs.network.events.base.ExpiredTokenEvent;
import ru.android.hedgehogs.network.events.base.NetworkErrorEvent;

/**
 * Created by yasina on 06.04.18.
 */

public class BasePresenter<V extends BaseView.View> extends MvpBasePresenter<V>
        implements BaseView.Presenter<V>{

    @Override
    @NonNull
    public V getView() {
        if (isViewAttached()) return super.getView();
        throw new NullPointerException("Presenter can't be null");
    }

    @Override
    public void onResume() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ExpiredTokenEvent event) {
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NetworkErrorEvent event) {
    }

}


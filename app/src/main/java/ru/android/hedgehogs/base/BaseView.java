package ru.android.hedgehogs.base;

import android.content.Intent;
import android.support.annotation.UiThread;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.android.hedgehogs.network.actions.Action;
import ru.android.hedgehogs.network.events.base.ExpiredTokenEvent;
import ru.android.hedgehogs.network.events.base.NetworkErrorEvent;

/**
 * Created by yasina on 06.04.18.
 */

public interface BaseView {

    interface View extends MvpView {
        @UiThread void showLoading();
        @UiThread void showError(String text);
        @UiThread void hideLoading();
        void startAction(Action action);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V>{
        void onResume();
        void onPause();
        @Subscribe(threadMode = ThreadMode.MAIN) void onEvent(ExpiredTokenEvent event);
        @Subscribe(threadMode = ThreadMode.MAIN) void onEvent(NetworkErrorEvent event);
    }

}

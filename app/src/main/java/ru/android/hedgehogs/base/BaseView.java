package ru.android.hedgehogs.base;

import android.content.Intent;
import android.support.annotation.UiThread;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import ru.android.hedgehogs.network.actions.Action;

/**
 * Created by yasina on 06.04.18.
 */

public interface BaseView {

    interface View extends MvpView {
        @UiThread void showLoading();
        @UiThread void showError(String text);
        void startAction(Action action);
    }

    interface Presenter<V extends MvpView> extends MvpPresenter<V>{

    }

}

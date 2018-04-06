package ru.android.hedgehogs.base;


import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by yasina on 06.04.18.
 */

public class BasePresenter<V extends MvpView> extends MvpBasePresenter<V>{

    @Override
    @NonNull
    public V getView() {
        if (isViewAttached()) return super.getView();
        throw new NullPointerException("Presenter can't be null");
    }
}


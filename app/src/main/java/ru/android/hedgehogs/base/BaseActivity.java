package ru.android.hedgehogs.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.Unbinder;
import ru.android.hedgehogs.app.App;
import ru.android.hedgehogs.app.AppView;
import ru.android.hedgehogs.injection.project.ProjectComponent;
import ru.android.hedgehogs.network.ServiceHelper;
import ru.android.hedgehogs.network.actions.Action;
import ru.android.hedgehogs.utils.Component;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 06.04.18.
 */

public abstract class BaseActivity
        <V extends BaseView.View, P extends BaseView.Presenter<V>>
        extends MvpActivity<V, P> implements BaseView.View{

    protected Unbinder unbinder;

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        hideLoading();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //getApplicationComponent().inject(this);
    }

    protected <C> C getComponent(Class<C> componentType) {
        return Component.getComponent(this, componentType);
    }

    protected ProjectComponent getApplicationComponent() {
        return (ProjectComponent) ((AppView<App>) getApplication())
                .getComponent();
    }

    @Override
    public void showLoading() {
        //TODO: show loading dialog
    }

    @Override
    public void showError(String text) {
        //TODO: show error dialog
    }

    @Override
    public void hideLoading() {
        //TODO: show hide loading
    }

    public void setTransparentStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            View decorView = w.getDecorView();
            int uiOptions =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) unbinder.unbind();
    }

    protected void onBackButtonPressed() {
        onBackPressed();
    }

    @Override
    public void startAction(Action action) {
        ServiceHelper.getInstance().startActionService(this, action);
    }

}

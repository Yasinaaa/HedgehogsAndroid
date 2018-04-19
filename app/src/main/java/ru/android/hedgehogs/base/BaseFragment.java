package ru.android.hedgehogs.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import javax.inject.Inject;

import butterknife.Unbinder;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.app.App;
import ru.android.hedgehogs.injection.project.ProjectComponent;
import ru.android.hedgehogs.network.ServiceHelper;
import ru.android.hedgehogs.network.actions.Action;
import ru.android.hedgehogs.utils.Component;
import ru.android.hedgehogs.utils.Preconditions;
import ru.android.hedgehogs.utils.Resources;

/**
 * Created by yasina on 06.04.18.
 */

public abstract class BaseFragment<V extends BaseView.View,
        P extends BaseView.Presenter<V>>
        extends MvpFragment<V, P> implements BaseView.View{

    public String TAG = BaseFragment.class.getSimpleName();

    @Inject
    App mApplication;

    public View mView;
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
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
    }

    public BaseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getComponent(ProjectComponent.class).inject(this);
    }

    protected <C> C getComponent(Class<C> componentType) {
        Preconditions.checkNotNull(getActivity());
        return Component.getComponent(getActivity(), componentType);
    }

    public void openFragment(BaseFragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main, fragment, Resources.TAG_FRAGMENT)
                .addToBackStack(null)
                .commit();
    }

    public void addFragment(BaseFragment fragment, BaseFragment currentFragment) {
        fragment.setTargetFragment(currentFragment, Activity.RESULT_OK);
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_main, fragment)
                .commit();
    }

    public void removeFragment(BaseFragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .addToBackStack(null)
                .commit();
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

    @Override
    public void startAction(Action action) {
        ServiceHelper.getInstance().startActionService(getActivity(), action);
    }
}

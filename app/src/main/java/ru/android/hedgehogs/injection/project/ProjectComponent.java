package ru.android.hedgehogs.injection.project;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.base.BaseFragment;
import ru.android.hedgehogs.injection.ActivityScope;
import ru.android.hedgehogs.injection.app.ApplicationComponent;
import ru.android.hedgehogs.main.MainActivity;
import ru.android.hedgehogs.sign.SignInActivity;
import ru.android.hedgehogs.start.StartActivity;
import ru.android.hedgehogs.start.StartPresenter;

/**
 * Created by yasina on 06.04.18.
 */
/*@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = ProjectModule.class
)*/
@Singleton
@Subcomponent(modules = {ProjectModule.class})
public interface ProjectComponent {

    /*void inject(StartActivity activity);
    void inject(SignInActivity activity);
    void inject(MainActivity activity);
    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);*/
}

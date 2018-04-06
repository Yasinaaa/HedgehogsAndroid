package ru.android.hedgehogs.injection.project;

import dagger.Component;
import ru.android.hedgehogs.injection.ActivityScope;
import ru.android.hedgehogs.injection.app.ApplicationComponent;
import ru.android.hedgehogs.main.MainActivity;
import ru.android.hedgehogs.sign.SignInActivity;
import ru.android.hedgehogs.start.StartActivity;

/**
 * Created by yasina on 06.04.18.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = ProjectModule.class
)
public interface ProjectComponent {

    void inject(StartActivity activity);
    void inject(SignInActivity activity);
    void inject(MainActivity activity);
}

package ru.android.hedgehogs;

import android.app.Application;

import ru.android.hedgehogs.injection.app.ApplicationComponent;
import ru.android.hedgehogs.injection.app.ApplicationModule;
import ru.android.hedgehogs.injection.app.DaggerApplicationComponent;

/**
 * Created by yasina on 06.04.18.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule( new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}

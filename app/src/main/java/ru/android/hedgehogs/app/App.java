package ru.android.hedgehogs.app;

import android.app.Application;
import android.content.Context;

import ru.android.hedgehogs.injection.app.ApplicationComponent;
import ru.android.hedgehogs.injection.app.ApplicationModule;
import ru.android.hedgehogs.injection.app.DaggerApplicationComponent;

/**
 * Created by yasina on 06.04.18.
 */

public class App extends Application implements AppView {

    private ApplicationComponent component;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        component = DaggerApplicationComponent.builder()
                .applicationModule( new ApplicationModule(this))
                .build();
    }

    @Override
    public ApplicationComponent getComponent() {
        return component;
    }
}

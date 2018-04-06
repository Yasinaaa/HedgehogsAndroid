package ru.android.hedgehogs.injection.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.android.hedgehogs.network.api.API;

/**
 * Created by yasina on 06.04.18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    API provideApi();

}

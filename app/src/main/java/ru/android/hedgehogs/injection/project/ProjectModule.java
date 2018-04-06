package ru.android.hedgehogs.injection.project;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */
@Module
public class ProjectModule {

    @Provides
    @Singleton
    public MvpPresenter getMvpPresenter(){ return new BasePresenter();}
}

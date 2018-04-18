package ru.android.hedgehogs.main.settings;


import ru.android.hedgehogs.base.BaseView;

/**
 * Created by yasina on 06.04.18.
 */

public interface SettingsView {

    interface View extends BaseView.View {
        void setLogin();
        void setRegistration();
    }

    interface Presenter extends BaseView.Presenter<SettingsView.View>{

    }

}
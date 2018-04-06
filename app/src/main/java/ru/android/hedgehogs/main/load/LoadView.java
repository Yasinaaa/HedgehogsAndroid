package ru.android.hedgehogs.main.load;


import ru.android.hedgehogs.base.BaseView;

/**
 * Created by yasina on 06.04.18.
 */

public interface LoadView {

    interface View extends BaseView.View {
        void setLogin();
        void setRegistration();
    }

    interface Presenter extends BaseView.Presenter<LoadView.View>{

    }

}

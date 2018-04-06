package ru.android.hedgehogs.sign;


import ru.android.hedgehogs.base.BaseView;

/**
 * Created by yasina on 06.04.18.
 */

public interface SignInView {

    interface View extends BaseView.View {
        void setLogin();
        void setRegistration();
    }

    interface Presenter extends BaseView.Presenter<SignInView.View>{

    }

}

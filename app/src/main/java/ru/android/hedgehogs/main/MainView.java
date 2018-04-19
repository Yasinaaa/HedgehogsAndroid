package ru.android.hedgehogs.main;


import ru.android.hedgehogs.base.BaseView;

/**
 * Created by yasina on 06.04.18.
 */

public interface MainView {

    interface View extends BaseView.View {

    }

    interface Presenter extends BaseView.Presenter<MainView.View>{

    }

}

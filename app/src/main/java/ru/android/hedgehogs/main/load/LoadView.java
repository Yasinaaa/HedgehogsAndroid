package ru.android.hedgehogs.main.load;


import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ru.android.hedgehogs.base.BaseView;

/**
 * Created by yasina on 06.04.18.
 */
public interface LoadView {

    interface View extends BaseView.View {

    }

    interface Presenter extends BaseView.Presenter<LoadView.View>{

    }

}

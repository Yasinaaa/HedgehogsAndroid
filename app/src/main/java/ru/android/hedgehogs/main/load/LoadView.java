package ru.android.hedgehogs.main.load;


import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ru.android.hedgehogs.base.BaseView;
import ru.android.hedgehogs.network.events.send_video.SendVideoErrorEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */
public interface LoadView {

    interface View extends BaseView.View {
        void showLoadingDialog();
        void showSuccessFinishDialog();
    }

    interface Presenter extends BaseView.Presenter<LoadView.View>{
        void sendVideo(String path, String title, int quality, int originalSize, String originalSizeType);
        void sendVideo(String path, String title);
        @Subscribe void onEvent(SendVideoSuccessEvent event);
        @Subscribe void onEvent(SendVideoErrorEvent event);
    }

}

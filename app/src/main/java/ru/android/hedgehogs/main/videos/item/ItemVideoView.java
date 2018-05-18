package ru.android.hedgehogs.main.videos.item;


import ru.android.hedgehogs.base.BaseView;
import ru.android.hedgehogs.network.events.base.ExpiredTokenEvent;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoErrorEvent;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public interface ItemVideoView {

    interface View extends BaseView.View {
        void showDownloadVideo();
        void showVideoDownloadingFinished(String path);
    }

    interface Presenter extends BaseView.Presenter<ItemVideoView.View>{
        void downloadVideo(int id, String title);
        void onEvent(DownloadVideoErrorEvent event);
        void onEvent(DownloadVideoSuccessEvent event);
    }

}

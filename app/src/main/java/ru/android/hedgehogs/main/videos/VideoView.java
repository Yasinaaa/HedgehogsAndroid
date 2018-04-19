package ru.android.hedgehogs.main.videos;


import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ru.android.hedgehogs.base.BaseView;
import ru.android.hedgehogs.network.events.get_videos.GetVideosErrorEvent;
import ru.android.hedgehogs.network.events.get_videos.GetVideosSuccessEvent;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 06.04.18.
 */

public interface VideoView {

    interface View extends BaseView.View {
        void setAdapter(List<VideoRO> list);
    }

    interface Presenter extends BaseView.Presenter<VideoView.View>{
        void getVideos();
        @Subscribe
        void onEvent(GetVideosSuccessEvent event);
        @Subscribe void onEvent(GetVideosErrorEvent event);
    }

}

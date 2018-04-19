package ru.android.hedgehogs.network.events.get_videos;

import java.util.List;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 06.04.18.
 */

public class GetVideosSuccessEvent {

    private List<VideoRO> videoRO;

    public GetVideosSuccessEvent(List<VideoRO> videoRO) {
        this.videoRO = videoRO;
    }

    public List<VideoRO> getVideoRO() {
        return videoRO;
    }
}

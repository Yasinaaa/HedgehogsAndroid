package ru.android.hedgehogs.network.events.get_videos;

import ru.android.hedgehogs.network.events.base.BaseErrorEvent;

/**
 * Created by yasina on 06.04.18.
 */

public class GetVideosErrorEvent extends BaseErrorEvent{

    public GetVideosErrorEvent(int responseCode, String message) {
        super(responseCode, message);
    }
}

package ru.android.hedgehogs.network.events.download_video;

import okhttp3.ResponseBody;

/**
 * Created by yasina on 06.04.18.
 */

public class DownloadVideoSuccessEvent {

    private ResponseBody file;

    public DownloadVideoSuccessEvent(ResponseBody file) {
        this.file = file;
    }

    public ResponseBody getFile() {
        return file;
    }

    public void setFile(ResponseBody file) {
        this.file = file;
    }
}

package ru.android.hedgehogs.main.videos.item;

import android.app.Activity;
import android.util.Log;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.network.actions.ActionDownloadVideo;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoErrorEvent;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoSuccessEvent;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 06.04.18.
 */

public class ItemVideoPresenter extends BasePresenter<ItemVideoView.View>
        implements ItemVideoView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;
    private String mTitle;

    public ItemVideoPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }

    @Override
    public void downloadVideo(int id, String title) {
        if (title == null)
            title = "temp";
        mTitle = mActivity.getExternalFilesDir(null) +
                File.separator + title + ".mp4";
        getView().showDownloadVideo();
        getView().startAction(new ActionDownloadVideo(mToken, id));
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DownloadVideoErrorEvent event) {
        Log.d("f", "ff");

    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(DownloadVideoSuccessEvent event) {
        Log.d("f", "ff2");
        writeResponseBodyToDisk(event.getFile());
        getView().showVideoDownloadingFinished(mTitle);
    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        try {
            File futureStudioIconFile = new File(mTitle);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}

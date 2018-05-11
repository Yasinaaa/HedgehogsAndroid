package ru.android.hedgehogs.main.load;

import android.app.Activity;
import android.app.AlertDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.network.actions.ActionGetUserVideos;
import ru.android.hedgehogs.network.actions.ActionSendVideo;
import ru.android.hedgehogs.network.events.get_videos.GetVideosErrorEvent;
import ru.android.hedgehogs.network.events.get_videos.GetVideosSuccessEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoErrorEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoSuccessEvent;
import ru.android.hedgehogs.utils.AndroidUtils;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 06.04.18.
 */

public class LoadPresenter extends BasePresenter<LoadView.View>
        implements LoadView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public LoadPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
    }

    @Override
    public void sendVideo(String path, String title) {
        if (path != null)
            sendVideo(path,title, 720, 1, "mb", "ei_5z7p9944:APA91bEn0tRZs418cQjG6VkYgEyqRHyaWuBRkr-pkmEcsofCTiN8FDezItANTdMBqzrKnApsHVSZNDnurFcQCnK8AOxCYafYMwqGIBSAbYStYD3FJedyc4v_dgTIwQGoT3ugyYwCiVtp");
    }

    @Override
    public void sendVideo(String path, String title, int quality, int originalSize, String originalSizeType, String deviceId) {
        getView().showLoading();
        ActionSendVideo actionSendVideo = new ActionSendVideo(
                mToken, path, title, quality, originalSize, originalSizeType, deviceId);
        getView().startAction(actionSendVideo);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SendVideoSuccessEvent event) {
        getView().hideLoading();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mActivity)
                .setTitle("Message")
                .setMessage("Video successfully send")
                .setCancelable(true);
        alertDialogBuilder.show();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SendVideoErrorEvent event) {

    }
}

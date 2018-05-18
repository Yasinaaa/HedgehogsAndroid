package ru.android.hedgehogs.main.videos.item;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.main.download.DownloadActivity;
import ru.android.hedgehogs.notification.NotificationHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class ItemVideoActivity extends BaseActivity<ItemVideoView.View, ItemVideoView.Presenter>
        implements ItemVideoView.View{

    @BindView(R.id.videoview)
    VideoView mVideoView;
    @BindView(R.id.iv_video)
    ImageView mIvVideo;
    @BindView(R.id.iv_icon_video)
    ImageView mIvIconVideo;
    @BindView(R.id.iv_icon)
    ImageView mIvIcon;
    @BindView(R.id.iv_play)
    ImageView mIvPlay;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_quality)
    TextView mTvQuality;
    @BindView(R.id.tv_original_size)
    TextView mTvOriginalSize;
    @BindView(R.id.tv_current_size)
    TextView mTvCurrentSize;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.et_description)
    EditText mEtDescription;
    @BindView(R.id.tv_description_num)
    TextView mTvDescriptionNum;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.iv_share_play)
    ImageView mIvSharePlay;
    @BindView(R.id.tv_share)
    TextView mTvShare;

    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @NonNull
    @Override
    public ItemVideoView.Presenter createPresenter() {
        return new ItemVideoPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        mController = new MediaController(this);

        presenter.downloadVideo(getIntent().getIntExtra("device_id", 0),
                getIntent().getStringExtra("title_name"));
    }

    @OnClick(R.id.iv_icon)
    protected void onIconDownloadClick(){
        Intent intent = new Intent(ItemVideoActivity.this, DownloadActivity.class);
        startActivity(intent);
    }
    AlertDialog showLoadingBuilder;
    @Override
    public void showDownloadVideo() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View downloadView = layoutInflater.inflate(R.layout.dialog_download, null);
        showLoadingBuilder = new AlertDialog.Builder(this)
                .setView(downloadView)
                .setCancelable(true).create();
        showLoadingBuilder.show();
    }

    @Override
    public void showVideoDownloadingFinished(String path) {
        Uri u = Uri.fromFile(new File(path));
        mVideoView.setVideoURI(u);
        mController.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(mController);
        final int[] position = {0};
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            public void onPrepared(MediaPlayer mediaPlayer)
            {
                if (position[0] == 0)
                {
                    mVideoView.start();
                    position[0] = 1;
                } else
                {
                    mVideoView.pause();
                    position[0] = 0;
                }
            }
        });
        showLoadingBuilder.cancel();
    }
}

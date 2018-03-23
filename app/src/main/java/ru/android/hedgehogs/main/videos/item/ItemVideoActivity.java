package ru.android.hedgehogs.main.videos.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.download.DownloadActivity;
import ru.android.hedgehogs.notification.NotificationHelper;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class ItemVideoActivity extends AppCompatActivity {

    //@BindView(R.id.videoview)
    //VideoView mVideoview;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        NotificationHelper.scheduleNotification(getApplicationContext(), Calendar.getInstance());
    }

    @OnClick(R.id.iv_icon)
    protected void onIconDownloadClick(){
        Intent intent = new Intent(ItemVideoActivity.this, DownloadActivity.class);
        startActivity(intent);
    }
}

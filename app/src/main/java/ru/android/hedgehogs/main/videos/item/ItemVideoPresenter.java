package ru.android.hedgehogs.main.videos.item;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */

public class ItemVideoPresenter extends BasePresenter<ItemVideoView.View>
        implements ItemVideoView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public ItemVideoPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}

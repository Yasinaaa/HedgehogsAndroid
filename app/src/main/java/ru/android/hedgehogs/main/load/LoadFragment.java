package ru.android.hedgehogs.main.load;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseFragment;
import ru.android.hedgehogs.utils.AndroidUtils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by yasina on 22.03.18.
 */

public class LoadFragment extends BaseFragment<LoadView.View, LoadView.Presenter>
        implements LoadView.View {

    private final int REQUEST_TAKE_GALLERY_VIDEO = 33;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.tv_quality)
    TextView mTvQuality;
    @BindView(R.id.rg_format_1080)
    RadioButton mRgFormat1080;
    @BindView(R.id.rg_format_720)
    RadioButton mRgFormat720;
    @BindView(R.id.rg_format_480)
    RadioButton mRgFormat480;
    @BindView(R.id.tv_add_video)
    TextView mTvAddVideo;
    @BindView(R.id.ib_plus_box)
    ImageButton mIbPlusBox;
    @BindView(R.id.iv_hedgehog)
    ImageView mIvHedgehog;
    @BindView(R.id.tv_add)
    TextView mTvAdd;

    @Override
    public LoadView.Presenter createPresenter() {
        return new LoadPresenter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_load, container,
                false);

        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.sendVideo(null, null);
        mIbPlusBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_TAKE_GALLERY_VIDEO);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO) {
                Uri selectedImageUri = data.getData();
                Uri selectedVideo = data.getData();
                presenter.sendVideo(getPath(selectedImageUri.toString()), mEtTitle.getText().toString());
            }
        }
    }

    public String getPath(String p) {
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(Uri.parse(p), projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

}

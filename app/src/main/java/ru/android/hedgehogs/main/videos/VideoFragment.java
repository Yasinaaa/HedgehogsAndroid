package ru.android.hedgehogs.main.videos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseFragment;
import ru.android.hedgehogs.main.videos.adapter.Video;
import ru.android.hedgehogs.main.videos.adapter.VideosAdapter;
import ru.android.hedgehogs.main.videos.item.ItemVideoActivity;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 22.03.18.
 */

public class VideoFragment extends BaseFragment<VideoView.View, VideoView.Presenter>
        implements VideoView.View {

    @BindView(R.id.rv)
    RecyclerView mRv;

    private VideosAdapter mVideosAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getVideos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_videos, container,
                false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public VideoView.Presenter createPresenter() {
        return new VideoPresenter(getActivity());
    }

    @Override
    public void setAdapter(List<VideoRO> list) {
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        /*list.add(new Video(0, "Title1", "mb",
                "mb", null, R.drawable.ex3,
                720, 15, 3, "2:58"));
        list.add(new Video(0, "Title2", "mb",
                "mb", null, R.drawable.ex2,
                720, 35, 16, "2:58"));*/
        mVideosAdapter = new VideosAdapter(list, new VideosAdapter.ItemClickListener() {
            @Override
            public void onClick(VideoRO video) {
                Intent intent = new Intent(getActivity(), ItemVideoActivity.class);
                startActivity(intent);
            }
        });
        mRv.setAdapter(mVideosAdapter);
    }
}

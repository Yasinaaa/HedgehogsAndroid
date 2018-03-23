package ru.android.hedgehogs.main.videos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.videos.item.ItemVideoActivity;

/**
 * Created by yasina on 22.03.18.
 */

public class VideoFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView mRv;

    private View mView;
    private VideosAdapter mVideosAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_videos, container,
                false);
        ButterKnife.bind(this, mView);

        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Video> list = new ArrayList<>();
        list.add(new Video(0, "Title1", "mb",
                "mb", null, R.drawable.ex3,
        720, 15, 3, "2:58"));
        list.add(new Video(0, "Title2", "mb",
                "mb", null, R.drawable.ex2,
                720, 35, 16, "2:58"));
        mVideosAdapter = new VideosAdapter(list, new VideosAdapter.ItemClickListener() {
            @Override
            public void onClick(Video video) {
                Intent intent = new Intent(getActivity(), ItemVideoActivity.class);
                startActivity(intent);
            }
        });
        mRv.setAdapter(mVideosAdapter);
        return mView;
    }
}

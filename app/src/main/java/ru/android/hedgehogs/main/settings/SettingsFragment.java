package ru.android.hedgehogs.main.settings;

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
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.videos.Video;
import ru.android.hedgehogs.main.videos.VideosAdapter;

/**
 * Created by yasina on 22.03.18.
 */

public class SettingsFragment extends Fragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_settings, container,
                false);
        ButterKnife.bind(this, mView);

        return mView;
    }
}

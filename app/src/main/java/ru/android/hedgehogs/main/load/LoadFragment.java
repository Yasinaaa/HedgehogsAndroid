package ru.android.hedgehogs.main.load;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseFragment;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 22.03.18.
 */

public class LoadFragment extends BaseFragment<LoadView.View, LoadView.Presenter>
        implements LoadView.View {

    @Override
    public LoadView.Presenter createPresenter() {
        return new LoadPresenter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_load, container,
                false);
        return mView;
    }

}

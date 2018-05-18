package ru.android.hedgehogs.main.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.sign.SignInActivity;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 22.03.18.
 */

public class SettingsFragment extends Fragment {

    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_verify_password)
    TextView tvVerifyPassword;
    @BindView(R.id.et_verify_password)
    EditText etVerifyPassword;
    @BindView(R.id.tv_old_password)
    TextView tvOldPassword;
    @BindView(R.id.et_old_password)
    EditText etOldPassword;
    @BindView(R.id.tv_regional_options)
    TextView tvRegionalOptions;
    @BindView(R.id.tv_language_title)
    TextView tvLanguageTitle;
    @BindView(R.id.btn_language)
    Button btnLanguage;
    @BindView(R.id.btn_log_out)
    Button btnLogOut;

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_settings, container,
                false);
        ButterKnife.bind(this, mView);
        etUsername.setText(PrefUtils.getEmailToken(getContext()));
        return mView;
    }

    @OnClick(R.id.btn_log_out)
    public void setOnBtnLogOutClick(){
        PrefUtils.saveAuthToken(getContext(),"");
        Intent intent = new Intent(getActivity(), SignInActivity.class);
        startActivity(intent);
    }

}

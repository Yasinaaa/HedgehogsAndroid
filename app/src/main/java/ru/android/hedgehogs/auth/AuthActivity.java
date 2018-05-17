package ru.android.hedgehogs.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.main.MainActivity;
import ru.android.hedgehogs.sign.SignInActivity;
import ru.android.hedgehogs.utils.AndroidUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class AuthActivity extends BaseActivity<AuthInView.View, AuthInView.Presenter>
        implements AuthInView.View {


    @BindView(R.id.tv_username)
    TextView mTvUsername;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.tv_password)
    TextView mTvPassword;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_sign_up)
    Button mBtnSignUp;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @NonNull
    @Override
    public AuthInView.Presenter createPresenter() {
        return new AuthPresenter(this);
    }


    @Override
    public void setRegistration() {

    }

    @Override
    public void openNextView() {
        Intent intent = new Intent(AuthActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.auth(mEtUsername.getText().toString(),
                        mEtPassword.getText().toString());
                //openNextView();
            }
        });
        //presenter.login("admin.admin", "jwtpass");
    }

    @Override
    public void errorView(String text) {
        AndroidUtils.makeErrorDialog(this, text);
    }
}

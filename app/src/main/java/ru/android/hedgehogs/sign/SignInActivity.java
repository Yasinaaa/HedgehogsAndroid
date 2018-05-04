package ru.android.hedgehogs.sign;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.main.MainActivity;
import ru.android.hedgehogs.utils.AndroidUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class SignInActivity extends BaseActivity<SignInView.View, SignInView.Presenter>
        implements SignInView.View {

    @BindView(R.id.iv_logo)
    ImageView mIvLogo;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_sign_up)
    Button mBtnSignUp;
    @BindView(R.id.tv_sign_up_with)
    TextView mTvSignUpWith;
    @BindView(R.id.btn_google)
    Button mBtnGoogle;
    @BindView(R.id.btn_facebook)
    Button mBtnFacebook;
    @BindView(R.id.btn_twitter)
    Button mBtnTwitter;
    @BindView(R.id.btn_vk)
    Button mBtnVk;
    @BindView(R.id.tv_forgot_your_password)
    TextView mTvForgotYourPassword;
    @BindView(R.id.tv_create_account)
    TextView mTvCreateAccount;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @NonNull
    @Override
    public SignInView.Presenter createPresenter() {
        return new SignInPresenter(this);
    }

    @Override
    public void setLogin() {

    }

    @Override
    public void setRegistration() {

    }

    @Override
    public void openNextView() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

        mTvTitle.setShadowLayer(1.5f, -5, -5, Color.BLACK);
        Button button = (Button) findViewById(R.id.btn_sign_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //presenter.login(mEtUsername.getText().toString(),
                  //      mEtPassword.getText().toString());
                openNextView();
            }
        });
        //presenter.login("admin.admin", "jwtpass");
    }

    @Override
    public void errorView(String text) {
        AndroidUtils.makeErrorDialog(this, text);
    }
}

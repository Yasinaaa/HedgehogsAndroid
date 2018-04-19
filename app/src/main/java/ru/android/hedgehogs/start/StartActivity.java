package ru.android.hedgehogs.start;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.base.BaseActivity;
import ru.android.hedgehogs.injection.project.ProjectComponent;
import ru.android.hedgehogs.main.MainActivity;
import ru.android.hedgehogs.sign.SignInActivity;
import ru.android.hedgehogs.utils.PrefUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class StartActivity extends
        BaseActivity<StartView.View, StartView.Presenter>
        implements StartView.View{

    @NonNull
    @Override
    public StartView.Presenter createPresenter() {
        StartPresenter startPresenter = new StartPresenter(this);
        //getComponent(ProjectComponent.class).inject(startPresenter);
        return startPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //getComponent(ProjectComponent.class).inject(this);
        Log.d("d", PrefUtils.getAuthToken(StartActivity.this));
        TextView textView = (TextView) findViewById(R.id.tv_title);
        textView.setShadowLayer(1.5f, -5, -5, Color.BLACK);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = null;
            if (PrefUtils.getAuthToken(StartActivity.this) == null) {
                intent = new Intent(StartActivity.this, SignInActivity.class);
            }else {
                intent = new Intent(StartActivity.this, MainActivity.class);
            }
            startActivity(intent);
            finish();
        }, 0);
        //}, 2000);
    }

    @Override
    public void setLogin() {
        //TODO: show already sign in user
    }

    @Override
    public void setRegistration() {
        //TODO: show Login view
    }
}

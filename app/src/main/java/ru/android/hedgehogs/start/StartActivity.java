package ru.android.hedgehogs.start;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.sign.SignInActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yasina on 20.03.18.
 */

public class StartActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        textView.setShadowLayer(1.5f, -5, -5, Color.BLACK);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(StartActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

    }
}

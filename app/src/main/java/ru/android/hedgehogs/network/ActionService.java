package ru.android.hedgehogs.network;

import android.app.IntentService;
import android.content.Intent;

import ru.android.hedgehogs.network.actions.Action;
import ru.android.hedgehogs.utils.Resources;


public class ActionService extends IntentService {

    private static final String TAG = ActionService.class.getSimpleName();
    public static volatile boolean shouldContinue = true;
    public ActionService() {
    super(TAG);
  }

    @Override
    protected void onHandleIntent(Intent intent) {
      doStuff(intent);
    }

    private void doStuff(Intent intent) {
      Action action = intent.getParcelableExtra(Resources.ACTION_EXTRA);
      action.setContext(getApplicationContext());
      action.execute();

      if (shouldContinue == false) {
        stopSelf();
        return;
      }
      if (shouldContinue == false) {
        stopSelf();
        return;
      }
    }
}

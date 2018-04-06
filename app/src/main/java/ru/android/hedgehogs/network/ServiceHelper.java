package ru.android.hedgehogs.network;

import android.app.Activity;
import android.content.Intent;

import ru.android.hedgehogs.network.actions.Action;
import ru.android.hedgehogs.utils.AndroidUtils;
import ru.android.hedgehogs.utils.Resources;

public class ServiceHelper {

    private static volatile ServiceHelper instance;

    public static ServiceHelper getInstance() {
      if (instance == null) {
        synchronized (ServiceHelper.class) {
          if (instance == null) instance = new ServiceHelper();
        }
      }
      return instance;
    }

    private ServiceHelper() {

    }

    public void startActionService(Activity activity, Action action) {
      ActionService.shouldContinue = true;
      AndroidUtils.hideSoftKeyboard(activity);
      Intent intent = new Intent(activity, ActionService.class);
      intent.putExtra(Resources.ACTION_EXTRA, action);
      activity.startService(intent);
    }

    public void iterruptActionService(Activity activity) {
      ActionService.shouldContinue = false;
    }
}

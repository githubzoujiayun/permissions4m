package com.joker.api.util.manufacturer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * support:
 * 1. oppo a57 android 6.0.1/coloros3.0
 * <p>
 * manager home page, permissions manage page does not work!!!, or
 * {@link Protogenesis#settingIntent(boolean)}
 * <p>
 * Created by joker on 2017/8/4.
 */

public class OPPO implements PermissionsPage {
    private final Context context;
    private final String PKG = "com.coloros.safecenter";
    private final String MANAGER_OUT_CLS = "com.coloros.safecenter.permission.singlepage" +
            ".PermissionSinglePageActivity";

    public OPPO(Context context) {
        this.context = context;
    }

    @Override
    public Intent settingIntent(boolean androidSetting) throws Exception {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(PACK_TAG, context.getPackageName());
        ComponentName comp;
        comp = new ComponentName(PKG, MANAGER_OUT_CLS);
        // do not work!!
//        comp = new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission" + ".PermissionAppAllPermissionActivity");
        intent.setComponent(comp);

        return intent;
    }
}

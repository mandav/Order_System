package com.example.mxix.order_system;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by MXIX on 18-Jan-15.
 */
public class Utils {public static Boolean getBooleanPrefs(Context ctx, String key) {
    return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(key, false);
}

    public static void setBooleanPrefs(Context ctx, String key, Boolean value) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putBoolean(key, value).commit();
    }

    public static String getStringPrefs(Context ctx, String key) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString(key, "");
    }

    public static void setStringPrefs(Context ctx, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putString(key, value).commit();
    }

    public static int getIntPrefs(Context ctx, String key) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(key, 0);
    }

    public static void setIntPrefs(Context ctx, String key, int value) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putInt(key, value).commit();
    }

    public static long getLongPrefs(Context ctx, String key) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getLong(key, 0);
    }

    public static void setLongPrefs(Context ctx, String key, long value) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putLong(key, value).commit();
    }

    public static float getFloatPrefs(Context ctx, String key) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getFloat(key, 0);
    }

    public static void setFloatPrefs(Context ctx, String key, float value) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putFloat(key, value).commit();
    }

    public static void clearPrefs(Context ctx) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().clear().commit();
    }
}

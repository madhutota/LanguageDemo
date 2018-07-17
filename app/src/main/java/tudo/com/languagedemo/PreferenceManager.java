package tudo.com.languagedemo;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREF_NAME = "APP_PREF";

    public static void saveInt(Context context, String key, int value) {
        if (context != null) {
            try {
                SharedPreferences.Editor editor = getSharedPreferences(context).edit();
                editor.putInt(key, value);
                editor.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context
                .MODE_PRIVATE);
        return sharedPreferences;
    }
    public static int getInt(Context context, String key, int defaultValue) {
        if (context != null) {
            int value = getSharedPreferences(context).getInt(key, defaultValue);
            return value;
        } else {
            return 0;
        }
    }
    public static String getLanguage(Context context, int position) {
        String language = "en";
        if (context != null) {
            switch (position) {
                case 0:
                    language = "en";
                    break;
                case 1:
                    language = "hi";
                    break;
                case 2:
                    language = "te";
                    break;
                case 3:
                    language = "gu";
                    break;
                default:
                    return language;
            }
        } else {
            return language;
        }
        return language;

    }
}

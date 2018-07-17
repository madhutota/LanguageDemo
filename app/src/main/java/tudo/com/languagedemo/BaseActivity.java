package tudo.com.languagedemo;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int position = PreferenceManager.getInt(BaseActivity.this, AppConstants.SELECTED_LANGUAGE, 0);
        setLocale(PreferenceManager.getLanguage(BaseActivity.this, position));
    }

    public void setLocale(String lan) {
        Locale myLocale = new Locale(lan);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
}
//Humpty4Dumpty
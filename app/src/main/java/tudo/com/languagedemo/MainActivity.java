package tudo.com.languagedemo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private TextView tv_desc;
    String[] statesList;
    private Spinner spinner;
    List<String> categories;
    int selectedLanguage;
    private RelativeLayout relative_spinner;
    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        selectedLanguage = PreferenceManager.getInt(MainActivity.this, AppConstants.SELECTED_LANGUAGE, 0);

        statesList = getResources().getStringArray(R.array.india_states);
        spinner = findViewById(R.id.spinner_language);

        spinner.setOnItemSelectedListener(this);
        relative_spinner = findViewById(R.id.relative_spinner);
        tv_desc = findViewById(R.id.tv_desc);
       /* btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStatesDialog(MainActivity.this, statesList, tv_language);
            }
        });*/

        categories = new ArrayList<>();
        categories.add("English");
        categories.add("हिंदी");
        categories.add("తెలుగు");
        categories.add("ગુજરાતી");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(selectedLanguage);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (++check > 1) {
            switch (position) {
                case 0:
                    selectedLanguage("en", position);
                    break;
                case 1:
                    selectedLanguage("hi", position);
                    break;
                case 2:
                    selectedLanguage("te", position);
                    break;
                case 3:
                    selectedLanguage("gu", position);
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void selectedLanguage(String lang, int position) {
        PreferenceManager.saveInt(MainActivity.this, AppConstants.SELECTED_LANGUAGE, position);
        getResources().getConfiguration().setLocale(new Locale(lang));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            getApplicationContext().createConfigurationContext(getResources().getConfiguration());
        else
            getResources().updateConfiguration(getResources().getConfiguration(), getResources().getDisplayMetrics());
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

   /* public void showStatesDialog(final Activity context, String[] states, final TextView tv_language) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
        //builderSingle.setIcon(R.drawable.ic_launcher);
        builderSingle.setTitle(getStrings(context, R.string.txt_select));

       *//* ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan();

        // Initialize a new spannable string builder instance
        SpannableStringBuilder ssBuilder = new SpannableStringBuilder(titleText);

        // Apply the text color span
        ssBuilder.setSpan(
                foregroundColorSpan,
                0,
                titleText.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );*//*


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, states);

        builderSingle.setNegativeButton(getStrings(context, R.string.txt_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);

                switch (which) {
                    case 0:
                        selectedLanguage("te");
                        break;
                    case 1:
                        selectedLanguage("hi");
                        break;
                    case 2:
                        selectedLanguage("en");
                        break;
                    case 3:
                        selectedLanguage("ta");
                        break;
                }


                tv_language.setText(strName);

            }
        });
        builderSingle.show();
    }*/

    /**
     * ASSIGN THE STRINGS
     **/
    public static String getStrings(Context context, int id) {
        String value = null;
        if (context != null && id != -1) {
            value = context.getResources().getString(id);
        }
        return value;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void selectedLanguage(String lang) {
        // PreferenceManager.saveInt(LanguageActivity.this, AppConstants.SELECTED_LANGUAGE, position);
        getResources().getConfiguration().setLocale(new Locale(lang));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            getApplicationContext().createConfigurationContext(getResources().getConfiguration());
        else
            getResources().updateConfiguration(getResources().getConfiguration(), getResources().getDisplayMetrics());
        this.recreate();
        // startActivity(new Intent(this, MainActivity.class));
        /// finish();

    }
}

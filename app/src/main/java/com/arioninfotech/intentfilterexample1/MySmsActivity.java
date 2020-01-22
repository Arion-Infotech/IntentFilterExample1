package com.arioninfotech.intentfilterexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MySmsActivity extends AppCompatActivity {

    String output = null;
    TextView lblresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sms);

        lblresult = (TextView) findViewById(R.id.output_intent);

        // take the data and the extras of the intent
        Uri url = getIntent().getData();
        Bundle extras = getIntent().getExtras();

        output = url.toString();
        Log.i("Response","output ="+output);

        // if there are extras, add them to the output string
        if(extras != null){
            output = output + " from "+ extras.getString("from");
        }
        lblresult.setText(output);
    }
}

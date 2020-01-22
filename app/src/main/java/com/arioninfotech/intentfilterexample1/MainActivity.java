package com.arioninfotech.intentfilterexample1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit = (EditText) findViewById(R.id.recipient);

        // Use ACTION_SENDTO action with correct data
        Button sms1 = (Button) findViewById(R.id.sendto_sms);
        sms1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

              /*  String uri = "smsto:" +  edit.getText().toString();
                Intent i = new Intent(android.content.Intent.ACTION_SENDTO,
                        Uri.parse(uri));
                startActivity(i);
           */

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        // Use our custom SMS_INTENT intent with correct data
        Button sms2 = (Button) findViewById(R.id.smsintent_sms);
        sms2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String uri = "smsto:" + edit.getText().toString();
                Intent i = new Intent("com.arioninfotech.SMS_INTENT",
                        Uri.parse(uri));
                // put extra field
                i.putExtra("from", "Arion Infotech");
                startActivity(i);
            }
        });


    }
}

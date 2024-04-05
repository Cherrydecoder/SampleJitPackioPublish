package com.pratice.myjitpacklibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class ModuleTest extends AppCompatActivity {

    EditText username;
    EditText password;
    Button verify;
    String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<KycRes code=\"0989c174cbfa27d65asd93020\" ret=\"Y\" ts=\"2025-07-19T14:27:01.730+05:30\" ttl=\"2025-07-18T14:27:01\" txn=\"UKC:00014532434928042aaa32dfd4230045c03\" info=\"0111112312B/n0lOfrbB+8sPfL6FLUaaBIdUJKiT+N2xs6kQ5TI0c+WMhLIWQu\" uuid=\"637054498999809178\">\n" +
            "\tl̥\t<UidData tkn=\"01111136GuhVZHuCF5EoB/n0lOfrbB+8sUJKiT+N2xs6kQ5TI0c+WMhLIWQu\" uid=\"xxxxxxxx4511\">\n" +
            "\t\t<Poi dob=\"17-07-1994\" gender=\"M\" name=\"Arijit Singh\" />\n" +
            "\t\t<Poa co=\"C/O Lal Singh\" country=\"India\" dist=\"Delhi\" house=\"12/2 Encode Apartments\" pc=\"110053\" state=\"Delhi\" street=\"\" vtc=\"\"/>\n" +
            "\t<LData />\t\n" +
            "\t</UidData>\t\n" +
            "</KycRes>";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moduletest);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        verify = findViewById(R.id.verify);

        verify.setOnClickListener(v -> {
            if (!username.getText().toString().trim().isEmpty() || username.getText().toString().trim().length() == 6) {
                if (!password.getText().toString().trim().isEmpty() || password.getText().toString().trim().length() == 10) {
                    try {
                        JSONObject jsonObject = XML.toJSONObject(xmlData);
                        JSONObject parsingData = jsonObject.getJSONObject("KycRes");
                        Intent intent = new Intent();
                        intent.putExtra("response", parsingData.toString());
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        setResult(RESULT_OK, intent);
                        finish();
                    } catch (JSONException e) {

                        Log.e("SecondActivityModule", "JSONException: " + e.getMessage());
                        e.printStackTrace();
                        setResult(RESULT_CANCELED);
                        finish();
                    }
                } else
                    Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show();
        });

    }
}

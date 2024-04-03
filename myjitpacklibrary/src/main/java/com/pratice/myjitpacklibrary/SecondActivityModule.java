package com.pratice.myjitpacklibrary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivityModule extends AppCompatActivity {
    TextView clickHere;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondmodule);

        /*clickHere = findViewById(R.id.clickHere);
        clickHere.setOnClickListener(v -> {
            try {
                JSONObject jsonObject = XML.toJSONObject(xmlData);
                JSONObject parsingData = jsonObject.getJSONObject("KycRes");
                Intent intent = new Intent();
                intent.putExtra("response", parsingData.toString());
                setResult(100, intent);
                finish();

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });*/

    }
}

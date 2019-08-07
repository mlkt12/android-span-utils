package com.mlkt.development.spanutils;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.text))
                .setText(SpanUtils.Builder("Text")
                .itallic()
                .bold()
                .underline()
                .size(30)
                .color(Color.RED)
                .background(Color.YELLOW)
                .build());
    }
}

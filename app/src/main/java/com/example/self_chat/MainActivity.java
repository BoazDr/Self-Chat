package com.example.self_chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity{
    private TextView myTextView;
    private static final String TEXT_VALUE = "textValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.plain_text_input);
        Button sendButton = findViewById(R.id.send_button);
        myTextView = textView;

        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence(TEXT_VALUE);
            textView.setText(savedText);
        }
        
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_text = editText.getText().toString();
                editText.setText("");
                textView.setText(input_text);
            }
        });
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(TEXT_VALUE, myTextView.getText());
    }
}
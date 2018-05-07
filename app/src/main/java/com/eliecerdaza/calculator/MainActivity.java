package com.eliecerdaza.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText resultText = findViewById(R.id.editText);
        resultText.setKeyListener(null);
    }

    /* Evento para agregar numeros al texto  */
    public void addNumberToCurrentText(View view){
        EditText resultText = findViewById(R.id.editText);
        String content = resultText.getText().toString();
        if(content.equals("0")){
            resultText.setText(((Button) view).getText().toString());
        }
        else{
            resultText.setText(content.concat(((Button) view).getText().toString()));
        }
    }

    /* Evento para limpiar el input */
    public void clearEditContent(View view){
        EditText resultText = findViewById(R.id.editText);
        resultText.setText(R.string.valor_inicial_cero);
    }
}

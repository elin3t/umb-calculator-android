package com.eliecerdaza.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String actual_value = "0";
    private String actual_operation = "";

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
        if(content.equals("0") || this.actual_operation.equals("=")){
            resultText.setText(((Button) view).getText().toString());
            if(this.actual_operation.equals("=")) this.actual_operation = "";
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

    /* Evento para agregar punto al text */
    public void addDot(View view){
        EditText resultText = findViewById(R.id.editText);
        String content = resultText.getText().toString();
        if(content.indexOf('.') == -1){
            resultText.setText(content.concat("."));
        }
    }

    /* Evento para cambio de signo */
    public void changeSign(View view){
        EditText resultText = findViewById(R.id.editText);
        String content = resultText.getText().toString();
        if(content.equals("0")) return;
        if(content.indexOf('-') == -1 ){
            String num = "-".concat(content);
            resultText.setText(num);
        }else{
            resultText.setText(content.substring(1));
        }
    }

    /* Evento para suma */
    public void addButtonClicked(View view){
        EditText resultText = findViewById(R.id.editText);
        this.actual_value = resultText.getText().toString();
        this.actual_operation = "+";
        resultText.setText(R.string.valor_inicial_cero);
    }

    /* Evento para resta */
    public void subtractButtonClicked(View view){
        EditText resultText = findViewById(R.id.editText);
        this.actual_value = resultText.getText().toString();
        this.actual_operation = "-";
        resultText.setText(R.string.valor_inicial_cero);
    }

    /* Evento para multiplicar */
    public void multiplyButtonClicked(View view){
        EditText resultText = findViewById(R.id.editText);
        this.actual_value = resultText.getText().toString();
        this.actual_operation = "*";
        resultText.setText(R.string.valor_inicial_cero);
    }

    /* Evento para dividir */
    public void divisionButtonClicked(View view){
        EditText resultText = findViewById(R.id.editText);
        this.actual_value = resultText.getText().toString();
        this.actual_operation = "/";
        resultText.setText(R.string.valor_inicial_cero);
    }

    /* Evento para porcentaje */
    public void percentButtonClicked(View view){
        EditText resultText = findViewById(R.id.editText);
        this.actual_value = resultText.getText().toString();
        this.actual_operation = "%";
        resultText.setText(R.string.valor_inicial_cero);
    }

    public void errorDividebyZero() {
        Toast toast = Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

    }

    /* Evento para igual */
    public void calculateResult(View view){
        EditText resultText = findViewById(R.id.editText);
        if(this.actual_operation.equals("+")){
            float resultado = Float.valueOf(this.actual_value) + Float.valueOf(resultText.getText().toString());
            resultText.setText(String.valueOf(resultado));
        }
        else if(this.actual_operation.equals("-")){
            float resultado = Float.valueOf(this.actual_value) - Float.valueOf(resultText.getText().toString());
            resultText.setText(String.valueOf(resultado));
        }
        else if(this.actual_operation.equals("*")){
            float resultado = Float.valueOf(this.actual_value) * Float.valueOf(resultText.getText().toString());
            resultText.setText(String.valueOf(resultado));
        }
        else if(this.actual_operation.equals("/")){
            if(resultText.getText().toString().equals("0")) {
                errorDividebyZero();
                resultText.setText(R.string.valor_inicial_cero);
            }
            else {

                float resultado = Float.valueOf(this.actual_value) / Float.valueOf(resultText.getText().toString());
                resultText.setText(String.valueOf(resultado));
            }
        }
        else if(this.actual_operation.equals("%")){
            float resultado = (Float.valueOf(this.actual_value)/100) * Float.valueOf(resultText.getText().toString());
            resultText.setText(String.valueOf(resultado));
        }

        this.actual_operation = "=";
    }




}

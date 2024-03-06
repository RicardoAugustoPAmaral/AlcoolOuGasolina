package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean CamposValidados =validarCampos(precoAlcool,precoGasolina);

        if(CamposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);


            if(valorAlcool/valorGasolina>=0.7){
                textResultado.setText("Abasteça com Gasolina");

            }else {
                textResultado.setText("Abasteça com Álcool");
            }


        }else {
            textResultado.setText("Preencha os campos primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool,String pGasolina){
        Boolean camposValidos = true;
        if(pAlcool==null || pAlcool.equals("")){
            camposValidos = false;
        }else if(pGasolina==null || pGasolina.equals("")){
            camposValidos = false;
        }
        return  camposValidos;

    }
}
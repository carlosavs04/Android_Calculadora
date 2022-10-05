package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnCero, btnSuma, btnResta, btnMult, btnDivision, btnModulo, btnNegativo, btnIgual, btnDecimal, btnClear, btnBorrar;
    EditText resultado;
    TextView historial;
    boolean unNL = false;
    double valor1 = 0, valor2 = 0;
    Operacion operacion = Operacion.NoDefinida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        btnUno = (Button) findViewById(R.id.btnUno);
        btnDos = (Button) findViewById(R.id.btnDos);
        btnTres = (Button) findViewById(R.id.btnTres);
        btnCuatro = (Button) findViewById(R.id.btnCuatro);
        btnCinco = (Button) findViewById(R.id.btnCinco);
        btnSeis = (Button) findViewById(R.id.btnSeis);
        btnSiete = (Button) findViewById(R.id.btnSiete);
        btnOcho = (Button) findViewById(R.id.btnOcho);
        btnNueve = (Button) findViewById(R.id.btnNueve);
        btnCero = (Button) findViewById(R.id.btnCero);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnModulo = (Button) findViewById(R.id.btnModulo);
        btnNegativo = (Button) findViewById(R.id.btnNegativo);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        resultado = (EditText) findViewById(R.id.resultado);
        historial = (TextView) findViewById(R.id.historial);

        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);
        btnCero.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnModulo.setOnClickListener(this);
        btnNegativo.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnUno) {
            Lectura("1");
        }

        if (view.getId() == R.id.btnDos) {
            Lectura("2");
        }

        if (view.getId() == R.id.btnTres) {
            Lectura("3");
        }

        if (view.getId() == R.id.btnCuatro) {
            Lectura("4");
        }

        if (view.getId() == R.id.btnCinco) {
            Lectura("5");
        }

        if (view.getId() == R.id.btnSeis) {
            Lectura("6");
        }

        if (view.getId() == R.id.btnSiete) {
            Lectura("7");
        }

        if (view.getId() == R.id.btnOcho) {
            Lectura("8");
        }

        if (view.getId() == R.id.btnNueve) {
            Lectura("9");
        }

        if (view.getId() == R.id.btnCero) {
            Lectura("0");
        }

        if(view.getId() == R.id.btnIgual) {
            if(valor2 == 0)
            {
                valor2 = Double.parseDouble(resultado.getText().toString());
                historial.setText(valor2 + "=");
                double result = EjecutarOperacion();
                resultado.setText(""+ result);
                valor1 = 0;
                valor2 = 0;
                unNL = false;
            }
        }

        if(view.getId() == R.id.btnResta)
        {
            if(valor1 == 0)
            {
                valor1 = Double.parseDouble(resultado.getText().toString());
            }
            operacion = Operacion.enumResta;
            ObtenerValor("-");
        }

        if(view.getId() == R.id.btnSuma)
        {
            if(valor1 == 0)
            {
                valor1 = Double.parseDouble(resultado.getText().toString());
            }
            operacion = Operacion.enumSuma;
            ObtenerValor("+");
        }

        if(view.getId() == R.id.btnMult)
        {
            if(valor1 == 0)
            {
                valor1 = Double.parseDouble(resultado.getText().toString());
            }
            operacion = Operacion.enumMultiplicacion;
            ObtenerValor("X");
        }

        if(view.getId() == R.id.btnDivision)
        {
            if(valor1 == 0)
            {
                valor1 = Double.parseDouble(resultado.getText().toString());
            }
            operacion = Operacion.enumDivision;
            ObtenerValor("/");
        }

        if(view.getId() == R.id.btnModulo)
        {
            if(valor1 == 0)
            {
                valor1 = Double.parseDouble(resultado.getText().toString());
            }

            operacion = Operacion.enumResta;
            ObtenerValor("%");
        }

        if(view.getId() == R.id.btnClear)
        {
            resultado.setText("0");
            historial.setText("");
            valor1 = 0;
            valor2 = 0;
        }

        if(view.getId() == R.id.btnBorrar)
        {
            if(resultado.getText().length() > 1)
            {
                String txtResultado = resultado.getText().toString();
                txtResultado = txtResultado.substring(0, txtResultado.length() - 1);

                if(txtResultado.length() == 1 && txtResultado.contains("-"))
                {
                    resultado.setText("0");
                }

                else
                {
                    resultado.setText(txtResultado.toString());
                }
            }

            else
            {
                resultado.setText("0");
            }
        }

        if(view.getId() == R.id.btnDecimal)
        {
            if(resultado.getText().toString().contains("."))
            {
                return;
            }

            resultado.setText(resultado.getText().toString() + ".");
        }

        if(view.getId() == R.id.btnNegativo)
        {
            if(resultado.getText().toString().contains("-") || resultado.getText().toString().equals("0"))
            {
                return;
            }

            resultado.setText("-" + resultado.getText().toString());
        }
    }

    private void Lectura(String numero) {

        if (resultado.getText().toString().equals("0") && resultado.getText() != null) {
            resultado.setText(numero);
        } else {
            resultado.setText(resultado.getText().toString() + numero);
        }
    }

    public enum Operacion {
        NoDefinida,
        enumSuma,
        enumResta,
        enumDivision,
        enumMultiplicacion,
        enumModulo;
    }

    public double EjecutarOperacion() {
        double result = 0;

        switch (operacion) {
            case enumSuma:
                result = valor1 + valor2;
                break;

            case enumResta:
                result = valor1 - valor2;
                break;

            case enumDivision:
                if (valor2 == 0) {
                    resultado.setText("No es posible dividir entre 0");
                    result = 0;
                } else {
                    result = valor1 / valor2;
                }
                break;

            case enumMultiplicacion:
                result = valor1 * valor2;
                break;

            case enumModulo:
                result = valor1 % valor2;
                break;
        }

        return result;
    }

    private void ObtenerValor(String operador)
    {
        historial.setText("" + valor1 + operador);
        resultado.setText("0");
    }
}






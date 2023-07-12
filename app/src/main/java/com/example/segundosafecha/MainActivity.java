package com.example.segundosafecha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.segundosafecha.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public int segundosConvertir,entradaSegundos, dias, horas, minutos, segundos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorInicial();
                if(binding.edtSegundos.getText().toString().equals(""))
                {
                    limpiarFormulario();
                    Toast.makeText(MainActivity.this, "La cantidad de segundos es incorrecta", Toast.LENGTH_LONG).show();
                }else {
                    entradaSegundos = Integer.parseInt(binding.edtSegundos.getText().toString());
                    segundosConvertir = entradaSegundos;
                    if(entradaSegundos == 0)
                    {
                        limpiarFormulario();
                        Toast.makeText(MainActivity.this, "La cantidad "+ entradaSegundos +" segundos es incorrecta", Toast.LENGTH_LONG).show();
                    }

                    if(entradaSegundos >= 86400)
                    {
                        dias = entradaSegundos/86400;
                        entradaSegundos = entradaSegundos - (dias * 86400);
                    }

                    horas = entradaSegundos/3600;
                    int faltante = entradaSegundos - (horas * 3600);
                    if(faltante > 0)
                    {
                        minutos = (faltante/60);
                        segundos = faltante - (minutos * 60);
                    }

                    binding.lnlSegundosConvertidos.setVisibility(View.VISIBLE);
                    binding.txvSegundosConvertidos.setText(String.valueOf(segundosConvertir));
                    binding.txvResultadoDias.setText(String.valueOf(dias));
                    binding.txvResultadoHoras.setText(String.valueOf(horas));
                    binding.txvResultadoMinutos.setText(String.valueOf(minutos));
                    binding.txvResultadoSegundos.setText(String.valueOf(segundos));

                    binding.edtSegundos.setText("");

                }

            }
        });
    }

    public void limpiarFormulario()
    {
        binding.lnlSegundosConvertidos.setVisibility(View.GONE);
        binding.txvResultadoDias.setText("");
        binding.txvResultadoHoras.setText("");
        binding.txvResultadoMinutos.setText("");
        binding.txvResultadoSegundos.setText("");
    }

    public void valorInicial()
    {
        segundosConvertir = 0;
        entradaSegundos= 0;
        dias= 0;
        horas= 0;
        minutos= 0;
        segundos= 0;
    }

}
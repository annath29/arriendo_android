package com.example.arriendo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jethabitaciones;
    TextView jtvtotal,jtvinmueble,jtvparqueadero,jtvhabitacion;
    RadioButton jrbcasa,jrbapartamento,jrbfinca;
    CheckBox jcbparqueadero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jethabitaciones=findViewById(R.id.ethabitaciones);
        jtvinmueble=findViewById(R.id.tvinmueble);
        jtvparqueadero=findViewById(R.id.tvvparqueadero);
        jtvtotal=findViewById(R.id.tvtotal);
        jrbcasa=findViewById(R.id.rbcasa);
        jrbapartamento=findViewById(R.id.rbapartamento);
        jrbfinca=findViewById(R.id.rbapartamento);
        jcbparqueadero=findViewById(R.id.cbparqueadero);
        jtvhabitacion=findViewById(R.id.tvhabitacion);
    }

    public void Calcular(View view){
        String cant_habitaciones=jethabitaciones.getText().toString();

        if (cant_habitaciones.isEmpty())
        {
            Toast.makeText(this, "ingrese la cantidad de habitaciones", Toast.LENGTH_SHORT).show();
            jethabitaciones.requestFocus();
        }
        else
        {
            int cantidad,total,val_habitaciones = 0,val_parqueadero,val_inmueble;
            cantidad=Integer.parseInt(cant_habitaciones);

            //habitaciones adicionales
            if (cantidad<1)
            {
                Toast.makeText(this, "ingrese una cantidad de habitaciones superior a 1", Toast.LENGTH_SHORT).show();
                jethabitaciones.requestFocus();
            }
            else
            {
                if (cantidad<3)
                {
                    val_habitaciones=100000;
                    jtvhabitacion.setText("100000");
                }
                else
                {
                    if (cantidad<4)
                    {
                        val_habitaciones=200000;
                        jtvhabitacion.setText("200000");
                    }
                    else {
                        val_habitaciones=200000;
                        jtvhabitacion.setText("200000");
                    }
                }
            }

            //parqueadero
            if (jcbparqueadero.isChecked())
            {
                jtvparqueadero.setText("100000");
                val_parqueadero=100000;
            }
            else{
                jtvparqueadero.setText("0");
                val_parqueadero=0;
            }
            //seleccion de vivienda

            if (jrbcasa.isChecked()){
                jtvinmueble.setText("400000");
                val_inmueble=400000;
            }
            else
            {
                if (jrbfinca.isChecked())
                {
                    jtvinmueble.setText("600000");
                    val_inmueble=600000;
                }
                else
                {
                    jtvinmueble.setText("300000");
                    val_inmueble=400000;
                }
            }
            //valor total
            total=val_inmueble+val_habitaciones+val_parqueadero;
            jtvtotal.setText(String.valueOf(total));
        }
    }

    public void limpia(View view)
    {
        jtvtotal.setText("0");
        jtvinmueble.setText("400000");
        jtvhabitacion.setText("0");
        jtvparqueadero.setText("0");
        jrbcasa.setChecked(true);
        jcbparqueadero.setChecked(false);
        jethabitaciones.setText("");
    }
}
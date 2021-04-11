package sv.edu.udb.desafio2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import sv.edu.udb.desafio2.Detalle;
public class AddDetalleActivity extends Activity {
    TextView txtnombre, txthora, txtfecha, txtprecio;
    String key="",nombre="",precio="",fecha="",ho="", accion="";
    Button btnfecha, btnhora;
    int cyear, cday, cmonth;
    int chour,cminute;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detalle);
        inicializar();
    }
    private void inicializar() {
        txtnombre = findViewById(R.id.txtnombre);
        txtprecio = findViewById(R.id.txtprecio);
        txtfecha = findViewById(R.id.txtfecha);
        txthora = findViewById(R.id.txthora);
        btnfecha = findViewById(R.id.btnfecha);
        btnhora = findViewById(R.id.btnhora);

        btnfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar=Calendar.getInstance();
                cyear = calendar.get(Calendar.YEAR);
                cmonth = calendar.get(Calendar.MONTH);
                cday = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddDetalleActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtfecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },cyear,cmonth,cday);
                datePickerDialog.show();
            }
        });

        btnhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  Calendar calendar = Calendar.getInstance();
                chour=calendar.get(Calendar.HOUR_OF_DAY);
                cminute=calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddDetalleActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txthora.setText(hourOfDay+":"+minute);
                    }
                },chour,cminute,false);
                timePickerDialog.show();
            }
        });

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        nombre = datos.getString("nombre");
        precio=datos.getString("precio");
        fecha=datos.getString("fecha");
        ho=datos.getString("hora");

        accion=datos.getString("accion");
        txtnombre.setText(nombre);
        txtprecio.setText(precio);
        txtfecha.setText(fecha);
        txthora.setText(ho);


    }

    public void guardar(View v){
        String nombre = txtnombre.getText().toString();
        String precio = txtprecio.getText().toString();
        String fecha = txtfecha.getText().toString();
        String ho = txthora.getText().toString();
        // Se forma objeto Detalle
        Detalle detalle = new Detalle(nombre,precio,fecha,ho);

        if (accion.equals("a")) { //Agregar usando push()
            DetalleActivity.refDetalle.push().setValue(detalle);
            Toast.makeText(getApplicationContext(), "Su cita ha sido agendada.", Toast.LENGTH_LONG).show();
        }
        else // Editar usando setValue
        {
            DetalleActivity.refDetalle.child(key).setValue(detalle);
            Toast.makeText(getApplicationContext(), "Su cita se ha modificado.", Toast.LENGTH_LONG).show();
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }
}

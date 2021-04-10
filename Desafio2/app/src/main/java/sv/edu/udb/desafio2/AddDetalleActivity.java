package sv.edu.udb.desafio2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import sv.edu.udb.desafio2.Detalle;
public class AddDetalleActivity extends AppCompatActivity{
    TextView txtnombre, txthora, txtfecha, txtprecio;
    String key="",nombre="",precio="",fecha="",ho="", accion="";
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
        }
        else // Editar usando setValue
        {
            DetalleActivity.refDetalle.child(key).setValue(detalle);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }
}

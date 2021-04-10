package sv.edu.udb.desafio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class principal extends Activity {
private Button btnInicio, btnDetalle, btnUsuario;
        Button btnagregar1,btnagregar2,btnagregar3,btnagregar4,btnagregar5,btnagregar6,btnagregar7,btnagregar8,btnagregar9,btnagregar;
        TextView txtnombre,txtnombre1,txtnombre2,txtnombre3,txtnombre4,txtnombre5,txtnombre6,txtnombre7,txtnombre8,txtnombre9;
        TextView txtprecio,txtprecio1,txtprecio2,txtprecio3,txtprecio4,txtprecio5,txtprecio6,txtprecio7,txtprecio8,txtprecio9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initializeUI();

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), principal.class);
                startActivity(intent);
                finish();
            }
        });
        
        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Perfil.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initializeUI() {
        btnInicio = findViewById(R.id.btninicio);
        btnDetalle = findViewById(R.id.btndetalle);
        btnUsuario = findViewById(R.id.btnusuario);
        btnagregar= findViewById(R.id.btnagregar);
        txtprecio= findViewById(R.id.txtprecio);
        txtnombre= findViewById(R.id.txtnombre);
        btnagregar1= findViewById(R.id.btnagregar1);
        txtprecio1= findViewById(R.id.txtprecio1);
        txtnombre1= findViewById(R.id.txtnombre1);
        btnagregar2= findViewById(R.id.btnagregar2);
        txtprecio2= findViewById(R.id.txtprecio2);
        txtnombre2= findViewById(R.id.txtnombre2);
        btnagregar3= findViewById(R.id.btnagregar3);
        txtprecio3= findViewById(R.id.txtprecio3);
        txtnombre3= findViewById(R.id.txtnombre3);
        btnagregar4= findViewById(R.id.btnagregar4);
        txtprecio4= findViewById(R.id.txtprecio4);
        txtnombre4= findViewById(R.id.txtnombre4);
        btnagregar5= findViewById(R.id.btnagregar5);
        txtprecio5= findViewById(R.id.txtprecio5);
        txtnombre5= findViewById(R.id.txtnombre5);
        btnagregar6= findViewById(R.id.btnagregar6);
        txtprecio6= findViewById(R.id.txtprecio6);
        txtnombre6= findViewById(R.id.txtnombre6);
        btnagregar7= findViewById(R.id.btnagregar7);
        txtprecio7= findViewById(R.id.txtprecio7);
        txtnombre7= findViewById(R.id.txtnombre7);
        btnagregar8= findViewById(R.id.btnagregar8);
        txtprecio8= findViewById(R.id.txtprecio8);
        txtnombre8= findViewById(R.id.txtnombre8);
        btnagregar9= findViewById(R.id.btnagregar9);
        txtprecio9= findViewById(R.id.txtprecio9);
        txtnombre9= findViewById(R.id.txtnombre9);

        btnagregar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","MICROEEDLING");
                i.putExtra("precio","$90");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","KAULA");
                i.putExtra("precio","$45");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","RADIOFECUENCIA");
                i.putExtra("precio","$89");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","FOTOBOLTAICA");
                i.putExtra("precio","$100");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","POETRY MASAJE");
                i.putExtra("precio","$180");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","MESOTERAPIA ANTIOXIDANTE");
                i.putExtra("precio","$180");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","EXFOLIANTE PURIFICANTE");
                i.putExtra("precio","$60");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","PEDICURA MEDICA");
                i.putExtra("precio","$185");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","PRAMASAMA");
                i.putExtra("precio","$35");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario quiere agregar un nuevo registro
                Intent i = new Intent(getBaseContext(), AddDetalleActivity.class);
                i.putExtra("accion","a"); // Agregar
                i.putExtra("key","");
                i.putExtra("nombre","LUMINOSIDAD EXPRES");
                i.putExtra("precio","$50");
                i.putExtra("fecha","");
                i.putExtra("hora","");
                startActivity(i);
            }
        });


    }

}
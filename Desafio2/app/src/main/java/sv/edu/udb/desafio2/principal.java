package sv.edu.udb.desafio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class principal extends Activity {
private Button btnInicio, btnDetalle, btnUsuario;

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
    }

}
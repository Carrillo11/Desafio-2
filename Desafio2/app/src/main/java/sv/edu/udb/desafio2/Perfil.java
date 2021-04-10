package sv.edu.udb.desafio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Perfil extends Activity {
    private Button btnInicio, btnDetalle, btnUsuario, btnLogOut;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

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
                Intent intent = new Intent(getApplicationContext(), detalle.class);
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

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Perfil.this, login.class));
            }
        });
    }

    private void initializeUI() {
        btnInicio = findViewById(R.id.btninicio);
        btnDetalle = findViewById(R.id.btndetalle);
        btnUsuario = findViewById(R.id.btnusuario);
        btnLogOut = findViewById(R.id.btnsalir);

    }
}
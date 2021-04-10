package sv.edu.udb.desafio2;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import sv.edu.udb.desafio2.Detalle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class DetalleActivity extends Activity {
    private Button btnInicio, btnDetalle, btnUsuario;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refDetalle = database.getReference("detalles");

    // Ordenamiento
    Query consultaOrdenada = refDetalle.orderByChild("nombre");

    List<Detalle> detalles;
    ListView listaDestinos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_detalle);

        inicializar();
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

    private void inicializar() {
        listaDestinos = findViewById(R.id.ListaPersonas);

        // Cuando el usuario haga clic en la lista (para editar registro)
        listaDestinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), AddDetalleActivity.class);

                intent.putExtra("accion","e"); // Editar
                intent.putExtra("key", detalles.get(i).getKey());
                intent.putExtra("nombre", detalles.get(i).getNombre());
                intent.putExtra("precio", detalles.get(i).getPrecio());
                intent.putExtra("fecha", detalles.get(i).getFecha());
                intent.putExtra("hora", detalles.get(i).getHora());
                startActivity(intent);
            }
        });

        // Cuando el usuario hace un LongClic (clic sin soltar elemento por mas de 2 segundos)
        // Es por que el usuario quiere eliminar el registro
        listaDestinos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                // Preparando cuadro de dialogo para preguntar al usuario
                // Si esta seguro de eliminar o no el registro
                AlertDialog.Builder ad = new AlertDialog.Builder(DetalleActivity.this);
                ad.setMessage("Está seguro de eliminar registro?")
                        .setTitle("Confirmación");

                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DetalleActivity.refDetalle.child(detalles.get(position).getKey()).removeValue();

                        Toast.makeText(DetalleActivity.this,
                                "Registro borrado!",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(DetalleActivity.this,
                                "Operación de borrado cancelada!",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.show();
                return true;
            }
        });

        detalles = new ArrayList<>();

        // Cambiarlo refProductos a consultaOrdenada para ordenar lista
        consultaOrdenada.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Procedimiento que se ejecuta cuando hubo algun cambio
                // en la base de datos
                // Se actualiza la coleccion de personas
                detalles.removeAll(detalles);
                for (DataSnapshot dato : dataSnapshot.getChildren()) {
                    Detalle detalle = dato.getValue(Detalle.class);
                    detalle.setKey(dato.getKey());
                    detalles.add(detalle);
                }

                AdaptadorDetalle adapter = new AdaptadorDetalle(DetalleActivity.this,
                        detalles);
                listaDestinos.setAdapter(adapter);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void initializeUI() {
        btnInicio = findViewById(R.id.btninicio);
        btnDetalle = findViewById(R.id.btndetalle);
        btnUsuario = findViewById(R.id.btnusuario);
    }
}

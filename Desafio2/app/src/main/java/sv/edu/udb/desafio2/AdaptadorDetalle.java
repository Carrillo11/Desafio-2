package sv.edu.udb.desafio2;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sv.edu.udb.desafio2.Detalle;
import java.util.List;
public class AdaptadorDetalle extends ArrayAdapter<Detalle>{
    List<Detalle> detalles;
    private Activity context;

    public AdaptadorDetalle(@NonNull Activity context, @NonNull List<Detalle> detalles) {
        super(context, R.layout.activity_detalle, detalles);
        this.context = context;
        this.detalles = detalles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        // Método invocado tantas veces como elementos tenga la coleccion personas
        // para formar a cada item que se visualizara en la lista personalizada
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowview=null;
        // optimizando las diversas llamadas que se realizan a este método
        // pues a partir de la segunda llamada el objeto view ya viene formado
        // y no sera necesario hacer el proceso de "inflado" que conlleva tiempo y
        // desgaste de bateria del dispositivo
        if (view == null)
            rowview = layoutInflater.inflate(R.layout.activity_detalle,null);
        else rowview = view;

        TextView tvNombre = rowview.findViewById(R.id.txtnombre);
        TextView tvPrecio = rowview.findViewById(R.id.txtprecio);
        TextView tvFecha = rowview.findViewById(R.id.txtfecha);
        TextView tvHora = rowview.findViewById(R.id.txthora);

        tvNombre.setText("Nombre : "+ detalles.get(position).getNombre());
        tvPrecio.setText("Precio : " + detalles.get(position).getPrecio());
        tvFecha.setText("Fecha : " + detalles.get(position).getFecha());
        tvHora.setText("Hora : " + detalles.get(position).getHora());

        return rowview;
    }
}

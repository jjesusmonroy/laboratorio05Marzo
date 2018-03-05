package com.ejemplo.mydb03.utilidades;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ejemplo.mydb03.R;

/**
 * Created by jjesusmonroy on 5/03/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder>{
    private String [][] datos;

    public Adapter(String[][] datos) {
        this.datos = datos;
    }

    @Override
    public Adapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.RecyclerViewHolder holder, int position) {
        holder.clave.setText("clave : "+ datos[position][1]);
        holder.nombre.setText("nombre : "+datos[position][2]);
        holder.salario.setText("salario : "+datos[position][3]);
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clave,nombre,salario;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            clave=itemView.findViewById(R.id.clave);
            nombre=itemView.findViewById(R.id.nombre);
            salario=itemView.findViewById(R.id.salario);

        }
    }
}

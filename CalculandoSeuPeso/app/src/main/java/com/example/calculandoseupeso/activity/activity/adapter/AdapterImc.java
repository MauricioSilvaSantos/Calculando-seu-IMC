package com.example.calculandoseupeso.activity.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculandoseupeso.R;
import com.example.calculandoseupeso.activity.activity.model.TabelaImc;

import java.util.List;

public class AdapterImc extends RecyclerView.Adapter<AdapterImc.MyViewHolder > {

    private  List<TabelaImc> listaImc;

    public AdapterImc(List<TabelaImc> lista) {

        this.listaImc = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista= LayoutInflater.from( parent.getContext()).inflate( R.layout.adapter_lista, parent, false );

        return new MyViewHolder(itemLista);
    }
    @Override
    public void onBindViewHolder( @NonNull MyViewHolder holder, int position ){
        TabelaImc tabelaImc = listaImc.get( position );
        holder.titulo.setText( tabelaImc.getTitulo() );
        holder.resultado.setText( tabelaImc.getResultado() );
    }
    @Override
    public int getItemCount() {

        return listaImc.size();
    }
    //Configurar ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView resultado;

        //Constructor
        public MyViewHolder( @NonNull View itemView ) {
            super( itemView );

            titulo = itemView.findViewById( R.id.txtImc );
            resultado = itemView.findViewById( R.id.txtResultadoLista );

        }
    }


}

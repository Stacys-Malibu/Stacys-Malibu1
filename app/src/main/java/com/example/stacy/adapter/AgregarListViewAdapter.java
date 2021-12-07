package com.example.stacy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.stacy.R;
import com.example.stacy.model.Usuario;

import java.util.List;

public class AgregarListViewAdapter extends BaseAdapter {

        private Context context;
        private List<Usuario> usuariosList;

        public AgregarListViewAdapter(Context context, List<Usuario> usuariosList) {
            this.context = context;
            this.usuariosList = usuariosList;
        }


        @Override
        public int getCount() {
            return this.usuariosList.size();
        }

        @Override
        public Usuario getItem(int position) {
            return this.usuariosList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return this.usuariosList.get(position).getId();
        }

        @Override
        public View getView(int position, View vista, ViewGroup parent) {
            ViewHolder viewHolder;
            if (vista == null) { //No se puede reciclar
                viewHolder = new ViewHolder();

                //Inflater nos permite usar un layout dentro de un componente
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vista = inflater.inflate(R.layout.agregar, null);

                viewHolder.textViewName = vista.findViewById(R.id.nombre);
                viewHolder.textViewApellido = vista.findViewById(R.id.apellido);
                viewHolder.textViewTipoE = vista.findViewById(R.id.tipoE);
                vista.setTag(viewHolder); //Guardar para reciclar
            } else {
                viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
            }

            Usuario usuario = this.usuariosList.get(position);
            viewHolder.textViewName.setText(usuario.getNombre());
            viewHolder.textViewApellido.setText(usuario.getApellido());
            viewHolder.textViewTipoE.setText(usuario.getTipoE());
            return vista;
        }

        static class ViewHolder {
            TextView textViewName;
            TextView textViewApellido;
            TextView textViewTipoE;
        }
}

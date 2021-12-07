package com.example.stacy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stacy.R;
import com.example.stacy.model.Examen;

import java.util.List;

public class AgregarListViewAdapter3 extends BaseAdapter {

        private Context context;
        private List<Examen> examenesList;

        public AgregarListViewAdapter3(Context context, List<Examen> examenesList) {
            this.context = context;
            this.examenesList = examenesList;
        }


        @Override
        public int getCount() {
            return this.examenesList.size();
        }

        @Override
        public Examen getItem(int position) {
            return this.examenesList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return this.examenesList.get(position).getId();
        }

        @Override
        public View getView(int position, View vista, ViewGroup parent) {
            ViewHolder viewHolder;
            if (vista == null) { //No se puede reciclar
                viewHolder = new ViewHolder();

                //Inflater nos permite usar un layout dentro de un componente
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vista = inflater.inflate(R.layout.agregar3, null);

                viewHolder.textViewName = vista.findViewById(R.id.categoria);
                viewHolder.textViewApellido = vista.findViewById(R.id.cantidad);
                vista.setTag(viewHolder); //Guardar para reciclar
            } else {
                viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
            }

            Examen examen = this.examenesList.get(position);
            viewHolder.textViewName.setText(examen.getCategoria());
            viewHolder.textViewApellido.setText(examen.getCantidad());
            return vista;
        }

        static class ViewHolder {
            TextView textViewName;
            TextView textViewApellido;
        }
}

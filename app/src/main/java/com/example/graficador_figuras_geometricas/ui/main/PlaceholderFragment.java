package com.example.graficador_figuras_geometricas.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.graficador_figuras_geometricas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private String numeroPaginaAux;//Variable que nos indica el numero de pagina de la pantalla
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        /**
         * Obtenemos el numero de las paginas
         */
        numeroPaginaAux = pageViewModel.getNumeroPagina();
    }

    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        View root;
        TextView textView;
        System.out.println("numero de pagina: "+numeroPaginaAux);
        /*
         * Si es la pagina 1, entonces se retorna el layout/activity de entrada.xml
         */
        if (numeroPaginaAux.equals("1")){
            root = inflater.inflate(R.layout.entrada, container, false);
            textView = root.findViewById(R.id.section_label);
        }
        /*
         * Si es la pagina 2, entonces se retorna el layout/activity de visualizador.xml
         */
        else {
            root = inflater.inflate(R.layout.visualizador, container, false);
            textView = root.findViewById(R.id.txtResultado);
        }

        return root;
    }
}
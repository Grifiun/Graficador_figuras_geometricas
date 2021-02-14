package com.example.graficador_figuras_geometricas.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private String numeroPagina;
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return ""+input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
        //Obtenemos el numero de pagina
        numeroPagina = ""+index;
    }

    public LiveData<String> getText() {
        return mText;
    }

    /**
     * Se retorna el String contenedor del numero de pagina
     * @return
     */
    public String getNumeroPagina(){
        return numeroPagina;
    }
}
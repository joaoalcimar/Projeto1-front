package ufcg.p1_project.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import ufcg.p1_project.R;

public class PlacesListActivity extends AppCompatActivity{

    private PlacesListActivity.ViewHolder mViewHolder = new PlacesListActivity.ViewHolder();
    public static ArrayList<String> meusImoveis = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        mViewHolder.listaImoveis = findViewById(R.id.lv_places);

        preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, meusImoveis);

        mViewHolder.listaImoveis.setAdapter(arrayAdapter);

    }


    private void preencherDados(){

        mViewHolder.dados.add("Imóvel 1: Rua João Pessoa n131");
        mViewHolder.dados.add("Imóvel 2: Rua Santa Fé n1023");
        mViewHolder.dados.add("Imóvel 3: Rua João Pessoa n95 apt 303");
        mViewHolder.dados.add("Imóvel 4: Rua Estácio de Sá n786");

    }


    public void adicionarNovoItem(String pseudoEndereco){
        meusImoveis.add(pseudoEndereco);
    }


    private static class ViewHolder{
        ListView listaImoveis;
        ArrayList<String> dados = new ArrayList<String>();


    }



}

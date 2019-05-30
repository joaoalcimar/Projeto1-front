package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.Place;

public class PlacesListActivity extends AppCompatActivity{

    private PlacesListActivity.ViewHolder mViewHolder = new PlacesListActivity.ViewHolder();
    public static ArrayList<Place> meusImoveis = new ArrayList<Place>();

    //limpar essa seboseira dps
    public RegisterUserActivity reg = new RegisterUserActivity();
    public UserPlaceActivity upl = new UserPlaceActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        reg.loadMap();
        meusImoveis = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis();

        mViewHolder.listaImoveis = findViewById(R.id.lv_places);

        ArrayList<String> imoveisListView = preencherListView();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, imoveisListView);



        mViewHolder.listaImoveis.setAdapter(arrayAdapter);
        mViewHolder.listaImoveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), ZonesListActivity.class);
                startActivity(intent);
            }
        });

    }


    private ArrayList<String> preencherListView(){
        ArrayList<String> temporaryList = new ArrayList<>();
        for(int i = 0; i < meusImoveis.size();i++){
            temporaryList.add(meusImoveis.get(i).getNome());
        }
        return temporaryList;

    }

    private static class ViewHolder{
        ListView listaImoveis;
        ArrayList<String> dados = new ArrayList<String>();


    }



}

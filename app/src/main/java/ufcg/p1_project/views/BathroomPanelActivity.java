package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.FlowPoint;
import ufcg.p1_project.classes.Place;

public class BathroomPanelActivity extends AppCompatActivity {


    private ViewHolder mViewHolder = new ViewHolder();
    public static ArrayList<FlowPoint> pontosVazaoBanheiro = new ArrayList();
    public static int indice;

    //limpar essa seboseira dps
    public ZonesMenuActivity zome = new ZonesMenuActivity();
    public RegisterUserActivity reg = new RegisterUserActivity();
    public UserPlaceActivity upl = new UserPlaceActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_panel);
        reg.loadMap();
        ArrayList<Place> listaTemp = new ArrayList<>();
        System.out.println(reg.getUsersData() == null);
        System.out.println(reg.getUsersData().get(upl.getLoggedUser()) == null);
        System.out.println(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis() == null);
        System.out.println("acaba aqui");
        listaTemp = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis();
        for(int i = 0; i < listaTemp.size(); i++){
            if(listaTemp.get(i).getNome().equals(zome.getImovelAtual())){
               indice = i;
                pontosVazaoBanheiro = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(0).getPontosDeVazao();
            }

        }

        mViewHolder.pontosVazaoBanheiroLv = findViewById(R.id.lv_flow_points_bathroom);

        ArrayList<String> flowPointsListView = preencherListView();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowPointsListView);


        mViewHolder.pontosVazaoBanheiroLv.setAdapter(arrayAdapter);
        mViewHolder.pontosVazaoBanheiroLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                zome.setImovelAtual(arrayAdapter.getItem(position).toString());

                Intent intent = new Intent(parent.getContext(), ZonesMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    public void alert(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


    private ArrayList<String> preencherListView(){
        ArrayList<String> temporaryList = new ArrayList<>();
        for(int i = 0; i < pontosVazaoBanheiro.size(); i++){
            temporaryList.add(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(0).getPontosDeVazao().get(i).getNome());
        }
        return temporaryList;

    }

    private static class ViewHolder{
        ListView pontosVazaoBanheiroLv;
        ArrayList<String> dados = new ArrayList<String>();


    }
















}

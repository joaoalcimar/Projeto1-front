package ufcg.p1_project.views;

import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.FlowPoint;
import ufcg.p1_project.classes.Place;

public class GardenPanelActivity extends AppCompatActivity {


    private ViewHolder mViewHolder = new ViewHolder();
    Random gerador = new Random();
    public int indice;
    Timer timer = new Timer();
    DecimalFormat df = new DecimalFormat("######.###");

    private ArrayList<FlowPoint> pontosVazaoJardim = new ArrayList();
    private ArrayList<Double> litrosPontosVazaoJardim = new ArrayList();
    private ArrayList<Double> gastosPontosVazaoJardim = new ArrayList();

    private ArrayList<String> flowPointsListView = new ArrayList<>();
    private ArrayList<String> flowPointsLitterListView = new ArrayList<>();
    private ArrayList<String> flowPointsMoneyListView = new ArrayList<>();

    private ArrayAdapter<String> arrayAdapterPoints;
    private ArrayAdapter<String> arrayAdapterLitters;
    private ArrayAdapter<String> arrayAdapterMoney;


    //limpar essa seboseira dps
    public ZonesMenuActivity zome = new ZonesMenuActivity();
    public RegisterUserActivity reg = new RegisterUserActivity();
    public UserPlaceActivity upl = new UserPlaceActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_panel);
        reg.loadMap();
        ArrayList<Place> listaTemp = new ArrayList<>();
        listaTemp = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis();


        //lista de litros
        for (int i = 0; i < listaTemp.size(); i++) {
            if (listaTemp.get(i).getNome().equals(zome.getImovelAtual())) {
                if (reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Sem pontos de vazão", Toast.LENGTH_SHORT).show();
                } else {
                    indice = i;
                    pontosVazaoJardim = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(1).getPontosDeVazao();
                    litrosPontosVazaoJardim = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(1).getLitrosPontosDeVazao();
                    gastosPontosVazaoJardim = reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(1).getPrecosPontosDeVazao();


                }
            }
        }

        mViewHolder.pontosVazaoJardimLv = findViewById(R.id.lv_flow_points_garden);
        mViewHolder.litrosGastosLv = findViewById(R.id.lv_flow_points_spent_litters_garden);
        mViewHolder.precoPontosDeVazaoLv = findViewById(R.id.lv_flow_points_spent_money_garden);


        flowPointsListView = preencherListViewPontosVazao();
        flowPointsLitterListView = preencherListViewLitrosPontosVazao();
        flowPointsMoneyListView = preencherListViewGastoPontosVazao();


        arrayAdapterPoints = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowPointsListView);
        arrayAdapterLitters = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowPointsLitterListView);
        arrayAdapterMoney = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flowPointsMoneyListView);

        mViewHolder.pontosVazaoJardimLv.setAdapter(arrayAdapterPoints);
        mViewHolder.litrosGastosLv.setAdapter(arrayAdapterLitters);
        mViewHolder.precoPontosDeVazaoLv.setAdapter(arrayAdapterMoney);

        incrementaTempo();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        flowPointsListView.clear();
        flowPointsMoneyListView.clear();
        flowPointsLitterListView.clear();

        arrayAdapterLitters.notifyDataSetChanged();
        arrayAdapterMoney.notifyDataSetChanged();
        arrayAdapterPoints.notifyDataSetChanged();

    }

    public void alert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private ArrayList<String> preencherListViewPontosVazao() {
        ArrayList<String> temporaryList = new ArrayList<>();
        for (int i = 0; i < pontosVazaoJardim.size(); i++) {
            temporaryList.add(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getPontosDeVazao().get(i).getNome());
        }
        return temporaryList;

    }

    private ArrayList<String> preencherListViewLitrosPontosVazao() {
        ArrayList<String> temporaryList = new ArrayList<>();
        for (int i = 0; i < litrosPontosVazaoJardim.size(); i++) {
            temporaryList.add(df.format((reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getLitrosPontosDeVazao().get(i))) + "Litros" );
        }
        return temporaryList;

    }

    private ArrayList<String> preencherListViewGastoPontosVazao() {
        ArrayList<String> temporaryList = new ArrayList<>();
        for (int i = 0; i < gastosPontosVazaoJardim.size(); i++) {
            temporaryList.add(df.format((reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getPrecosPontosDeVazao().get(i))) + "R$");

        }
        return temporaryList;

    }


    public void incrementaTempo() {
        new Thread() {

            @Override
            public void run() {

                if (gerador.nextInt(100) <= 30) {
                    Double randomval = (gerador.nextInt(30) + 20.0) / 100;
                    for (int j = 0; j < reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getLitrosPontosDeVazao().size(); j++) {
                        reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getLitrosPontosDeVazao().set(j,
                                reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getLitrosPontosDeVazao().get(j) + randomval);
                        reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(1).getPrecosPontosDeVazao().set(j,
                                (Double.parseDouble(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getCustoLitro()) * reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(indice).getZonesList().get(0).getLitrosPontosDeVazao().get(j)));

                        arrayAdapterLitters.notifyDataSetChanged();
                        arrayAdapterMoney.notifyDataSetChanged();
                        arrayAdapterPoints.notifyDataSetChanged();

                        mViewHolder.pontosVazaoJardimLv.setAdapter(arrayAdapterPoints);
                        mViewHolder.litrosGastosLv.setAdapter(arrayAdapterLitters);
                        mViewHolder.precoPontosDeVazaoLv.setAdapter(arrayAdapterMoney);
                    }
                }


            }
        }.start();

    }


    private static class ViewHolder {
        ListView pontosVazaoJardimLv;
        ListView litrosGastosLv;
        ListView precoPontosDeVazaoLv;


    }

}

package ufcg.p1_project.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.FlowPoint;
import ufcg.p1_project.classes.Place;
import ufcg.p1_project.classes.Zone;

public class KitchenEditActivity extends AppCompatActivity implements View.OnClickListener{


    private Random gerador = new Random();
    private ViewHolder mViewHolder = new ViewHolder();

    //limpar essa seboseira dps
    public ZonesMenuActivity zome = new ZonesMenuActivity();
    public RegisterUserActivity reg = new RegisterUserActivity();
    public UserPlaceActivity upl = new UserPlaceActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_edit);

        this.mViewHolder.nome = findViewById(R.id.ponto_vazao_kitchen_et);

        this.mViewHolder.botaoRegistrar = findViewById(R.id.register_new_flow_kitchen_button);
        this.mViewHolder.botaoRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.register_new_flow_kitchen_button) {
            if(mViewHolder.nome.getText().toString().equals("")){
                alert("Preencha todos os campos!");

            }else {
                FlowPoint newFlow = new FlowPoint();
                assemblyFlowPoint(newFlow);

                reg.loadMap();

                ArrayList<Place> listaTemp= reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis();


                // AJEITAR PELO AMOR DE DEUS, considerando 0 cozinha
                for(int i = 0; i < listaTemp.size(); i++){
                    if(listaTemp.get(i).getNome().equals(zome.getImovelAtual())){
                        Double randomval = (gerador.nextInt(2) + 2.0)/10;
                        if (reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().isEmpty()){
                            Zone z = new Zone();
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().add(z);
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getPontosDeVazao().add(newFlow);

                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getLitrosPontosDeVazao().add(randomval);
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getPrecosPontosDeVazao().add((Double.parseDouble(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getCustoLitro()) * randomval));
                        }else{
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getPontosDeVazao().add(newFlow);
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getLitrosPontosDeVazao().add(randomval);
                            reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getZonesList().get(2).getPrecosPontosDeVazao().add((Double.parseDouble(reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().get(i).getCustoLitro()) * randomval));
                        }

                    }
                }


                reg.saveMap();
                alert(newFlow.getNome() + " cadastrado com sucesso!");

                resetTextFields();
            }
        }
    }



    public void alert(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    public void assemblyFlowPoint(FlowPoint newFlow){
        newFlow.setNome(mViewHolder.nome.getText().toString());

    }

    private void resetTextFields(){

        this.mViewHolder.nome.setText("");

    }

    private static class ViewHolder {
        Button botaoRegistrar;
        EditText nome;
    }

}
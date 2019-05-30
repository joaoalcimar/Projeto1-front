package ufcg.p1_project.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.Place;


public class RegisterPlaceActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    //limpar essa seboseira dps
    public RegisterUserActivity reg = new RegisterUserActivity();
    public UserPlaceActivity upl = new UserPlaceActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_place);

        this.mViewHolder.nome = findViewById(R.id.nome_imovel_et);
        this.mViewHolder.rua = findViewById(R.id.rua_imovel_et);
        this.mViewHolder.numero = findViewById(R.id.numero_imovel_et);
        this.mViewHolder.bairro = findViewById(R.id.bairro_imovel_et);
        this.mViewHolder.custoLitro = findViewById(R.id.custo_litro_imovel_et);

        this.mViewHolder.botaoRegistrar = findViewById(R.id.register_new_place_button);
        this.mViewHolder.botaoRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.register_new_place_button) {
            if(mViewHolder.nome.getText().equals("") || mViewHolder.rua.getText().equals("") || mViewHolder.numero.getText().equals("")
                    || mViewHolder.bairro.getText().equals("") || mViewHolder.custoLitro.getText().equals("")){
                alert("Preencha todos os campos!");

            }else {
                Place newPlace = new Place();
                assemblyPlace(newPlace);

                reg.loadMap();
                reg.getUsersData().get(upl.getLoggedUser()).getListaImoveis().add(newPlace);
                reg.saveMap();
                alert(newPlace.getNome() + " cadastrado com sucesso!");

                resetTextFields();
            }
        }
    }

    public void alert(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    public void assemblyPlace(Place newPlace){
        newPlace.setNome(mViewHolder.nome.getText().toString());
        newPlace.setRua(mViewHolder.rua.getText().toString());
        newPlace.setBairro(mViewHolder.bairro.getText().toString());
        newPlace.setNumero(mViewHolder.numero.getText().toString());
        newPlace.setCustoLitro((mViewHolder.custoLitro.getText().toString()));
    }

    private void resetTextFields(){

        this.mViewHolder.nome.setText("");
        this.mViewHolder.rua.setText("");
        this.mViewHolder.numero.setText("");
        this.mViewHolder.bairro.setText("");
        this.mViewHolder.custoLitro.setText("");

    }

    private static class ViewHolder{
        Button botaoRegistrar;
        EditText nome;
        EditText rua;
        EditText numero;
        EditText bairro;
        EditText custoLitro;

    }
}

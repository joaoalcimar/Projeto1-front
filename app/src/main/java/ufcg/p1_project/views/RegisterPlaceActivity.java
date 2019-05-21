package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ufcg.p1_project.views.PlacesListActivity;

import ufcg.p1_project.R;

public class RegisterPlaceActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    // implementação temporaria

    private PlacesListActivity temporario = new PlacesListActivity();

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
            //implementacao temporaria
            String value = this.mViewHolder.nome.getText().toString() + ": ";
            value += this.mViewHolder.rua.getText().toString() + " n";
            value += this.mViewHolder.numero.getText().toString();

            temporario.adicionarNovoItem(value);

        }
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

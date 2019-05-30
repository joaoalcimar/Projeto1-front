package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ufcg.p1_project.R;

public class ZonesMenuActivity extends AppCompatActivity implements View. OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();

    //limpar essa seboseira dps
    public static String imovelAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones_menu);

        this.mViewHolder.goToZonesListButton = findViewById(R.id.zones_list_button);
        this.mViewHolder.goToZonesListButton.setOnClickListener(this);

        this.mViewHolder.goToEditZonesButton = findViewById(R.id.zones_edit_button);
        this.mViewHolder.goToEditZonesButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.zones_list_button) {

            Intent intent = new Intent(this, ZonesListActivity.class);
            startActivity(intent);

        }else if(id == R.id.zones_edit_button){

            Intent intent = new Intent(this, EditZoneActivity.class);
            startActivity(intent);

        }


    }

    public static String getImovelAtual() {
        return imovelAtual;
    }

    public static void setImovelAtual(String imovelAtual) {
        ZonesMenuActivity.imovelAtual = imovelAtual;
    }


    private static class ViewHolder{
        Button goToZonesListButton;
        Button goToEditZonesButton;

    }
}

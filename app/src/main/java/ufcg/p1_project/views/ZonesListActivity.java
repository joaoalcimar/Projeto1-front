package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufcg.p1_project.R;

public class ZonesListActivity extends AppCompatActivity implements View.OnClickListener{


    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones_list);

        this.mViewHolder.goToBathroomPanelButton = findViewById(R.id.bathroom_button);
        this.mViewHolder.goToBathroomPanelButton.setOnClickListener(this);

        this.mViewHolder.goToGardenPanelButton = findViewById(R.id.bathroom_button);
        this.mViewHolder.goToGardenPanelButton.setOnClickListener(this);

        this.mViewHolder.goToKitchenPanelButton = findViewById(R.id.bathroom_button);
        this.mViewHolder.goToKitchenPanelButton.setOnClickListener(this);

        this.mViewHolder.goToLaundryPanelButton = findViewById(R.id.bathroom_button);
        this.mViewHolder.goToLaundryPanelButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bathroom_button) {

            Intent intent = new Intent(this, BathroomPanelActivity.class);
            startActivity(intent);

        }else if(id == R.id.garden_button){

            Intent intent = new Intent(this, GardenPanelActivity.class);
            startActivity(intent);

        }else if(id == R.id.kitchen_button){

            Intent intent = new Intent(this, KitchenPanelActivity.class);
            startActivity(intent);

        }else if(id == R.id.laundry_button){

            Intent intent = new Intent(this, LaundryPanelActivity.class);
            startActivity(intent);

        }
    }

    private static class ViewHolder{
        Button goToBathroomPanelButton;
        Button goToKitchenPanelButton;
        Button goToLaundryPanelButton;
        Button goToGardenPanelButton;
    }


}

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


        this.mViewHolder.goToBathroomMenuButton = findViewById(R.id.bathroom_button);
        this.mViewHolder.goToKitchenMenuButton = findViewById(R.id.kitchen_button);
        this.mViewHolder.goToGardenMenuButton = findViewById(R.id.garden_button);
        this.mViewHolder.goToLaundryMenuButton = findViewById(R.id.laundry_button);


        this.mViewHolder.goToBathroomMenuButton.setOnClickListener(this);
        this.mViewHolder.goToKitchenMenuButton.setOnClickListener(this);
        this.mViewHolder.goToGardenMenuButton.setOnClickListener(this);
        this.mViewHolder.goToLaundryMenuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.bathroom_button) {

            Intent intent = new Intent(this, BathroomPanelActivity.class);
            startActivity(intent);

        }else if (id == R.id.kitchen_button){

            Intent intent = new Intent(this, KitchenPanelActivity.class);
            startActivity(intent);

        }else if (id == R.id.laundry_button){

            Intent intent = new Intent(this, LaundryPanelActivity.class);
            startActivity(intent);

        }else if (id == R.id.garden_button){

            Intent intent = new Intent(this, GardenPanelActivity.class);
            startActivity(intent);

        }


    }

    private static class ViewHolder{

        Button goToBathroomMenuButton;
        Button goToKitchenMenuButton;
        Button goToGardenMenuButton;
        Button goToLaundryMenuButton;

    }

}
package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufcg.p1_project.R;

public class EditZoneActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_zone);

        this.mViewHolder.goToEditBathroomButton = findViewById(R.id.edit_bathroom_button);
        this.mViewHolder.goToEditBathroomButton.setOnClickListener(this);

        this.mViewHolder.goToEditGardenButton = findViewById(R.id.edit_garden_button);
        this.mViewHolder.goToEditGardenButton.setOnClickListener(this);

        this.mViewHolder.goToEditKitchenButton = findViewById(R.id.edit_kitchen_button);
        this.mViewHolder.goToEditKitchenButton.setOnClickListener(this);

        this.mViewHolder.goToEditLaundryButton = findViewById(R.id.edit_laundry_button);
        this.mViewHolder.goToEditLaundryButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        int id = v.getId();
        if (id == R.id.edit_bathroom_button) {

            Intent intent = new Intent(this, BathroomEditActivity.class);
            startActivity(intent);

        }else if(id == R.id.edit_garden_button){

            Intent intent = new Intent(this, BathroomEditActivity.class);
            startActivity(intent);

        }else if(id == R.id.edit_kitchen_button){

            Intent intent = new Intent(this, BathroomEditActivity.class);
            startActivity(intent);

        }else if(id == R.id.edit_laundry_button){

            Intent intent = new Intent(this, BathroomEditActivity.class);
            startActivity(intent);

        }

    }

    private static class ViewHolder{
        Button goToEditBathroomButton;
        Button goToEditKitchenButton;
        Button goToEditGardenButton;
        Button goToEditLaundryButton;

    }
}

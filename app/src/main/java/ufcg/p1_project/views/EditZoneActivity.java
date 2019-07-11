package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import ufcg.p1_project.R;

public class EditZoneActivity extends AppCompatActivity {

    @BindView(R.id.edit_bathroom_button)
    /*default*/ Button mBathroomButton;
    @BindView(R.id.edit_kitchen_button)
    /*default*/ Button mKitchenButton;
    @BindView(R.id.edit_garden_button)
    /*default*/ Button mGardenButton;
    @BindView(R.id.edit_laundry_button)
    /*default*/ Button mLaundryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_zone);
        ButterKnife.bind(this);
        setOnClick();
    }


    private void setOnClick() {

        mBathroomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditZoneActivity.this, BathroomEditActivity.class);
                startActivity(intent);
            }
        });

        mKitchenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditZoneActivity.this, KitchenEditActivity.class);
                startActivity(intent);
            }
        });

        mGardenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditZoneActivity.this, GardenEditActivity.class);
                startActivity(intent);
            }
        });

        mLaundryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditZoneActivity.this, LaundryEditActivity.class);
                startActivity(intent);
            }
        });
    }
}
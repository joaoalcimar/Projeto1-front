package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import ufcg.p1_project.R;

public class ZonesListActivity extends AppCompatActivity{
    @BindView(R.id.bathroom_button)
    /*default*/ Button mBathroomButton;
    @BindView(R.id.kitchen_button)
    /*default*/ Button mKitchenButton;
    @BindView(R.id.garden_button)
    /*default*/ Button mGardenButton;
    @BindView(R.id.laundry_button)
    /*default*/ Button mLaundryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zones_list);
        ButterKnife.bind(this);

        setOnClick();
    }

    private void setOnClick(){

        mBathroomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ZonesListActivity.this, BathroomPanelActivity.class);
                startActivity(intent);
            }
        });

        mKitchenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ZonesListActivity.this, KitchenPanelActivity.class);
                startActivity(intent);
            }
        });

        mGardenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ZonesListActivity.this, GardenPanelActivity.class);
                startActivity(intent);
            }
        });

        mLaundryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ZonesListActivity.this, LaundryPanelActivity.class);
                startActivity(intent);
            }
        });
    }

}

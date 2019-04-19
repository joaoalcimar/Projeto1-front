package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ufcg.p1_project.R;

public class UserPanelActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        this.mViewHolder.goToUserButton = findViewById(R.id.user_button);
        this.mViewHolder.goToStatisticsButton = findViewById(R.id.statistics_button);
        this.mViewHolder.goToSavingButton = findViewById(R.id.saving_button);
        this.mViewHolder.goToSpendingButton = findViewById(R.id.spending_button);

        this.mViewHolder.goToUserButton.setOnClickListener(this);
        this.mViewHolder.goToStatisticsButton.setOnClickListener(this);
        this.mViewHolder.goToSavingButton.setOnClickListener(this);
        this.mViewHolder.goToSpendingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.user_button){

            Intent intent = new Intent(this, UserDataActivity.class);
            startActivity(intent);

        }else if(id == R.id.statistics_button){

            Intent intent = new Intent(this, StatisticsActivity.class);
            startActivity(intent);

        }else if(id == R.id.saving_button){

            Intent intent = new Intent(this, SavingActivity.class);
            startActivity(intent);

        }else if(id == R.id.spending_button){

            Intent intent = new Intent(this, SpendingActivity.class);
            startActivity(intent);

        }
    }


    private static class ViewHolder{
        Button goToUserButton;
        Button goToStatisticsButton;
        Button goToSavingButton;
        Button goToSpendingButton;

    }




}

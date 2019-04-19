package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufcg.p1_project.R;

public class UserDataActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        this.mViewHolder.goToResidentsListButton = findViewById(R.id.residents_list_button);
        this.mViewHolder.goToUserPlaceButton = findViewById(R.id.user_place_button);

        this.mViewHolder.goToResidentsListButton.setOnClickListener(this);
        this.mViewHolder.goToUserPlaceButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.residents_list_button){

            Intent intent = new Intent(this, ResidentsListActivity.class);
            startActivity(intent);

        }else if(id == R.id.user_place_button) {

            Intent intent = new Intent(this, UserPlaceActivity.class);
            startActivity(intent);

        }
    }


    private static class ViewHolder{
        Button goToResidentsListButton;
        Button goToUserPlaceButton;
    }
}

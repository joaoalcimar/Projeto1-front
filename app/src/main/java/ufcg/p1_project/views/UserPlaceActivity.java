package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufcg.p1_project.R;

public class UserPlaceActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_place);

        this.mViewHolder.goToRegisterButton = findViewById(R.id.register_button);

        this.mViewHolder.goToRegisterButton.setOnClickListener(this);

        this.mViewHolder.goToEditPlacesButton = findViewById(R.id.edit_places_button);

        this.mViewHolder.goToEditPlacesButton.setOnClickListener(this);

        this.mViewHolder.goToPlacesListButton = findViewById(R.id.places_list_button);

        this.mViewHolder.goToPlacesListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.register_button) {

            Intent intent = new Intent(this, RegisterPlaceActivity.class);
            startActivity(intent);


        }else if( id == R.id.places_list_button){

            Intent intent = new Intent(this, PlacesListActivity.class);
            startActivity(intent);


        }else if (id == R.id.edit_places_button) {

            Intent intent = new Intent(this, EditPlaceActivity.class);
            startActivity(intent);

        }
    }


    private static class ViewHolder {
        Button goToRegisterButton;
        Button goToEditPlacesButton;
        Button goToPlacesListButton;

    }

}
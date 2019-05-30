package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ufcg.p1_project.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.goToLoginButton = findViewById(R.id.toLogin_button);
        this.mViewHolder.goToLoginButton.setOnClickListener(this);

        this.mViewHolder.goToRegisterButton = findViewById(R.id.toRegister_button);
        this.mViewHolder.goToRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.toLogin_button) {

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        }else if (id == R.id.toRegister_button){

            Intent intent = new Intent(this, RegisterUserActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder{
        Button goToLoginButton;
        Button goToRegisterButton;

    }

}

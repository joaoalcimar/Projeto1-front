package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ufcg.p1_project.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mViewHolder.goToUserPanelButton = findViewById(R.id.login_button);
        this.mViewHolder.goToAdminPanelButton = findViewById(R.id.adm_view_button);
        this.mViewHolder.user = findViewById(R.id.user_edit_text);
        this.mViewHolder.password = findViewById(R.id.password_edit_text);

        this.mViewHolder.goToUserPanelButton.setOnClickListener(this);
        this.mViewHolder.goToAdminPanelButton.setOnClickListener(this);

    }


    private void resetTextFields(){

        this.mViewHolder.user.setText("");
        this.mViewHolder.password.setText("");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_button) {

            Intent intent = new Intent(this, UserPanelActivity.class);
            startActivity(intent);
            resetTextFields();

        } else if (id == R.id.adm_view_button) {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
            resetTextFields();
        }
    }

    private static class ViewHolder{
        EditText user;
        EditText password;
        Button goToUserPanelButton;
        Button goToAdminPanelButton;

    }
}

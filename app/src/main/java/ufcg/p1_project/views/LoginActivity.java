package ufcg.p1_project.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ufcg.p1_project.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private String user;
    private String password;

    //limpar essa seboseira dps
    public static RegisterUserActivity reg = new RegisterUserActivity();
    public static UserPlaceActivity usplact = new UserPlaceActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mViewHolder.goToUserPlaceButton = findViewById(R.id.login_button);
        this.mViewHolder.userEt = findViewById(R.id.user_edit_text);
        this.mViewHolder.passwordEt = findViewById(R.id.password_edit_text);


        this.mViewHolder.goToUserPlaceButton.setOnClickListener(this);

    }


    private void resetTextFields(){

        this.mViewHolder.userEt.setText("");
        this.mViewHolder.passwordEt.setText("");

    }

    @Override
    public void onClick(View v) {

        user = mViewHolder.userEt.getText().toString();
        password = mViewHolder.passwordEt.getText().toString();
        reg.loadMap();


        int id = v.getId();
        if (id == R.id.login_button) {

            if(reg.getUsersData().containsKey(user)){
               if(reg.getUsersData().get(user).getSenha().equals(password)){

                   Intent intent = new Intent(this, UserPlaceActivity.class);
                   startActivity(intent);
                   alert("Logado com sucesso!");


                   //limpar essa seboseira dps

                   usplact.setLoggedUser(user);


                   resetTextFields();

               }
            }else{
                alert("Usuário ou senha incorreto(s)");
            }

        }


    }

    public void alert(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    private static class ViewHolder{
        EditText userEt;
        EditText passwordEt;
        Button goToUserPlaceButton;

    }
}

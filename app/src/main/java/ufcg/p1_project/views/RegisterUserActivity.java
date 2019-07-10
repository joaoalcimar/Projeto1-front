package ufcg.p1_project.views;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;

import java.io.*;
import java.lang.*;

import ufcg.p1_project.R;
import ufcg.p1_project.classes.User;
import ufcg.p1_project.data.UserDataOpenHelper;
import ufcg.p1_project.dominio.entidades.Login;
import ufcg.p1_project.dominio.repositorio.LoginRepositorio;

public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();
    private String user;
    private String password;
    private String confirmPassword;

    private SQLiteDatabase linker;
    private UserDataOpenHelper userDataOpenHelper;
    private ConstraintLayout layoutRegisterUser;

    private LoginRepositorio loginRep;



    public static Map<String, User> usersData = new HashMap<String, User>();
    public static Properties properties = new Properties();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        this.mViewHolder.registerUserButton = findViewById(R.id.registerUser_button);
        this.mViewHolder.registerUserButton.setOnClickListener(this);
        this.mViewHolder.userEt = findViewById(R.id.registerUser_et);
        this.mViewHolder.passwordEt = findViewById(R.id.password_et);
        this.mViewHolder.confirmPasswordEt = findViewById(R.id.confirmPassword_et);

        layoutRegisterUser = (ConstraintLayout) findViewById(R.id.layoutContextRegisterUser);

        createLink();

    }

    private void createLink(){
        try{

            userDataOpenHelper = new UserDataOpenHelper(this);

            linker = userDataOpenHelper.getWritableDatabase();

            loginRep = new LoginRepositorio(linker);

            Snackbar.make(layoutRegisterUser, "Conexão criada com sucesso", Snackbar.LENGTH_SHORT).setAction("OK", null).show();

        }catch(SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        user = mViewHolder.userEt.getText().toString();
        password = mViewHolder.passwordEt.getText().toString();
        confirmPassword = mViewHolder.confirmPasswordEt.getText().toString();
        loadMap();

        if (id == R.id.registerUser_button) {
            if (usersData.containsKey(user)) {

                alert("Usuário já cadastrado");

            }else if(user.equals("") || password.equals("") || confirmPassword.equals("")) {

                alert("Campo vazio");

            }else if(!password.equals(confirmPassword)){

                alert("Senhas não estão iguais");

            }else{
                User newUser = new User(user,password);
                usersData.put(user,newUser);


                try {
                    Login login = new Login();
                    login.login = user;
                    login.password = password;
                    loginRep.inserir(login);

                }catch (SQLException ex){

                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("Erro");
                    dlg.setMessage(ex.getMessage());
                    dlg.setNeutralButton("OK", null);
                    dlg.show();

                }

                saveMap();
                resetTextFields();
                alert("Cadastrado com sucesso!!");
                finish();

            }

        }
    }

    private void resetTextFields(){

        this.mViewHolder.userEt.setText("");
        this.mViewHolder.passwordEt.setText("");
        this.mViewHolder.confirmPasswordEt.setText("");

    }

    private void alert(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


    public void saveMap(){

        try {
            for (Map.Entry<String, User> entry : usersData.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }

            properties.store(new FileOutputStream("data.properties"), null);
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void loadMap(){
        try {
            properties.load(new FileInputStream("data.properties"));

            for (String key : properties.stringPropertyNames()) {
                usersData.put(key, (User) properties.get(key));
            }
        }catch (IOException i){
            i.printStackTrace();
        }
    }


    public static Map<String, User> getUsersData() {
        return usersData;
    }

    public static void setUsersData(Map<String, User> usersData) {
        RegisterUserActivity.usersData = usersData;
    }


    private static class ViewHolder{
        Button registerUserButton;
        EditText userEt;
        EditText passwordEt;
        EditText confirmPasswordEt;


    }


}

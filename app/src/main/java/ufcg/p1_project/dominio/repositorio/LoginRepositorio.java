package ufcg.p1_project.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ufcg.p1_project.data.UserDataOpenHelper;
import ufcg.p1_project.dominio.entidades.Login;

public class LoginRepositorio {

    private SQLiteDatabase linker;

    public LoginRepositorio(SQLiteDatabase linker){
        this.linker = linker;
    }

    public void inserir(Login login){

        ContentValues contentValues = new ContentValues();
        contentValues.put("LOGIN" , login.login);
        contentValues.put("PASSWORD", login.password);

        linker.insertOrThrow("USERDATA", null, contentValues);

    }

    public void excluir(String login){

        String[] parametros = new String[1];
        parametros[0] = login;

        linker.delete("USERDATA", "LOGIN = ?", parametros);
    }

    public void alterar(Login loginUsuario){

        ContentValues contentValues = new ContentValues();
        contentValues.put("LOGIN" , loginUsuario.login);
        contentValues.put("PASSWORD", loginUsuario.password);

        String[] parametros = new String[1];
        parametros[0] = loginUsuario.login;

        linker.update("USERDATA", contentValues, "LOGIN = ?", parametros);

    }

    public Login buscarLogin(String login){

        Login loginBuscado = new Login();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT LOGIN, PASSWORD ");
        sql.append(" FROM USERDATA ");
        sql.append(" WHERE LOGIN = ? ");

        String[] parametros = new String[1];
        parametros[0] = login;
        Cursor resultado = linker.rawQuery(sql.toString(), parametros);

        if(resultado.getCount() > 0){

            resultado.moveToFirst();

            loginBuscado.login = resultado.getString(resultado.getColumnIndexOrThrow("LOGIN"));
            loginBuscado.password = resultado.getString(resultado.getColumnIndexOrThrow("PASSWORD"));

            return loginBuscado;

        }

        return null;
    }

    public List<Login> buscarTodos(){

        List<Login> logins = new ArrayList<Login>();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT LOGIN, PASSWORD ");
        sql.append(" FROM USERDATA ");

        Cursor resultado = linker.rawQuery(sql.toString(), null);

        if(resultado.getCount() > 0){

            resultado.moveToFirst();

            do{

                Login login = new Login();

                login.login = resultado.getString(resultado.getColumnIndexOrThrow("LOGIN"));
                login.password = resultado.getString(resultado.getColumnIndexOrThrow("PASSWORD"));

                logins.add(login);

            }while(resultado.moveToNext());
        }

        return logins;
    }



}

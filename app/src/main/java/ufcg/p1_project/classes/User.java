package ufcg.p1_project.classes;

import java.sql.ResultSet;
import java.util.ArrayList;

import ufcg.p1_project.data.DBConnector;

public class User {

    private String login;
    private String senha;
    public static ArrayList<Place> listaImoveis = new ArrayList<>();

    public static ArrayList<User> listaUsuarios = new ArrayList<>();

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public ArrayList<User> getLista(){
        DBConnector db = new DBConnector();

        try{
            ResultSet resultSet = db.select("SELECT * FROM public.\"userAccounts\";");
            System.out.println("SELECT * FROM public.\"userAccounts\";");
            System.out.println(resultSet.next());
            if (resultSet != null){
                while(resultSet.next()){
                    System.out.println("cheguei aqui");
                    User obj = new User(null,null);
                    obj.setLogin(resultSet.getString("usuario"));
                    obj.setSenha(resultSet.getString("senha"));
                    listaUsuarios.add(obj);
                    obj = null;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public boolean containItem(String user){
        DBConnector db = new DBConnector();

        try{
            ResultSet resultSet = db.select("SELECT * FROM public.\"userAccounts\" where usuario ="+"'"+user+"'"+";");
            if (resultSet.first()){
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public void salvar(){
        String command = "";
        if(!listaUsuarios.contains(this.getLogin())){
            command = String.format("INSERT INTO public.\"userAccounts\" VALUES('%s', '%s');", this.getLogin(), this.getSenha());

        }

        DBConnector db = new DBConnector();
        db.execute(command);
    }


    public void apagar(){

    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Place> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(ArrayList<Place> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }
}



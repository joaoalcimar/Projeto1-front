package ufcg.p1_project.classes;

import java.util.ArrayList;

public class User {

    private String login;
    private String senha;
    private ArrayList<Place> listaImoveis = new ArrayList<>();

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
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



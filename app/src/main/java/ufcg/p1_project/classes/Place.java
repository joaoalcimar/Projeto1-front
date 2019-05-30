package ufcg.p1_project.classes;

import java.util.ArrayList;

public class Place {

    private String nome;
    private String rua;
    private String numero;
    private String bairro;
    private String custoLitro;
    private ArrayList<Zone> zonesList = new ArrayList();

    public ArrayList<Zone> getZonesList() {
        return zonesList;
    }

    public void setZonesList(ArrayList zonesList) {
        this.zonesList = zonesList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCustoLitro() {
        return custoLitro;
    }

    public void setCustoLitro(String custoLitro) {
        this.custoLitro = custoLitro;
    }
}

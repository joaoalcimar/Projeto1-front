package ufcg.p1_project.classes;

import java.util.ArrayList;

public class Zone {

    public static ArrayList<FlowPoint> pontosDeVazao = new ArrayList();
    public static ArrayList<Double> litrosPontosDeVazao = new ArrayList();
    public static ArrayList<Double> precosPontosDeVazao = new ArrayList();
    private FlowPointTypes tipo;

    public ArrayList <FlowPoint>getPontosDeVazao() {
        return pontosDeVazao;
    }

    public void setPontosDeVazao(ArrayList<FlowPoint> pontosDeVazao) {
        this.pontosDeVazao = pontosDeVazao;
    }

    public FlowPointTypes getTipo() {
        return tipo;
    }

    public void setTipo(FlowPointTypes tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Double> getLitrosPontosDeVazao() {
        return litrosPontosDeVazao;
    }

    public static void setLitrosPontosDeVazao(ArrayList<Double> litrosPontosDeVazao) {
        Zone.litrosPontosDeVazao = litrosPontosDeVazao;
    }

    public ArrayList<Double> getPrecosPontosDeVazao() {
        return precosPontosDeVazao;
    }

    public static void setPrecosPontosDeVazao(ArrayList<Double> precosPontosDeVazao) {
        Zone.precosPontosDeVazao = precosPontosDeVazao;
    }
}

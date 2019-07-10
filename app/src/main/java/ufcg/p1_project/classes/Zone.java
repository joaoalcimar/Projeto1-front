package ufcg.p1_project.classes;

import java.util.ArrayList;

public class Zone {

    public static ArrayList<FlowPoint> pontosDeVazao = new ArrayList();
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmgame;

import static mmgame.Funcoes.pil;



/**
 *
 * @author Gabriel
 */
public class Equipe {
    private int timeId;
    private String nome;
    private float orcam;
    private int carroLvl;
    private int pontos;
    public int p1Id;
    public int p2Id;
    
    public Equipe(int timeId, String nome, float orcam, int carroLvl, int p1Id, int p2Id) {
        this.timeId = timeId;
        this.nome = nome;
        this.orcam = orcam;
        this.carroLvl = carroLvl;
        this.p1Id = p1Id;
        this.p2Id = p2Id;
    }
    
    public void attPontos(int p1, int p2){
        setPontos(p1+p2);
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getOrcam() {
        return orcam;
    }

    public void setOrcam(float orcam) {
        this.orcam = orcam;
    }

    public int getCarroLvl() {
        return carroLvl;
    }

    public void setCarroLvl(int carroLvl) {
        this.carroLvl = carroLvl;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getP1Id() {
        return p1Id;
    }

    public void setP1Id(int p1Id) {
        this.p1Id = p1Id;
    }

    public int getP2Id() {
        return p2Id;
    }

    public void setP2Id(int p2Id) {
        this.p2Id = p2Id;
    }
    
    

    @Override
    public String toString() {
        return nome + ":\n"
                + " orçamento: R$ " + orcam + ", Carro: " + carroLvl;
    }
    
    public String FullInfo() {
        return nome + ":\n"
                + " orçamento: R$ " + orcam + ", Carro: " + carroLvl
                + "\n Piloto 1: " + pil[p1Id].getNome()
                + "\n Piloto 2: " + pil[p2Id].getNome() + "\n";
    }
    
}

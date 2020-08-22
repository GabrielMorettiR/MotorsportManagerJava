/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmgame;



/**
 *
 * @author Gabriel
 */
public class Equipe {
    private int timeId;
    private String nome;
    private float orcam;
    private int carroLvl;

    public Equipe(int timeId, String nome, float orcam, int carroLvl) {
        this.timeId = timeId;
        this.nome = nome;
        this.orcam = orcam;
        this.carroLvl = carroLvl;
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

    @Override
    public String toString() {
        return nome + ":\n"
                + " orçamento= R$ " + orcam + ", Carro= " + carroLvl;
    }
    
    
    
    
    
}

package mmgame;

/**
 *
 * @author Gabriel
 */
public class Piloto {
    private String nome;
    private int lvl;
    private int time_id;
    private double km;
    private boolean batida;
    private int pts;

    public Piloto(String nome, int lvl, int id) {
        this.nome = nome;
        this.lvl = lvl;
        this.time_id = id;
    }

    public void Corre(int carro){
        if(!batida){
            double dist = carro + (carro * (lvl * 0.025)); //400 (Valor + 1/40 do mesmo)
            setKm(dist + getKm()); // 410
        }
    }
    
    public void Desacelera(){
        Corre(-100);
    }
    
    public void Ultrapassa(){
        Corre(150);
    }
    
    public void Bater(){
        setBatida(true);
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public boolean isBatida() {
        return batida;
    }

    public void setBatida(boolean batida) {
        this.batida = batida;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}

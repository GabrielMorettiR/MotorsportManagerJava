package mmgame;

import java.util.Random;
import static mmgame.Funcoes.Delay;
import static mmgame.Funcoes.PedeEnter;
import static mmgame.Funcoes.eqp;
import static mmgame.Funcoes.escolhaTime;
import static mmgame.Funcoes.limparSaida;
import static mmgame.Funcoes.pil;
import static mmgame.Funcoes.valorInt;

/**
 *
 * @author Gabriel
 */
// - \  ||
public class Jogo {

    public static int nTimes = 10;
    public static int nCarros = 20;
    public static int pos[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int pts[] = {25, 22, 18, 15, 12, 10, 8, 4, 2, 1};
    public static int batidas;
    public static int time;

    public static void Corrida(int timeId) {
        if (timeId == -1) {
            time = escolhaTime();
        }
        else{
            time = timeId;
        }
        time+=1;
        int volta = 1;
        int voltas = 4;
        batidas = 0;
        while (volta < voltas) { // Looping das voltas

            CalcPos();
            double prim = pil[pos[0]].getKm();
            if (prim > (3000 * volta)) { // cada volta possui 2000 de "kilometragem"
                volta++;
            }
            Eventos();
            Posicoes(volta, voltas, pos);
            Delay(0.8);
        }
        Posicoes(0, 0, pos);
        PedeEnter();
    }

//    public static int escolhePista(){
//    
//    }
    public static void Posicoes(int volta, int voltas, int[] pos) {
        if (volta > 0) {
            limparSaida();
            System.out.println("Volta " + volta + "/ " + voltas);
        } else {
            limparSaida();
            Delay(0.3);
            System.out.println("== Fim da Corrida ==");
            System.out.println("Vitória de: " + pil[pos[0]].getNome() + "!");
        }
        for (int i = 0; i < nCarros; i++) {
            int aux = nCarros - batidas;
            System.out.print((i + 1) + ". ");
            if (volta == 0) {
                String espaco = "";
                if (i < 10) {
                    if(i >= 6 && i<9){
                        espaco = " ";
                    }
                    System.out.print(" || " + pts[i] + espaco + "pts || ");
                } else if (i >= 10) {
                    System.out.print(" || " + 0 + "pts || ");
                }
                if (i > aux) {
                    System.out.print(" ||  Bateu || ");
                }
            }
            if(time == pil[pos[i]].getTime_id()){
                System.out.print("▸" + pil[pos[i]].getNome());
            }
            else{
                System.out.print(pil[pos[i]].getNome());
            }

                System.out.println("");
        }

    }

    public static void Batida() {
        for (int i = 0; i < nCarros - batidas; i++) {
            double dif = (pil[i].getLvl() - 6) * -10;
            int chance = Random(1000);
            if (chance < dif) {
                pil[i].Bater();
                batidas++;
            }
        }
    }

    public static void Accel() {
        for (int i = 0; i < nCarros - batidas; i++) {
            double dif = pil[i].getLvl() * 2.5;
            int chance = Random(50);
            if (chance < dif) {
                pil[i].Ultrapassa();
            }
        }
    }

    public static void Desaccel() {
        for (int i = 0; i < nCarros - batidas; i++) {
            double dif = pil[i].getLvl() * 2.5;
            int chance = Random(50);
            if (chance < dif) {
                pil[i].Desacelera();
            }
        }
    }

    public static void Eventos() {
        int f = Random(20);
        if (f > 0 && f <= 3) {
            Batida();
        } else if (f > 10 && f <= 15) {
            Accel();
        } else if (f > 15 && f <= 20) {
            Desaccel();
        }
    }

    public static void CalcPos() {
        for (int i = 0; i < nCarros; i++) {
            pil[i].Corre(eqp[pil[i].getTime_id() - 1].getCarroLvl());
        }
        for (int i = 0; i < nCarros; i++) {
            double maior = pil[pos[i]].getKm();

            for (int j = i; j < nCarros; j++) {
                double menor = pil[pos[j]].getKm();
                if (maior < menor) {
                    int aux = pos[j];
                    pos[j] = pos[i];
                    pos[i] = aux;
                }
            }
        }
    }

    public static void Equipes() {
        for (int i = 0; i < nTimes; i++) {
            System.out.println(eqp[i].FullInfo());
        }
    }

    public static int Random(int r) {
        Random gerador = new Random();
        int a = gerador.nextInt(r);
        return a;
    }

}

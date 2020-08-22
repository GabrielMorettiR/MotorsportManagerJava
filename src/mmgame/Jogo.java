package mmgame;

import static mmgame.Funcoes.Delay;
import static mmgame.Funcoes.con;
import static mmgame.Funcoes.insert;
import static mmgame.Funcoes.consulta;
import static mmgame.Funcoes.eqp;
import static mmgame.Funcoes.limparSaida;
import static mmgame.Funcoes.valorInt;

/**
 *
 * @author Gabriel
 */
public class Jogo {

    public static int nTimes = 10;

    public static void Carreira() {
    }

    public static void Corrida(int time) {
        time = escolhaTime();
        //pista = escolhePista();
        int voltas = 5;
        for (int volta = 1; volta <= voltas; volta++) {
            Posicoes(volta, voltas);
            Delay(2);
        }
        System.out.println("== Fim da Corrida ==");
        Posicoes(0,0);
    }

    public static int escolhaTime() {

        String resp = "Escolha um time: ";
        con();

        System.out.println("");
        boolean loop = true;
        int time = 1;
        while (loop) {
            for (int i = 0; i < nTimes; i++) {
                System.out.println(i + 1 + ". " + eqp[i].getNome());
            }
            System.out.println("\n " + resp);
            time = valorInt();
            time -= 1;
            if (time < 0 || time > 9) {
                resp = "Escolha uma opção válida";
            } else {
                System.out.println("Você selecionou: " + eqp[time].getNome());
                loop = Conf();
            }
        }
        return time;
    }

//    public static int escolhePista(){
//    
//    }
    
    public static void Posicoes(int volta, int voltas) {
        if(volta > 0){
            limparSaida();
            System.out.println("Volta " + volta + "/ " + voltas);
        }
        for (int i = 0; i < nTimes; i++) {
            System.out.println(i + 1 + ". " + eqp[i].getNome());
        }
        
    }

    public static boolean Conf() {
        boolean ask = true;
        while (ask) {
            System.out.println("Esta é sua equipe? 1- Sim 2- Não");
            int resp = valorInt();
            if (resp == 1) {
                ask = false;
                return false;
            } else if (resp == 2) {
                ask = false;
                return true;
            }
        }
        return true;
    }
    
    public static void Ultrapass(){
        
    }

}

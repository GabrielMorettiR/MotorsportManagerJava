package mmgame;

import static mmgame.Funcoes.Delay;
import static mmgame.Funcoes.con;
import static mmgame.Funcoes.insert;
import static mmgame.Funcoes.consulta;
import static mmgame.Funcoes.limparSaida;
import static mmgame.Funcoes.valorInt;

/**
 *
 * @author Gabriel
 */
public class Jogo {

    public static int nTimes = 10;
    public static String times[] = new String[nTimes];

    public static void Carreira() {
    }

    public static void Corrida(int time) {
        time = escolhaTime();
        //pista = escolhePista();
        int voltas = 5;
        for (int volta = 1; volta <= voltas; volta++) {
            Tabela(volta, voltas);
            Delay(2);
        }
        System.out.println("== Fim da Corrida ==");
    }

    public static int escolhaTime() {

        String sql = "Select nome from teams";
        String col = "nome";
        String resp = "Escolha um time: ";
        con();
        times = consulta(sql, col);

        System.out.println("");
        boolean loop = true;
        int time = 1;
        while (loop) {
            for (int i = 0; i < times.length; i++) {
                System.out.println(i + 1 + ". " + times[i]);
            }
            System.out.println("\n " + resp);
            time = valorInt();
            time -= 1;
            if (time < 0 || time > 9) {
                resp = "Escolha uma opção válida";
            } else {
                System.out.println("Você selecionou: " + times[time]);
                loop = Conf();
            }
        }
        return time;
    }

//    public static int escolhePista(){
//    
//    }
    public static void Tabela(int volta, int voltas) {
        limparSaida();
        System.out.println("Volta " + volta + "/ " + voltas);
        for (int i = 0; i < times.length; i++) {
            System.out.println(i + 1 + ". " + times[i]);
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

}

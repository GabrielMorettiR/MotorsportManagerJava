package mmgame;

import static mmgame.Funcoes.SalvaEquipes;
import static mmgame.Funcoes.SalvaPilotos;
import static mmgame.Funcoes.con;
import static mmgame.Jogo.Corrida;
import static mmgame.Funcoes.valorInt;
import static mmgame.Jogo.Equipes;

/**
 *
 * @author Gabriel
 */

/* 
SIMBOLOS: \  || ➥ ❖ • ➠ ▸


*/
public class MMGame {

    public static void main(String[] args) {
        con();
        SalvaEquipes();
        SalvaPilotos();
        Menu();
    }

    public static void Menu() {
        boolean menu = true;
        while (menu) {
            System.out.println("== MENU ==\n"
                    + "1 - Carreira\n"
                    + "2 - Corrida Rápida\n"
                    + "3 - Ver Equipes\n"
                    + "4 - Créditos\n"
                    + "5 - Sair");
            int op = valorInt();

            switch (op) {
                case 1:
                    Carreira.Menu();
                    break;
                case 2:
                    Corrida(-1);
                    break;
                case 3:
                    Equipes();
                    break;
                case 4:
                    Cred();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Selecione uma opção válida");
            }
        }
    }

    private static void Cred() {
        System.out.println("Eu q fiz");
    }

}

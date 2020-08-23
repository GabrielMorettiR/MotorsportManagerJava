/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmgame;

import static mmgame.Funcoes.eqp;
import static mmgame.Funcoes.escolhaTime;
import static mmgame.Funcoes.limparSaida;
import static mmgame.Funcoes.valorInt;
import static mmgame.Jogo.Corrida;

/**
 *
 * @author Gabriel
 */
/*
SIMBOLOS: \  || ➥ ❖ • ➠ ▸
*/

public class Carreira {

    private static int id;

    public static void Menu() {
        boolean menu = true;
        while (menu) {
            limparSaida();
            System.out.println("== Carreira ==\n"
                    + "1 - Nova Carreira\n"
                    + "2 - Carregar\n"
                    + "3 - Voltar");
            int op = valorInt();

            switch (op) {
                case 1:
                    MenuCar();
                    break;
                case 2:
                    break;
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.println("Selecione uma opção válida");
            }
        }
    }

    public static void MenuCar() {
        id = escolhaTime();
        boolean menu = true;

        while (menu) {
            limparSaida();
        System.out.println("== " + eqp[id].getNome() + " ==\n"
                + "1 - Próxima Corrida\n"
                + "2 - Carro\n"
                + "3 - Campeonato\n"
                + "4 - Salvar\n"
                + "0 - Sair");
            int op = valorInt();

            switch (op) {
                case 1:
                    Avancar();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Salvar");
                    break;
                case 0:
                    menu = false;
                    break;
                default:
                    System.out.println("Selecione uma opção válida");
            }
        }
    }
    
    public static void Avancar(){
        Corrida(id);
    }
}

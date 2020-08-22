package mmgame;

import static mmgame.Jogo.Corrida;
import static mmgame.Funcoes.valorInt;
import static mmgame.Jogo.Carreira;
/**
 *
 * @author Gabriel
 */

// - \  ||
public class MMGame {    
    
    
    
    public static void main(String[] args) {
        Menu();
    }
    
    public static void Menu(){
        boolean menu = true;
        while(menu){  
            System.out.println("== MENU ==\n"
                        + "1 - Carreira\n"
                        + "2 - Corrida Rápida\n"
                        + "3 - Créditos\n"
                        + "4 - Sair");
            int op = valorInt();

            switch(op){
                case 1: Carreira();
                    break;
                case 2: Corrida(1);
                    break;
                case 3: Cred();
                    break;
                case 4: System.exit(0);
                default: System.out.println("Selecione uma opção válida");
            }
        }
    }
    
    private static void Cred(){
        System.out.println("Eu q fiz");
    }
    
}

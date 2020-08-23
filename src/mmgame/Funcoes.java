package mmgame;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static mmgame.Jogo.nTimes;

/**
 *
 * @author Gabriel
 */
public class Funcoes {

    public static Connection con;
    public static Statement st;
    public static Equipe[] eqp = new Equipe[10];
    public static Piloto[] pil = new Piloto[20];

    public static int valorInt() { // recebe um inteiro
        Scanner ler = new Scanner(System.in);
        int in = ler.nextInt();
        return in;
    }

    public static void PedeEnter() {
        System.out.print("Aperte Enter para continuar");
        Scanner ler = new Scanner(System.in);
        ler.nextLine();
    }

    public static void con() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mm?zeroDateTimeBehavior=convertToNull", "root", "");
            st = (Statement) con.createStatement();
            //System.out.println("A conexão foi realizada");
        } catch (Exception e) {
            System.out.println("Conexão não realizada");
        }
    }

    public static void insert(String sql) {

        try {
            st.executeUpdate(sql);
            System.out.println("Registro Gravado");

        } catch (Exception e) {
            System.out.println("Não foi possível gravar o registro");
        }
    }

    public static String[] consulta(String sql, String coluna, int size) {
        ResultSet resultado;
        String res[] = new String[size];
        try {

            resultado = st.executeQuery(sql);

            for (int i = 0; resultado.next(); i++) {
                res[i] = resultado.getString(coluna);
            }

        } catch (Exception e) {
            System.out.println("Registro não encontrado");
        }
        return res;
    }

    /*=== Adiciona os valores do BD na classe Equipe ===*/
    public static void SalvaEquipes() {
        String sql = "SELECT t.time_id, t.nome, t.orcamento, t.p1id, t.p2Id, c.carroNvl from teams AS t, cars AS c WHERE t.carro_id = c.carro_id;";
        String id[] = consulta(sql, "time_id", eqp.length);
        String nome[] = consulta(sql, "nome", eqp.length);
        String orcam[] = consulta(sql, "orcamento", eqp.length);
        String carrolvl[] = consulta(sql, "carroNvl", eqp.length);
        String p1[] = consulta(sql, "p1Id", eqp.length);
        String p2[] = consulta(sql, "p2Id", eqp.length);

        for (int i = 0; i < eqp.length; i++) {
            int tId = Integer.parseInt(id[i]);
            float tOrca = Float.parseFloat(orcam[i]);
            int tCar = Integer.parseInt(carrolvl[i]);
            int p1id = Integer.parseInt(p1[i]) - 1;
            int p2id = Integer.parseInt(p2[i]) - 1;
            eqp[i] = new Equipe(tId, nome[i], tOrca, tCar, p1id, p2id);
        }
    }

    public static void SalvaPilotos() {
        String sql = "SELECT p.nome, p.lvl, t.time_id from pilots AS p, teams AS t WHERE p.piloto_id = t.p1id OR p.piloto_id = t.p2id;";
        String lvl[] = consulta(sql, "lvl", pil.length);
        String nome[] = consulta(sql, "nome", pil.length);
        String tId[] = consulta(sql, "time_id", pil.length);

        for (int i = 0; i < pil.length; i++) {
            int id = Integer.parseInt(tId[i]);
            int level = Integer.parseInt(lvl[i]);
            pil[i] = new Piloto(nome[i], level, id);
        }
    }

    public static int escolhaTime() {

        String resp = "Escolha um time: ";
        //con();

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

    public static void Delay(double seg) {
        seg = seg * 1000;
        int s = (int) seg;
        try {
            Thread.sleep(s);
        } catch (InterruptedException ex) {
        }
    }

    public final static void limparSaida() {
        for(int i=0; i <400;i++){
            System.out.print("\r\n");
        }
//        try {
//            Robot robot = new Robot();
//            robot.setAutoDelay(1);
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_L);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.keyRelease(KeyEvent.VK_L);
//        } catch (AWTException ex) {
//        }
    }

    public static boolean Conf() {
        boolean ask = true;
        while (ask) {
            System.out.println("Esta é sua equipe? 1- Sim 2- Não");
            int resp = valorInt();
            if (resp == 1) {
                return false;
            } else if (resp == 2) {
                return true;
            }
        }
        return true;
    }

}

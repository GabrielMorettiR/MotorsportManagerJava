package mmgame;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import mmgame.Equipe;

/**
 *
 * @author Gabriel
 */
public class Funcoes {

    public static Connection con;
    public static Statement st;
    public Equipe[] eqp = new Equipe[10];

    public static int valorInt() { // recebe um inteiro
        Scanner ler = new Scanner(System.in);
        int in = ler.nextInt();
        return in;
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

    public static String[] consulta(String sql, String coluna) {
        ResultSet resultado;
        String res[] = new String[10];
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

    public static void Delay(int seg) {
        seg = seg * 1000;
        try {
            Thread.sleep(seg);
        } catch (InterruptedException ex) {
        }
    }

    public final static void limparSaida() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(1);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }
    
    public void SalvaEquipes(){
        String sql = "select * from teams";
        String id[] = consulta(sql, "time_id");
        String nome[] = consulta(sql, "nome");
        String orcam[] = consulta(sql, "orcamento");
        String carrolvl[] = consulta(sql, "carroNvl");
        
        for(int i=1; i<eqp.length;i++){}
        
        
        
        for(int i=1; i<eqp.length;i++){
//            eqp[i] = new Equipe(id[i],nome[i],orcam[i],carrolvl[i]);
        }
    }

}

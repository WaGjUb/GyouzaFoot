/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot;
import gyouzafoot.DAOs.*;
import gyouzafoot.Objetos.*;
import java.sql.SQLException;
/**
 *
 * @author hydrocat
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        AssistenteConexao ac = new AssistenteConexao();
        ac.getConnection();
        
        Jogador j = new Jogador("Rouney", 15);
        JogadorDAO jd;
        jd = new JogadorDAO(ac);
        jd.remover(j);
                
                
                }

    
}

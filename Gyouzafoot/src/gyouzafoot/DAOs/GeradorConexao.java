/*
 * Copyright (C) 2015 hydrocat
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package gyouzafoot.DAOs;

//import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author hydrocat
 */
public class GeradorConexao {
    
    public Connection GeradorConexao( CredenciaisConexao c )
    {
        try 
        {
            String url = "jdbc:mysql://"+c.getIp()+"/"+c.getNomeBanco();
            return DriverManager.getConnection( url, c.getUsuario(), c.getSenha() );
            
        }catch( SQLException e )
        {
            System.out.println("Erro na conecção, "+ e.getMessage() );
        }
        
        //se falhar..
        return null;
    }
        
    public static void main(String[] args) {
                CredenciaisConexao cc = new CredenciaisConexao("localhost","gyouzafoot", "Usuario", "senha");
        Connection c = new GeradorConexao().GeradorConexao(cc);
        System.out.println(c.toString());
        try {
            ResultSet r = c.prepareStatement("show tables;").executeQuery();
            while ( r.next() )
            {
                System.out.println( r.getString(1) );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
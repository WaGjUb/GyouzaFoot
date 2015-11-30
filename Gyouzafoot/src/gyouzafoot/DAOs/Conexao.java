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
public class Conexao {
    
    public Connection getConnection( CredenciaisConexao c )
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
    
    public void closeConnection( ResultSet rs ) throws SQLException
    {
        rs.close();
    }
    
    public void closeConnection( Connection c ) throws SQLException
    {
        c.close();
    }
            
    public void closeConnection( PreparedStatement p ) throws SQLException
    {
        p.close();
    }
    
    public void closeAllConnections( ResultSet rs, Connection c, PreparedStatement p )throws SQLException
    {
        closeConnection(c);
        closeConnection(rs);
        closeConnection(p);
    }
            
    public void closeAllConnections( Connection c, PreparedStatement p )throws SQLException
    {
        closeConnection(c);
        closeConnection(p);
    }
        
    
    
    public static void main(String[] args) {
                CredenciaisConexao cc = new CredenciaisConexao("localhost","gyouzafoot", "Usuario", "senha");
        Connection c = new Conexao().getConnection(cc);
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
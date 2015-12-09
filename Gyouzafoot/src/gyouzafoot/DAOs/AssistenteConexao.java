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
public class AssistenteConexao {
    
    public Connection getConnection( )
    {
        CredenciaisConexao c = new CredenciaisConexao("localhost", "gyouzafoot", "hydrocat", "");
        try 
        {
            String url = "jdbc:mysql://"+c.getIp()+"/"+c.getNomeBanco();
            return DriverManager.getConnection( url, c.getUsuario(), c.getSenha() );
            
        }catch( SQLException e )
        {
            System.out.println("Erro na conexão, "+ e.getMessage() );
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
        
}
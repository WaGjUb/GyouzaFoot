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

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Connection;

import java.sql.*;
import gyouzafoot.Objetos.CartaoAmarelo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hydrocat
 */
public class CartaoAmareloDAO{
    
    Connection c;
    
    public CartaoAmareloDAO( CredenciaisConexao cc )
    {
        this.c = new GeradorConexao().GeradorConexao(cc);
    }
    
    public boolean inserir( CartaoAmarelo c )
    {
        String sql = "insert into cartao_amarelo (id_participacao) values (?)";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, c.getIdParticipacao() );
            s.executeQuery();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
    
}
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
    
    public boolean inserir( CartaoAmarelo cartao )
    {
        String sql = "insert into cartao_amarelo (id_participacao) values (?)";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, cartao.getIdParticipacao() );
            s.executeQuery();
            
            s.close();
            this.c.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
    
    public boolean remover( CartaoAmarelo cartao )
    {
        String sql = "delete from cartao_amarelo where id = ?";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, cartao.getId() );
            s.executeQuery();
            
            s.close();
            this.c.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        
    public boolean alterar( CartaoAmarelo cartao )
    {
        String sql = "update cartao_amarelo set id_participacao = ? where id = ?";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, cartao.getIdParticipacao() );
            s.setInt(2, cartao.getId() );
            s.executeQuery();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public CartaoAmarelo buscar( int id )
    {
        String sql = "select * from cartao_amarelo where id = ?";
        CartaoAmarelo cartao = new CartaoAmarelo();
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, id );
            ResultSet rs = s.executeQuery();
            
            while( rs.next() )
            {
                cartao.setIdParticipacao( rs.getInt("id_participacao") );
                cartao.setId( rs.getInt( "id" ) );
            }
            
            s.close();
            this.c.close();
            
            return cartao;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }    
    }
    
    public static void main(String[] args) {
        CredenciaisConexcao cc = new CredenciaisConexcao("localhost", "gyouzafoot", "hydrocat", "M!34332675");
        //Connection c = new GeradorConexao().GeradorConexao(cc);
        
        CartaoAmareloDAO cd = new CartaoAmareloDAO( cc );
        CartaoAmarelo cartao = new CartaoAmarelo();
        cartao.
    }
}
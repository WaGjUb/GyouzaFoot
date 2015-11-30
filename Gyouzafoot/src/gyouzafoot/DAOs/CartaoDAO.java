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
import gyouzafoot.Objetos.Cartao;

/**
 *
 * @author hydrocat
 */
public class CartaoDAO{
    
    Connection c;
    
    public CartaoDAO( CredenciaisConexao cc )
    {
        this.c = new GeradorConexao().GeradorConexao(cc);
    }
    
    public boolean inserir( Cartao cartao )
    {
        String sql = "insert into cartao_amarelo (id_participacao) values (?)";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, cartao.getIdParticipacao() );
            s.executeUpdate();
            
            s.close();
            this.c.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro - Inserir - CartaoDAO - \n"+ex.getMessage());
            
            return false;
        }
        
    }
    
    public boolean remover( Cartao cartao )
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
            System.out.println("Erro - Remover - CartaoDAO - \n"+ex.getMessage());
            return false;
        }
    }
        
    public boolean alterar( Cartao cartao )
    {
        String sql = "update cartao_amarelo set id_participacao = ? where id = ?";
        
        try {
            
            PreparedStatement s = this.c.prepareStatement(sql);
            s.setInt( 1, cartao.getIdParticipacao() );
            s.setInt(2, cartao.getId() );
            s.executeQuery();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erro - Alterar - CartaoDAO - \n"+ex.getMessage());
            return false;
        }
    }
    
    public Cartao buscar( int id )
    {
        String sql = "select * from cartao_amarelo where id = ?";
        Cartao cartao = new Cartao();
        
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
            System.out.println("Erro - buscar - CartaoDAO - \n"+ex.getMessage());
            return null;
        }    
    }
    
    public static void main(String[] args) {
        CredenciaisConexao cc = new CredenciaisConexao("localhost", "gyouzafoot", "usuario", "senha");
        //Connection c = new GeradorConexao().GeradorConexao(cc);
        Cartao c = new Cartao();
        c.setIdParticipacao( 3 );
        new CartaoDAO(cc).inserir( c );
        Cartao cartao = new CartaoDAO(cc).buscar( 0 );
        System.out.println(cartao.getId() +" "+ cartao.getIdParticipacao());
    }
}
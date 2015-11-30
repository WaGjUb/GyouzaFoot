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
import java.util.ArrayList;

/**
 *
 * @author hydrocat
 */
public class CartaoDAO {

    Connection c;
    Conexao helper;

    public CartaoDAO(CredenciaisConexao cc) throws SQLException {
        this.helper = new Conexao();
        this.c = helper.getConnection(cc);
    }

    public boolean inserir(Cartao cartao) throws SQLException {
        String sql = "insert into cartao_amarelo (id_participacao) values (?)";

        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.executeUpdate();

        helper.closeAllConnections(c, s);
        return true;

    }

    public boolean remover(Cartao cartao) throws SQLException {
        String sql = "delete from cartao_amarelo where id = ?";

        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, cartao.getId());
        s.executeQuery();

        helper.closeAllConnections(c, s);
        return true;

    }

    public boolean alterar(Cartao cartao) throws SQLException {
        String sql = "update cartao_amarelo set id_participacao = ? where id = ?";

        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.setInt(2, cartao.getId());
        s.executeQuery();
        
        helper.closeAllConnections(c, s);
        return true;

    }

    public Cartao buscar(int id) throws SQLException {
        String sql = "select * from cartao_amarelo where id = ?";
        
        Cartao cartao = null;
        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            cartao = new Cartao( rs.getInt("id"), rs.getInt("id_participacao"));
        }

        helper.closeAllConnections(rs, c, s);
        return cartao;
    }
    
    public ArrayList<Cartao> getList() throws SQLException
    {
        Cartao cartao = null;
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        String sql = "select * from cartao_amarelo";
        
        PreparedStatement ps = this.c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            cartao = new Cartao( rs.getInt("id"), rs.getInt("id_participacao"));
            cartoes.add(cartao);
        }
        
        helper.closeAllConnections(rs, c, ps);
        return cartoes;
    }

    public static void main(String[] args) {
        CredenciaisConexao cc = new CredenciaisConexao("localhost", "gyouzafoot", "usuario", "senha");
        //Connection c = new Conexao().Conexao(cc);
        //Cartao c = new Cartao();
        //c.setIdParticipacao( 3 );
        //new CartaoDAO(cc).inserir( c );
        //Cartao cartao = new CartaoDAO(cc).buscar( 0 );
        //System.out.println(cartao.getId() +" "+ cartao.getIdParticipacao());
    }
}

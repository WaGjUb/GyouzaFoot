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

    AssistenteConexao helper;

    public CartaoDAO(AssistenteConexao helper) throws SQLException {
        this.helper = new AssistenteConexao();
    }

    public boolean inserirCartãoAmarelo(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into cartao_amarelo (id_participacao) values (?)";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.executeUpdate();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean removerCartãoAmarelo(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from cartao_amarelo where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterarCartãoAmarelo(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update cartao_amarelo set id_participacao = ? where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.setInt(2, cartao.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Cartao buscarCartãoAmarelo(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from cartao_amarelo where id = ?";
        
        Cartao cartao = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            cartao = new Cartao( rs.getInt("id"), rs.getInt("id_participacao"));
        }

        helper.closeAllConnections(rs, conexao, s);
        return cartao;
    }
    
    public ArrayList<Cartao> getListCartãoAmarelo() throws SQLException{
        Connection conexao = helper.getConnection();
        Cartao cartao = null;
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        String sql = "select * from cartao_amarelo";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            cartoes.add(
                new Cartao( rs.getInt("id"), rs.getInt("id_participacao"))
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return cartoes;
    }
    
    public boolean inserirCartãoVermelho(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into cartao_vermelho (id_participacao) values (?)";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.executeUpdate();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean removerCartãoVermelho(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from cartao_vermelho where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterarCartãoVermelho(Cartao cartao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update cartao_vermelho set id_participacao = ? where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, cartao.getIdParticipacao());
        s.setInt(2, cartao.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Cartao buscarCartãoVermelho(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from cartao_vermelho where id = ?";
        
        Cartao cartao = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            cartao = new Cartao( rs.getInt("id"), rs.getInt("id_participacao"));
        }

        helper.closeAllConnections(rs, conexao, s);
        return cartao;
    }
    
    public ArrayList<Cartao> getListCartãoVermelho() throws SQLException{
        Connection conexao = helper.getConnection();
        Cartao cartao = null;
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        String sql = "select * from cartao_vermelho";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            cartoes.add(
                new Cartao( rs.getInt("id"), rs.getInt("id_participacao"))
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return cartoes;
    }
}

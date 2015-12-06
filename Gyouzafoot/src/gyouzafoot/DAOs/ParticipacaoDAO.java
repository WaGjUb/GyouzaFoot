/*
 * Copyright (C) 2015 wagjub
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

import java.sql.*;
import gyouzafoot.Objetos.Participacao;
import java.util.ArrayList;

/**
 *
 * @author wagjub
 */
public class ParticipacaoDAO {
 
    AssistenteConexao helper;
      
    public ParticipacaoDAO(AssistenteConexao helper) throws SQLException
    {
        this.helper = helper;
    }
    
    public boolean inserir(Participacao participacao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into participacao (" +
                "id_jogador,"+
                "id_jogo,"+
                "gol_contra,"+
                "gol_valido"+
                "values( ?,?,?,? )";

        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, participacao.getIdJogador());
        s.setInt(2, participacao.getIdJogo());
        s.setInt(3, participacao.getQuantidadeGols());
        s.setInt(4, participacao.getQuantidadeGolsContra());
        
        s.executeUpdate();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Participacao participacao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from participacao where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, participacao.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Participacao participacao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update participacao set id_jogador=? id_jogo=? gol_contra=? gol_valido=? where id = ?";
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, participacao.getIdJogador());
        s.setInt(2, participacao.getIdJogo());
        s.setInt(3, participacao.getQuantidadeGols());
        s.setInt(4, participacao.getQuantidadeGolsContra());
        s.setInt(5, participacao.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Participacao buscar(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from participacao where id = ?";
        
        Participacao participacao = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            participacao = new Participacao(
                    rs.getInt("id"),
                    rs.getInt("id_jogador"),
                    rs.getInt("id_jogo"),
                    rs.getInt("gol_contra"),
                    rs.getInt("gol_valido")
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return participacao;
    }
    
    public ArrayList<Participacao> getList() throws SQLException
    {
        Connection conexao = helper.getConnection();
        ArrayList<Participacao> participacoes = new ArrayList<>();
        String sql = "select * from participacao";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            participacoes.add(
            new Participacao(
                    rs.getInt("id"),
                    rs.getInt("id_jogador"),
                    rs.getInt("id_jogo"),
                    rs.getInt("gol_contra"),
                    rs.getInt("gol_valido")
            )
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return participacoes;
    }

}

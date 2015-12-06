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
import gyouzafoot.Objetos.Suspensao;
import java.util.ArrayList;

public class SuspensaoDAO {
        
    AssistenteConexao helper;
      
    public SuspensaoDAO(AssistenteConexao helper) throws SQLException
    {
        this.helper = helper;
    }
     public boolean inserir(Suspensao suspensao) throws SQLException {
         Connection conexao = helper.getConnection();
        String sql = "insert into suspensao (" +
                "id_participacao,"+
                "qtde_jogos,"+
                "values( ?,? )";

        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, suspensao.getIdParticipacao());
        s.setInt(2, suspensao.getQuantidadeJogos());
        s.executeUpdate();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Suspensao suspensao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from suspensao where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, suspensao.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Suspensao suspensao) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update suspensao set id_participacao=? qtde_jogos=? where id = ?";
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, suspensao.getIdParticipacao());
        s.setInt(2, suspensao.getQuantidadeJogos());
        s.setInt(3, suspensao.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Suspensao buscar(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from suspensao where id = ?";
        
        Suspensao suspensao = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            suspensao = new Suspensao(
                    rs.getInt("id"),
                    rs.getInt("id_participacao"),
                    rs.getInt("qtde_jogos")
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return suspensao;
    }
    
    public ArrayList<Suspensao> getList() throws SQLException
    {
        Connection conexao = helper.getConnection();
        ArrayList<Suspensao> suspensoes = new ArrayList<>();
        String sql = "select * from suspensao";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            suspensoes.add(
            new Suspensao(
                    rs.getInt("id"),
                    rs.getInt("id_participacao"),
                    rs.getInt("qtde_jogos")
            )
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return suspensoes;
    }

}

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
import gyouzafoot.Objetos.Jogador;
import java.util.ArrayList;

public class JogadorDAO {

    AssistenteConexao helper;
      
    public JogadorDAO( AssistenteConexao helper )
    {
        this.helper = helper;
    }
    
    public boolean inserir(Jogador jogador) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into jogadores (" +
                "nome,"+
                "idade )" +
                "values( ?,? )";

        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setString(1, jogador.getNome());
        s.setInt(2, jogador.getIdade());
        
        s.executeUpdate();
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Jogador jogador) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from jogadores where nome = ? and idade = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setString(1, jogador.getNome());
        s.setInt(2, jogador.getIdade());
        
        s.executeUpdate();
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Jogador jogador) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update jogadores set nome=? idade=? where id = ?";
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setString(1, jogador.getNome());
        s.setInt(2, jogador.getIdade());
        s.setInt(3, jogador.getId());
 
        s.executeUpdate();
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Jogador buscar(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from jogadores where id = ?";
        
        Jogador jogador = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            jogador = new Jogador(rs.getInt("id"),rs.getString("nome"),rs.getInt("idade"));
        }

        helper.closeAllConnections(rs, conexao, s);
        return jogador;
    }
    
    public ArrayList<Jogador> getList() throws SQLException
    {
        Connection conexao = helper.getConnection();
        ArrayList<Jogador> jogadors = new ArrayList<>();
        String sql = "select * from jogadores";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            jogadors.add(
                new Jogador(rs.getInt("id"),rs.getString("nome"),rs.getInt("idade"))
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return jogadors;
    }

    
}

/*
 * Copyright (conexao) 2015 wagjub
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
import gyouzafoot.Objetos.Jogo;
import java.util.ArrayList;

/**
 *
 * @author wagjub
 */


public class JogoDAO {
    
    Connection conexao;
    Conexao helper;
      
    public JogoDAO(CredenciaisConexao cc) throws SQLException
    {
        this.helper = new Conexao();
        this.conexao = helper.getConnection(cc);
    }
    
             public boolean inserir(Jogo jogo) throws SQLException {
        String sql = "insert into Jogo (" +
                "nome_adversario,"+
                "PTgyouza,"+
                "PTadversario,"+
                "data)"+
                "values( ?,?,?,? )";

        PreparedStatement s = this.conexao.prepareStatement(sql);
        
        s.setString(1, jogo.getNomeAdversario());
        s.setInt(2, jogo.getPontuacaoTime());
        s.setInt(3, jogo.getPontuacaoTimeAdversario());
        s.setDate(4, jogo.getData());
        
        s.executeUpdate();
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Jogo jogo) throws SQLException {
        String sql = "delete from Jogo where id = ?";

        PreparedStatement s = this.conexao.prepareStatement(sql);
        s.setInt(1, jogo.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Jogo jogo) throws SQLException {
        String sql = "update Jogo set nome_adversario=? PTgyouza=? PTadversario=? data=? where id = ?";
        PreparedStatement s = this.conexao.prepareStatement(sql);
        
        s.setString(1, jogo.getNomeAdversario());
        s.setInt(2, jogo.getPontuacaoTime());
        s.setInt(3, jogo.getPontuacaoTimeAdversario());
        s.setDate(4, jogo.getData());
        s.setInt(5, jogo.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Jogo buscar(int id) throws SQLException {
        String sql = "select * from Jogo where id = ?";
        
        Jogo jogo = null;
        PreparedStatement s = this.conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            jogo = new Jogo(rs.getString("nome_adversario"),
                    rs.getInt("PTgyouza"),
                    rs.getInt("PTadversario"),
                    rs.getDate("data")
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return jogo;
    }
    
    public ArrayList<Jogo> getList() throws SQLException
    {
        ArrayList<Jogo> jogadors = new ArrayList<>();
        String sql = "select * from Jogo";
        
        PreparedStatement ps = this.conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            jogadors.add(
                new Jogo(rs.getString("nome_adversario"),
                    rs.getInt("PTgyouza"),
                    rs.getInt("PTadversario"),
                    rs.getDate("data")
            )
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return jogadors;
    }

}

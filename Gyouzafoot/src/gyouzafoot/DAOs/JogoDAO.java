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
import java.util.Calendar;

/**
 *
 * @author wagjub
 */


public class JogoDAO {
    
    AssistenteConexao helper;
      
    public JogoDAO(AssistenteConexao helper) throws SQLException
    {
        this.helper = helper;
    }
    
    public boolean inserir(Jogo jogo) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into jogo (" +
                "nome_adversario,"+
                "PTgyouza,"+
                "PTadversario,"+
                "data)"+
                "values( ?,?,?,? )";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setString(1, jogo.getNomeAdversario());
        s.setInt(2, jogo.getPontuacaoTime());
        s.setInt(3, jogo.getPontuacaoTimeAdversario());
        s.setDate(4, new Date( jogo.getData().getTime().getTime()));
        
        s.executeUpdate();
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Jogo jogo) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from jogo where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, jogo.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Jogo jogo) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update jogo set nome_adversario=? PTgyouza=? PTadversario=? data=? where id = ?";
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setString(1, jogo.getNomeAdversario());
        s.setInt(2, jogo.getPontuacaoTime());
        s.setInt(3, jogo.getPontuacaoTimeAdversario());
        s.setDate(4,new Date(jogo.getData().getTime().getTime()) );
        s.setInt(5, jogo.getId());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Jogo buscar(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from jogo where id = ?";
        
        Jogo jogo = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        Calendar data = Calendar.getInstance();
        while (rs.next()) {
            data.setTime( rs.getDate("data"));
            jogo = new Jogo(
                    id,
                    rs.getString("nome_adversario"),
                    rs.getInt("PTgyouza"),
                    rs.getInt("PTadversario"),
                    data
                            
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return jogo;
    }
    
    public Jogo buscar( String nomeAdversario, int PTgyouza, int PTAdversario, Calendar data) throws SQLException
    {
        Connection conexao = helper.getConnection();
        String sql = "select * from jogo where "
                + "nome_adversario = ? and "
                + " PTgyouza = ? and "
                + " PTadversario = ? and "
                + " data = ?";
        
        Jogo jogo = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setString(1, nomeAdversario);
        s.setInt(2, PTgyouza);
        s.setInt(3, PTAdversario);
        s.setDate(4, new Date( data.getTime().getTime()));
        
        ResultSet rs = s.executeQuery();

        Calendar dataa = Calendar.getInstance();
        while (rs.next()) {
            dataa.setTime( rs.getDate("data"));
            jogo = new Jogo(
                    rs.getInt("id"),
                    rs.getString("nome_adversario"),
                    rs.getInt("PTgyouza"),
                    rs.getInt("PTadversario"),
                    dataa
                            
            );
        
        }
        helper.closeAllConnections(rs,conexao, s);
        return jogo;
    }
    
    public ArrayList<Jogo> getList() throws SQLException
    {
        Connection conexao = helper.getConnection();
        ArrayList<Jogo> jogadors = new ArrayList<>();
        String sql = "select * from jogo";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Calendar data = Calendar.getInstance();
        while( rs.next() )
        {
            data.setTime(rs.getDate("data"));
            jogadors.add(
                new Jogo(rs.getString("nome_adversario"),
                    rs.getInt("PTgyouza"),
                    rs.getInt("PTadversario"),
                    data
            )
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return jogadors;
    }

}

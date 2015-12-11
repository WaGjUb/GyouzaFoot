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
import gyouzafoot.Objetos.StrInt;
import java.util.ArrayList;
/**
 *
 * @author wagjub
 */
public class Estatisticas {
    
     AssistenteConexao helper;
      
    public Estatisticas(AssistenteConexao helper)
    {
        this.helper = helper;
    }
    
      public ArrayList<StrInt> qntdGolsFeitos() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select J.nome as 'Nome jogador', sum(P.gol_valido) as 'Quantidade de gols' from jogadores J inner join participacao P on J.id = P.id_jogador group by J.id order by sum(P.gol_valido) desc";
        
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        ArrayList<StrInt> gols = new ArrayList();
        while (rs.next()) {
                    gols.add(new StrInt(
                    rs.getString("Nome jogador"),
                    rs.getInt("Quantidade de gols")
            )
                    );
        }

        helper.closeAllConnections(rs, conexao, s);
        return gols;
    }
      
            public ArrayList<StrInt> qntdFaltasCometidas() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select J.nome as 'Nome jogador', count(F.id) as 'Quantidade de faltas' from jogadores J inner join participacao P on J.id = P.id_jogador inner join faltas_cometidas F on F.id_participacao = p.id group by J.id order by count(F.id) desc";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        ArrayList<StrInt> faltas = new ArrayList();
        while (rs.next()) {
                    faltas.add(new StrInt(
                    rs.getString("Nome jogador"),
                    rs.getInt("Quantidade de faltas")
            )
                    );
                    
        }

        helper.closeAllConnections(rs, conexao, s);
        return faltas;
    }
            
            public int qntdJogos() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select count(J.id) as 'Quantidade de jogos' from jogo J";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
         int valor = 0;
        while (rs.next()) {                   
                    valor = rs.getInt("Quantidade de jogos");
        }

        helper.closeAllConnections(rs, conexao, s);
        return valor;
    }
            
             public int vitorias() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select count(J.id) as 'Vitorias' from jogo J where J.PTgyouza > J.PTadversario";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
         int vitorias = 0;
        while (rs.next()) {                   
                    vitorias = rs.getInt("Vitorias");
        }

        helper.closeAllConnections(rs, conexao, s);
        return vitorias;
        
             }
                          public int empates() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select count(J.id) as 'Empates' from jogo J where J.PTgyouza = J.PTadversario";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
         int empates = 0;
        while (rs.next()) {                   
                    empates = rs.getInt("Empates");
        }

        helper.closeAllConnections(rs, conexao, s);
        return empates;
             }
                          
        public int derrotas() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select count(J.id) as 'Derrotas' from jogo J where J.PTgyouza < J.PTadversario";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
         int derrotas = 0;
        while (rs.next()) {                   
                    derrotas = rs.getInt("Derrotas");
        }

        helper.closeAllConnections(rs, conexao, s);
        return derrotas;
             }
            
  /*      public int jogoMaisPontuado() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select count(J.id) as 'Quantidade de jogos' from jogo J";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
         int valor = 0;
        while (rs.next()) {                   
                    valor = rs.getInt("Quantidade de jogos");
        }

        helper.closeAllConnections(rs, conexao, s);
        return valor;
    }*/
            
            
            
            
}

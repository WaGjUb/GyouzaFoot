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
    
      public void qntdGolsFeitos() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select J.nome as 'Nome jogador', sum(P.gol_valido) as 'Quantidade de gols' from jogadores J inner join participacao P on J.id = P.id_jogador group by J.id";
        
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            //ALTERAR PARA A FORMA DE RETORNO  (STRING, INT)
                    OBJETO = new OBJETO(
                    rs.getString("Nome jogador"),
                    rs.getInt("Quantidade de gols")
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return OBJETO;
    }
      
            public void qntdFaltasTomadas() throws SQLException {
        Connection conexao = helper.getConnection();
        //verificar o group by
    String sql = "select J.nome as 'Nome jogador', count(F.id) as 'Quantidade de faltas' from jogadores J inner join participacao P on J.id = P.id_jogador inner join faltas_cometidas F group by J.id";
   
      
        PreparedStatement s = conexao.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            //ALTERAR PARA A FORMA DE RETORNO  (STRING, INT)
                    OBJETO = new OBJETO(
                    rs.getString("Nome jogador"),
                    rs.getInt("Quantidade de faltas")
            );
        }

        helper.closeAllConnections(rs, conexao, s);
        return OBJETO;
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
            
        Public int jogoMaisPontuado() throws SQLException {
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
            
            
            
            
}

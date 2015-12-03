package gyouzafoot.DAOs;

import gyouzafoot.Objetos.Cartao;
import java.sql.*;
import gyouzafoot.Objetos.Contrato;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 *
 * @author wagjub
 */
public class ContratoDAO {
    
    Connection c;
    Conexao helper;
      
    public ContratoDAO(CredenciaisConexao cc)
    {
        this.helper = new Conexao();
        c = helper.getConnection(cc);
        
    }
    
    
    public boolean inserir(Contrato contrato) throws SQLException {
        String sql = "insert into contrato (" +
                "id_jogador,"+
                "entrada,"+
                "saida,"+
                "camisa,"+
                "posicao"+
                ") values ( ?,?,?,?,?)";

        PreparedStatement s = this.c.prepareStatement(sql);
        
        LocalDate entrada = contrato.getEntrada();
        Calendar.DATE c = new Calendar
        LocalDate saida = contrato.getSaida();
                
        s.setInt(1, contrato.getIdJogador());
        s.setDate(2, new java.sql.Date( entrada.getYear(), entrada.getMonthValue(), entrada.getDayOfMonth() ));
        s.setInt(3, contrato.getIdJogador());
        s.setInt(4, contrato.getIdJogador());
        s.setInt(5, contrato.getIdJogador());
        
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

    
}

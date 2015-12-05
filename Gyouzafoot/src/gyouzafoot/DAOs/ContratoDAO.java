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
import gyouzafoot.Objetos.Contrato;
import java.util.ArrayList;

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
        
        s.setInt(1, contrato.getIdJogador());
        s.setDate(2, contrato.getEntrada());
        s.setDate(3, contrato.getSaida());
        s.setInt(4, contrato.getCamiseta());
        s.setInt(5, contrato.getIdPosicao());
        
        s.executeUpdate();

        helper.closeAllConnections(c, s);
        return true;

    }

    public boolean remover(Contrato contrato) throws SQLException {
        String sql = "delete from contrato where id = ?";

        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, contrato.getId());
        s.executeQuery();

        helper.closeAllConnections(c, s);
        return true;

    }

    public boolean alterar(Contrato contrato) throws SQLException {
        String sql = "update contrato set id_jogador=? entrada=? saida=? camisa=? where id = ?";
        PreparedStatement s = this.c.prepareStatement(sql);
        
        s.setInt(1, contrato.getIdJogador());
        s.setDate(2, contrato.getEntrada());
        s.setDate(3, contrato.getSaida());
        s.setInt(4, contrato.getCamiseta());
        s.setInt(5, contrato.getId());
        s.executeQuery();
        
        helper.closeAllConnections(c, s);
        return true;

    }

    public Contrato buscar(int id) throws SQLException {
        String sql = "select * from cartao_amarelo where id = ?";
        
        Contrato contrato = null;
        PreparedStatement s = this.c.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            contrato = new Contrato(rs.getInt("id"),rs.getInt("id_jogador"),rs.getDate("entrada"), rs.getDate("saida"),rs.getInt("camisa"), rs.getInt("id_posicao"));
        }

        helper.closeAllConnections(rs, c, s);
        return contrato;
    }
    
    public ArrayList<Contrato> getList() throws SQLException
    {
        Contrato contrato = null;
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        String sql = "select * from contrato";
        
        PreparedStatement ps = this.c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            contrato = new Contrato(rs.getInt("id"),rs.getInt("id_jogador"),rs.getDate("entrada"), rs.getDate("saida"),rs.getInt("camisa"), rs.getInt("id_posicao"));
            contratos.add(contrato);
        }
        
        helper.closeAllConnections(rs, c, ps);
        return contratos;
    }

    
}

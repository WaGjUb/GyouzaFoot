/*
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
import gyouzafoot.Objetos.Falta;
import java.util.ArrayList;
/**
 *
 * @author wagjub
 */
public class FaltaTomadaDAO {
        
    AssistenteConexao helper;
      
    public FaltaTomadaDAO(AssistenteConexao helper) throws SQLException
    {
        this.helper = helper;
    }
    
     public boolean inserir(Falta falta) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "insert into faltas_tomadas (" +
                " id_participacao,"+
                "gravidade )" +
                "values( ?,? )";

        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, falta.getIdParticipacao());
        s.setInt(2, falta.getGravidade());
        
        s.executeUpdate();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean remover(Falta falta) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "delete from faltas_tomadas where id = ?";

        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, falta.getId());
        s.executeQuery();

        helper.closeAllConnections(conexao, s);
        return true;

    }

    public boolean alterar(Falta falta) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "update faltas_tomadas set id_participacao=? gravidade=? where id = ?";
        PreparedStatement s = conexao.prepareStatement(sql);
        
        s.setInt(1, falta.getIdParticipacao());
        s.setInt(5, falta.getGravidade());
        s.executeQuery();
        
        helper.closeAllConnections(conexao, s);
        return true;

    }

    public Falta buscar(int id) throws SQLException {
        Connection conexao = helper.getConnection();
        String sql = "select * from faltas_tomadas where id = ?";
        
        Falta falta = null;
        PreparedStatement s = conexao.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            falta = new Falta(rs.getInt("id"),rs.getInt("id_participacao"),rs.getInt("gravidade"));
        }

        helper.closeAllConnections(rs, conexao, s);
        return falta;
    }
    
    public ArrayList<Falta> getList() throws SQLException
    {
        Connection conexao = helper.getConnection();
        ArrayList<Falta> faltas = new ArrayList<>();
        String sql = "select * from faltas_tomadas";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            faltas.add(
            new Falta(rs.getInt("id"),rs.getInt("id_participacao"),rs.getInt("gravidade"))
            );
        }
        
        helper.closeAllConnections(rs, conexao, ps);
        return faltas;
    }

    
    
    
}
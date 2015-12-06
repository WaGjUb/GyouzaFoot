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
        
    Connection con;
    Conexao helper;
      
    public FaltaTomadaDAO(CredenciaisConexao cc) throws SQLException
    {
        this.helper = new Conexao();
        this.con = helper.getConnection(cc);
    }
    
     public boolean inserir(Falta falta) throws SQLException {
        String sql = "insert into falta_tomadas (" +
                " id_participacao,"+
                "gravidade )" +
                "values( ?,? )";

        PreparedStatement s = this.con.prepareStatement(sql);
        
        s.setInt(1, falta.getIdParticipacao());
        s.setInt(2, falta.getGravidade());
        
        s.executeUpdate();

        helper.closeAllConnections(con, s);
        return true;

    }

    public boolean remover(Falta falta) throws SQLException {
        String sql = "delete from falta_tomadas where id = ?";

        PreparedStatement s = this.con.prepareStatement(sql);
        s.setInt(1, falta.getId());
        s.executeQuery();

        helper.closeAllConnections(con, s);
        return true;

    }

    public boolean alterar(Falta falta) throws SQLException {
        String sql = "update faltas_tomadas set id_participacao=? gravidade=? where id = ?";
        PreparedStatement s = this.con.prepareStatement(sql);
        
        s.setInt(1, falta.getIdParticipacao());
        s.setInt(5, falta.getGravidade());
        s.executeQuery();
        
        helper.closeAllConnections(con, s);
        return true;

    }

    public Falta buscar(int id) throws SQLException {
        String sql = "select * from faltas_tomadas where id = ?";
        
        Falta falta = null;
        PreparedStatement s = this.con.prepareStatement(sql);
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            falta = new Falta(rs.getInt("id"),rs.getInt("id_participacao"),rs.getInt("gravidade"));
        }

        helper.closeAllConnections(rs, con, s);
        return falta;
    }
    
    public ArrayList<Falta> getList() throws SQLException
    {
        ArrayList<Falta> faltas = new ArrayList<>();
        String sql = "select * from falta";
        
        PreparedStatement ps = this.con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            faltas.add(
            new Falta(rs.getInt("id"),rs.getInt("id_participacao"),rs.getInt("gravidade"))
            );
        }
        
        helper.closeAllConnections(rs, con, ps);
        return faltas;
    }

    
    
    
}
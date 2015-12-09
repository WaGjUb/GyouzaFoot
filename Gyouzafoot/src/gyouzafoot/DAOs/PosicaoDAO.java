/*
 * Copyright (C) 2015 hydrocat
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

import com.mysql.jdbc.Connection;
import gyouzafoot.Objetos.Posicao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hydrocat
 */
public class PosicaoDAO {
    AssistenteConexao helper;
    
    public PosicaoDAO( AssistenteConexao helper )
    {
        this.helper = helper;
    }
    
    public ArrayList<Posicao> getList() throws SQLException
    {
        java.sql.Connection conexao = helper.getConnection();
        ArrayList<Posicao> lista = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select * from posicao");
        
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() )
        {
            lista.add(
                    new Posicao(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("sigla")
                    )
            );
        }
        
        helper.closeAllConnections(rs,conexao,ps);
        return lista;
    }
    
}

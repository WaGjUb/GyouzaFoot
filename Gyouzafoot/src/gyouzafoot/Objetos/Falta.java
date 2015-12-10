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
package gyouzafoot.Objetos;

/**
 *
 * @author hydrocat
 */
public class Falta implements gyouzafoot.interfaces.Falta{

    private int id;
    private final int idParticipacao;
    private final int gravidade;
    
    
    public Falta(int id, int idParticipacao, int gravidade)
    {
        this.id = id;
        this.idParticipacao = idParticipacao;
        this.gravidade = gravidade;
    }
    
    public Falta(int idParticipacao, int gravidade)
    {
        this.idParticipacao = idParticipacao;
        this.gravidade = gravidade;
    }
    
    @Override
    public int getIdParticipacao() {
        return this.idParticipacao;
    }

    @Override
    public int getId() {
        return this.id;
    }    

    @Override
    public int getGravidade() {
        return this.gravidade;
    }
}

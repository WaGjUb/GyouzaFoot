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
 * @author wagjub
 */
public class Suspensao  implements gyouzafoot.interfaces.Suspensao{

    private int id;
    private int idParticipacao;
    private int quantidadeJogos;
    
    public Suspensao(int id, int idParticipacao, int quantidadeJogos)
    {
        this.id = id;
        this.idParticipacao = idParticipacao;
        this.quantidadeJogos = quantidadeJogos;
    }
   
    public Suspensao(int idParticipacao, int quantidadeJogos)
    {
        this.idParticipacao = idParticipacao;
        this.quantidadeJogos = quantidadeJogos;
    }
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getIdParticipacao() {
        return this.idParticipacao;
    }

    @Override
    public int getQuantidadeJogos() {
        return this.quantidadeJogos;
    }
}

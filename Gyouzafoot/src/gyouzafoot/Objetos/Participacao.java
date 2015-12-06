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
public class Participacao implements gyouzafoot.interfaces.Particiapacao{

    private int id;
    private int idJogador;
    private int idJogo;
    private int golsContra;
    private int golsValidos;
    
    public Participacao(int id, int idJogador, int idJogo, int golsContra, int golsValidos)
    {
        this.id = id;
        this.idJogador = idJogador;
        this.idJogo = idJogo;
        this.golsContra = golsContra;
        this.golsValidos = golsValidos;
    }
    
    public Participacao(int idJogador, int idJogo, int golsContra, int golsValidos)
    {
        this.idJogador =idJogador;
        this.idJogo = idJogo;
        this.golsContra = golsContra;
        this.golsValidos = golsValidos;
    }
    
    
    @Override
    public int getIdJogador() {
        return this.idJogador;
    }

    @Override
    public int getIdJogo() {
        return this.idJogo;
    }
    

    @Override
    public int getQuantidadeGols() {
        return this.golsValidos;
    }

    @Override
    public int getQuantidadeGolsContra() {
        return this.golsContra;
    }

    @Override
    public int getId() {
        return this.id;
    }
}

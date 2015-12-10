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

import java.util.Calendar;

/**
 *
 * @author hydrocat
 */
public class Contrato implements gyouzafoot.interfaces.Contrato {
    
    private int id;
    private int idJogador;
    private Calendar entrada;
    private Calendar saida;
    private int camisa;
    private int idposicao;
    
    public Contrato (int id, int idJogador, Calendar entrada, Calendar saida, int camisa, int idposicao) {    
        
        this.id = id;
        this.idJogador = idJogador;
        this.entrada = entrada;
        this.saida = saida;
        this.camisa = camisa;
        this.idposicao = idposicao;
    }
    
    public Contrato (int idJogador, Calendar entrada, Calendar saida, int camisa, int idposicao) {    
        this.idJogador = idJogador;
        this.entrada = entrada;
        this.saida = saida;
        this.camisa = camisa;
        this.idposicao = idposicao;
    }
    
    @Override
    public int getIdJogador() {
        return this.idJogador;
    }

    @Override
    public Calendar getEntrada() {
        return this.entrada;
    }

    @Override
    public Calendar getSaida() {
        return this.saida;
    }

    @Override
    public int getCamiseta() {
        return this.camisa;
    }

    @Override
    public int getIdPosicao() {
        return this.idposicao;
        
    }

    @Override
    public int getId() {
        return this.id;
    }    
}

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
public class Contrato implements gyouzafoot.interfaces.Contrato {
    
    private int id;
    private int idJogador;
    private java.sql.Date entrada;
    private java.sql.Date saida;
    private int camisa;
    private String posicao;
    
    Contrato (int id, int idJogador, java.sql.Date entrada, java.sql.Date saida, int camisa, String posicao) {    
        this.id = id;
        this.idJogador = idJogador;
        this.entrada = entrada;
        this.saida = saida;
        this.camisa = camisa;
        this.posicao = posicao;
    }
    
       Contrato (int idJogador, java.sql.Date entrada, java.sql.Date saida, int camisa, String posicao) {    
        this.idJogador = idJogador;
        this.entrada = entrada;
        this.saida = saida;
        this.camisa = camisa;
        this.posicao = posicao;
    }
    
    @Override
    public int getIdJogador() {
        return this.idJogador;
    }

    @Override
    public java.sql.Date getEntrada() {
        return this.entrada;
    }

    @Override
    public java.sql.Date getSaida() {
        return this.saida;
    }

    @Override
    public int getCamiseta() {
        return this.camisa;
    }

    @Override
    public String getPosicao() {
        return this.posicao;
        
    }

    @Override
    public int getId() {
        return this.id;
    }    
}

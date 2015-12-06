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
import java.sql.Date;
/**
 *
 * @author hydrocat
 */
public class Jogo implements gyouzafoot.interfaces.Jogo{

    private int id;
    private String nomeAdversario;
    private int pontuacaoTime;
    private int pontuacaoAdversario;
    private java.sql.Date data;
    
    public Jogo(int id, String nomeAdversario, int pontuacaoTime, int pontuacaoAdversario, java.sql.Date data)
    {
        this.id = id;
        this.nomeAdversario = nomeAdversario;
        this.pontuacaoTime = pontuacaoTime;
        this.pontuacaoAdversario = pontuacaoAdversario;
        this.data = data;
    }
    
    public Jogo(String nomeAdversario, int pontuacaoTime, int pontuacaoAdversario, java.sql.Date data)
    {
        this.nomeAdversario = nomeAdversario;
        this.pontuacaoTime = pontuacaoTime;
        this.pontuacaoAdversario = pontuacaoAdversario;
        this.data = data;
    }
    
    @Override
    public int getPontuacaoTimeAdversario() {
        return this.pontuacaoAdversario;
    }

    @Override
    public int getPontuacaoTime() {
        return this.pontuacaoTime;
    }

    @Override
    public String getNomeAdversario() {
        return this.nomeAdversario;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Date getDate() {
        return this.data;
    }
}

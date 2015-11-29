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
package gyouzafoot.interfaces;
import gyouzafoot.Objetos.Participacao;
/**
 *
 * @author hydrocat
 */
public interface Suspensao {
    
    public int getId();
    public int getIdParticipacao();
    public int getQuantidadeJogos();
    
    public int setParticipacao( Participacao p );
    public int setQuantidadeJogos( int jogos );
    //id é incrementado automaticamente no banco
    //public int setId();
}

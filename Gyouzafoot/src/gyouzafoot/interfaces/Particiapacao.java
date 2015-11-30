/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;
import gyouzafoot.Objetos.Jogador;
import gyouzafoot.Objetos.Jogo;
/**
 *
 * @author hydrocat
 */
public interface Particiapacao {
    public int getIdJogador();
    public int getIdJogo();
    public int getQuantidadeGols();
    public int getQuantidadeGolsContra();    
    public int getId();
    
    public void setJogador( Jogador j );
    public void setJogo( Jogo j );
    public void setQuantidadeGols( int gols);
    public void setQuantidadeGolsContra( int gols );
    public void setId( int id );
}

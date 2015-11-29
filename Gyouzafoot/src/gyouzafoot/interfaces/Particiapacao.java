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
    
    public int setJogador( Jogador j );
    public int setJogo( Jogo j );
    public int setQuantidadeGols( int gols);
    public int setQuantidadeGolsContra( int gols );
    
    //id é incrementado automaticamente no banco
    //public int setId();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;

/**
 *
 * @author hydrocat
 */
public interface Jogo {
    public int getPontuacaoTimeAdversario();
    public int getPontuacaoTime();
    public String getNomeAdversario();
    public int getId();

    
    public int setPontuacaoTimeAdversario( int Pontos);
    public int setPontuacaoTime( int Pontos );
    public int setNomeAdversario( String Nome );
    
    //id é incrementado automaticamente no banco
    //public int setId();
    
}

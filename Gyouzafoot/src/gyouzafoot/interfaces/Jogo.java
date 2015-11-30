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

    //Estes objetos não sao mutaveis.
    //public void setPontuacaoTimeAdversario( int Pontos);
    //public void setPontuacaoTime( int Pontos );
    //public void setNomeAdversario( String Nome );
    //public void setId( int id );
    
}

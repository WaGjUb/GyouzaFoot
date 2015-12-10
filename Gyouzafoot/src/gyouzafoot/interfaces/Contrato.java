/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;

import java.util.Calendar;

/**
 *
 * @author hydrocat
 */
public interface Contrato {
    /*Getters
    Métodos gerais para o acesso aos objetos
    */
    public int getIdJogador();
    public Calendar getEntrada();
    public Calendar getSaida();
    public int getCamiseta();
    public int getIdPosicao();
    public int getId(); 

    /*Setters*/
    //Estes objetos não sao mutaveis.
    //public void setEntrada( LocalDate data );
    //public void setSaida( LocalDate data );
    //public void setCamiseta( int numero );
    //public void setPosicao( String Posicao ); 
    //public void setIdJogador( int jogador );
    //public void setId( int id );
}

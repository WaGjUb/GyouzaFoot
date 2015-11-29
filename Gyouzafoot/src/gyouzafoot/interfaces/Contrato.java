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
public interface Contrato {
    /*Getters
    Métodos gerais para o acesso aos objetos
    */
    public int getIdJogador();
    public java.time.LocalDate getEntrada();
    public java.time.LocalDate getSaida();
    public int getCamiseta();
    public String getPosicao();

    public int getId();   
}

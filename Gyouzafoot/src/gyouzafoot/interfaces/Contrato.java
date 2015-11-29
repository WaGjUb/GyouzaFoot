/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;
import java.time.LocalDate;
import gyouzafoot.Objetos.Jogador;

/**
 *
 * @author hydrocat
 */
public interface Contrato {
    /*Getters
    Métodos gerais para o acesso aos objetos
    */
    public int getIdJogador();
    public LocalDate getEntrada();
    public LocalDate getSaida();
    public int getCamiseta();
    public String getPosicao();
    public int getId(); 

    /*Setters
    Não são publicos porque os cadastros devem ser imutaveis para manter a coesão com o banco.
    Então, cria-se um novo cadastro para cada atualização( se nescessária ) do jogador
    */
    public int setEntrada( LocalDate data );
    public int setSaida( LocalDate data );
    public int setCamiseta( int numero );
    public int setPosicao( String Posicao ); 
    public int setJogador( Jogador j );
    
    //id é incrementado automaticamente no banco
    //public int setId();
}

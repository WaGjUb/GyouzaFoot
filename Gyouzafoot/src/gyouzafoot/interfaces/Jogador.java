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
public interface Jogador {
    public String getNome();
    public int getIdade(); 
    public int getId();
    
    public void setId( int id );
    public void setNome( String nome );
    public void setIdade( int Idade ); 
    
}

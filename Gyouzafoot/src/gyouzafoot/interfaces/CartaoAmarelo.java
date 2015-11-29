/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;
import gyouzafoot.Objetos.Participacao;

/**
 *
 * @author hydrocat
 */
public interface CartaoAmarelo {
    /*Getters*/
    public int getIdParticipacao();
    public int getId();
    
    /*Setters*/
    public int setParticipacao( Participacao p );
    //id é incrementado automaticamente no banco
    //public int setId();
}

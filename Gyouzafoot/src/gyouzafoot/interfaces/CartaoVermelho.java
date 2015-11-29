/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyouzafoot.interfaces;
import gyouzafoot.Objetos.Participacao;
import gyouzafoot.Objetos.Suspensao;

/**
 *
 * @author hydrocat
 */
public interface CartaoVermelho {
    
    //Getters
    public int getIdParticipacao();
    public int getIdSuspensao();
    public int getId();
    
    //Setters
    public int setParticipacao( Participacao p );
    public int setSuspensao( Suspensao s );
    //id é incrementado automaticamente no banco
    //public int setId();
}

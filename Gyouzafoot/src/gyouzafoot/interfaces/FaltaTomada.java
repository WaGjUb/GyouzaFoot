
package gyouzafoot.interfaces;
import gyouzafoot.Objetos.Participacao;

/**
 *
 * @author hydrocat
 */
public interface FaltaTomada {
    public int getId();
    public int getIdParticipacao();
    
    //id é incrementado automaticamente no banco
    //public int setId();
    public int setParticipacao( Participacao p );
    
}

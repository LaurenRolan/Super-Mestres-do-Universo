/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaixa;

/**
 *
 * @author lsrsampaio
 */
public class Ordem extends ObjetoMusical {
    
    private int instrumento;
    private int volume;
       
    public Ordem() {
        instrumento = 0;
    }
    
    public String toString()
    {
        return String.format(getStringInstrumento());
    }
    
    public String getStringInstrumento() {
        return String.format("I%d", instrumento);
    }
    
    
    
    public void setaInstrumento(int novoInstrumento) {
        instrumento=novoInstrumento;
    }
    
    private final int NUMERO_INSTRUMENTOS=128;
    public void somaInstrumento(int deslocamento){
        instrumento+=deslocamento;
        if(instrumento>NUMERO_INSTRUMENTOS-1)  
            instrumento-=NUMERO_INSTRUMENTOS;
    }
    
    
}

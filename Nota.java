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
public class Nota extends ObjetoMusical {
    private char nota;
    private int oitava;
    private int volume;
    private final int oitavaDefault = 3;
    private final int volumeDefautl = 12;
    
    public Nota()
    {
        nota = 'C'; //começa em dó
        oitava = oitavaDefault;
        volume = volumeDefault;
    }
    private String getVolume() {
        return String.format("a%d", volume);
    }
    private final int VOLUME_MAXIMO=120; //a definir
    protected void aumentaVolume()
    {
       if(volume<VOLUME_MAXIMO)
            volume+=VOLUME_MAXIMO*0.1;
    }
    
    protected void dobraVolume()
    {
        volume *= 2;
        if(volume>VOLUME_MAXIMO)
            volume=VOLUME_MAXIMO;   //vamos saturar o volume?
    }
    @Override
    public String toString(){
        return String.format(" %s %c%d%s ", getInstrumento(), getNota(), getOitava(), getVolume());
    }
    
    protected void setInstrumento(int instrumento) {
        this.instrumento = instrumento;
    }
    
    private String getInstrumento() {
        return String.format("I%d", this.instrumento);
    }
    
    protected void somaInstrumento(int adicionado) {
        if(instrumento + adicionado <= 128)
            instrumento += adicionado;
    }

    private char getNota() {
        return nota;
    }

    private int getOitava() {
        return oitava;
    }
    
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    private final char PAUSA='R';
    protected void setNota(char nota) {
        if((nota>=PRIMEIRA_NOTA && nota<=ULTIMA_NOTA)||nota==PAUSA)
            this.nota = nota;
    }

    protected void aumentaOitava() {
        if (oitava < 8)
        {
            oitava = oitava + 1;
        }else{
            oitava=oitavaDefault;
        }
    }
}

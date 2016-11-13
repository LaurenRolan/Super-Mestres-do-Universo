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
    private int volume=12;
    private final int oitavaDefault = 3;
    
    public Nota()
    {
        nota = 'C'; //começa em dó
        oitava = oitavaDefault;
    }
    private String getVolume() {
        return String.format("a%d", volume);
    }
    private final int VOLUME_MAXIMO=120; //a definir
    public void aumentaVolume()
    {
       if(volume<VOLUME_MAXIMO)
            volume+=VOLUME_MAXIMO*0.1;
    }
    
    public void dobraVolume()
    {
        volume *= 2;
        if(volume>VOLUME_MAXIMO)
            volume=VOLUME_MAXIMO;   //vamos saturar o volume?
    }
    @Override
    public String toString(){
        return String.format(" %c%d%s ", getNota(), getOitava(), getVolume());
    }


    public char getNota() {
        return nota;
    }

    public int getOitava() {
        return oitava;
    }
    
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    private final char PAUSA='R';
    public void setNota(char nota) {
        if((nota>=PRIMEIRA_NOTA && nota<=ULTIMA_NOTA)||nota==PAUSA)
            this.nota = nota;
    }

    public void aumentaOitava() {
        if (oitava < 8)
        {
            oitava = oitava + 1;
        }else{
            oitava=oitavaDefault;
        }
    }
}


package som;

public class Nota {
    private char nota;
    private int oitava;
    private int volume;
    private int instrumento;
    private final int oitavaDefault = 3;
    private final int volumeDefault = 12;
    private final int instrumentoDefault = 0;
    
    public Nota()
    {
        nota = 'C'; //começa em dó
        oitava = oitavaDefault;
        volume = volumeDefault;
        instrumento=instrumentoDefault;
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

    public String toString(){
        return String.format(" %s %c%d%s ", getInstrumento(), getNota(), getOitava(), getVolume());
    }
    
    public void setaInstrumento(int instrumento) {
        this.instrumento = instrumento;
    }
    
    private String getInstrumento() {
        return String.format("I%d", this.instrumento);
    }
    
    public void somaInstrumento(int adicionado) {
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

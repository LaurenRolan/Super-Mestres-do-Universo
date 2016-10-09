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
    int BPM;
    String instrumento;
    private int volume;
       
    public Ordem() {
        this.BPM = 95;
        this.instrumento = "Piano";
        this.volume = 10;
    }
    
    public String toString()
    {
        return String.format(this.getBPM() + " " + this.getInstrumento() + " " + this.getVolume() + " ");
    }

    public String getBPM() {
        switch (this.BPM)
        {
            case 45 : return "T[LARGO]";
            case 95 : return "T[MODERATO]";
            case 145: return "T[VIVACE]";
            default : return "T[MODERATO]";
        }
    }
    
    public String getInstrumento() {
        return String.format("I[%s]", this.instrumento);
    }
    
    public String getVolume() {
        return String.format("X[Volume]=%d", this.volume);
    }
    
    public void trocaInstrumento() { // só um exemplo
        if(this.instrumento == "Piano")
        {
            this.instrumento = "Guitar";
        }
         
        else if(this.instrumento == "Guitar")
        {
            this.instrumento = "Piano";
        }
    }
    
    public void aumentaVolume()
    {
        this.volume = this.volume * 2;
    }
    
    public void diminuiVolume()
    {
        this.volume = this.volume / 2;
    }
    
    public void aumentaBPM()
    {
        if (this.BPM < 145)
        {
            this.BPM = this.BPM + 50;
        }
    }
    
    public void diminuiBPM()
    {
        if (this.BPM > 45)
        {
            this.BPM = this.BPM - 50;
        }   
    }
}

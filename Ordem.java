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

    public Ordem(int BPM, String instrumento, int volume) {
        this.BPM = BPM;
        this.instrumento = instrumento;
        this.volume = volume;
    }
       
    public Ordem() {
        this.BPM = 140;
        this.instrumento = "Piano";
        this.volume = 10;
    }

    public int getBPM() {
        return BPM;
    }
    
    public String getInstrumento() {
        return instrumento;
    }
    
     public void trocaInstrumento() { // só um exemplo
        if(this.instrumento == "Piano")
        {
            this.instrumento = "Guitar";
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
        if (this.BPM < 240)
        {
            this.BPM = this.BPM + 50;
        }
    }
    
    public void diminuiBPM()
    {
        if (this.BPM > 40)
        {
            this.BPM = this.BPM - 50;
        }   
    }
}

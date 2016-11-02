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
    private static int oitavaDefault = 3;
    
    public Nota()
    {
        this.nota = 'C'; //começa em dó
        this.oitava = this.oitavaDefault;
    }
    
    public String toString(){
        return String.format(" %c%d ", this.getNota(), this.getOitava());
    }


    public char getNota() {
        return nota;
    }

    public int getOitava() {
        return oitava;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }

    public void aumentaOitava() {
        if (oitava < 8)
        {
            this.oitava = this.oitava + 1;
        }
    }
    
    public void diminuiOitava() {
        if (oitava > 1)
        {
            this.oitava = this.oitava - 1;
        }
    }
    
    public void voltaOitava() {
        this.oitava = this.oitavaDefault;
    }
    
}

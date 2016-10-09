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
    char nota;
    int oitava;
    static int oitavaDefault = 3;
    
    public Nota()
    {
        this.nota = 'C'; //começa em dó
        this.oitava = this.oitavaDefault;
    }
    
    public String toString() {
        return String.format(" %c%d ", this.nota, this.oitava);
    }


    public char getNota() {
        return nota;
    }

    public int getOitava() {
        return oitava;
    }
    
    public String notaOitava() {
        return String.format("%c%d", this.nota, this.oitava);
    }

    public void setNota(char nota) {
        this.nota = nota;
    }

    public void aumentaOitava() {
        this.oitava = this.oitava + 1;
    }
    
    public void diminuiOitava() {
        this.oitava = this.oitava - 1;
    }
    
    public void voltaOitava() {
        this.oitava = this.oitavaDefault;
    }
    
}

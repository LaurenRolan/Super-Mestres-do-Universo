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
    private final int oitavaDefault = 3;
    
    public Nota()
    {
        nota = 'C'; //começa em dó
        oitava = oitavaDefault;
    }
    
    @Override
    public String toString(){
        return String.format(" %c%d ", getNota(), getOitava());
    }


    public char getNota() {
        return nota;
    }

    public int getOitava() {
        return oitava;
    }
    
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    public void setNota(char nota) {
        if(nota>=PRIMEIRA_NOTA && nota<=ULTIMA_NOTA)
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

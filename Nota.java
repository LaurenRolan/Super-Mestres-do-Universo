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

    public char getNota() {
        return nota;
    }

    public int getOitava() {
        return oitava;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }

    public void setOitava(int oitava) {
        this.oitava = oitava;
    }
    
}

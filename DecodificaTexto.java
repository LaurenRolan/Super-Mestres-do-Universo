/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaixa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Laure
 */
public class DecodificaTexto {
 //String nomeArquivo;
    private FileReader texto;
    
    //Essenciais
    private char letra;
    private Nota ultimaNota;
    private ObjetoMusical ultimoObjeto;
    private String som;

    public DecodificaTexto(String nomeArquivo) {
        ultimaNota=new Nota();
        ultimoObjeto = new ObjetoMusical();
        
        try {
            this.texto = new FileReader(nomeArquivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
    }
    
    public String retornaMusica()
    {
        return som;
    }
    
    public void leCaracter() {
        //texto.
        int caracter;
        try {
            while ((caracter = this.texto.read()) != -1) {
                this.letra = Character.toUpperCase((char) caracter); // converte para maiúscula (usada no JFugue)
                this.decodifica(letra);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo de texto!");
        } finally {
            if (this.texto != null) {
                try {
                    this.texto.close();
                } catch (IOException ex) {
                    System.out.println("Erro ao fechar arquivo de texto!");
                }
            }
        }
    }
    
    private void addObjeto(ObjetoMusical adicionado)
    {
        som = som + adicionado.toString();
        if (adicionado instanceof Nota)
        {
            ultimaNota = (Nota) adicionado;
        }
        ultimoObjeto = adicionado;
    }

    public String getMusica() {
        return som;
    }
    
    private void decodifica(char letra) {
        //Inicializa tanto a nota quanto a ordem. Adiciona dependendo do case
        Nota nota = ultimaNota;
        Ordem ordem = new Ordem();
        
        switch (letra)
        {
            //Caso seja uma nota ou silêncio
            case 'A':
               nota.setNota(letra);
               this.addObjeto(nota);
                break;
            case 'B':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case 'C':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case 'D':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case 'E':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case 'F':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case 'G':
                nota.setNota(letra);
                this.addObjeto(nota);
                break;
            case ' ':
                nota.setNota('R');
                this.addObjeto(nota);
                break;
            
            //Caso seja uma ordem            
            case '!':
                ordem.aumentaVolume();
                this.addObjeto(ordem);
                break;
            case 'O':
            case 'U':
            case 'I':
                ordem.diminuiVolume();
                this.addObjeto(ordem);
                break;
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                nota.aumentaOitava();
                this.addObjeto(nota);
                break;
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                nota.diminuiOitava();
                this.addObjeto(nota);
                break;
            case '?':
            case '.':
                nota.voltaOitava();
                this.addObjeto(nota);
                break;
            case ';':
                ordem.aumentaBPM();
                this.addObjeto(ordem);
                break;
            case ',':
                ordem.diminuiBPM();
                this.addObjeto(ordem);
                break;
            case '\n':
                ordem.trocaInstrumento();
                this.addObjeto(ordem);
                break;
            case 'H':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                if (ultimoObjeto instanceof Nota)
                {
                    this.addObjeto(nota);
                }
                else
                {
                    nota.setNota('R');
                    this.addObjeto(nota);
                }
                break;
            default: break; //não faz nada
        }
    }
    
}

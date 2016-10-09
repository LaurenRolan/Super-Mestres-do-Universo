/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaixa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lsrsampaio
 */
public class DecodificaTexto {
    //String nomeArquivo;
    FileReader texto;
    
    //Essenciais
    char letra;
    ArrayList<ObjetoMusical> musica;

    public DecodificaTexto(String nomeArquivo) {
        //this.nomeArquivo = nomeArquivo;
        try {
            this.texto = new FileReader(nomeArquivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
        this.musica = new ArrayList<ObjetoMusical>();
    }
    
    private void leCaracter(FileReader texto, char letra) {
        //texto.
        int inteiro;
        try {
            while ((inteiro = this.texto.read()) != -1) {
                this.letra = Character.toLowerCase((char) inteiro); // converte para minúscula
                System.out.println(letra);
            }
        } finally {
            if (this.texto != null) {
                this.texto.close();
            }
        }
    }
    
    private void addObjeto(ObjetoMusical adicionado, ArrayList<ObjetoMusical> musica)
    {
        musica.add(adicionado);
    }

    public ArrayList<ObjetoMusical> getMusica() {
        return musica;
    }
    
    private void decodifica(char letra, ArrayList<ObjetoMusical> musica) {
        //Inicializa tanto a nota quanto a ordem. Adiciona dependendo do case
        Nota nota = new Nota();
        Ordem ordem = new Ordem();
        nota.setNota(letra);
        
        switch (letra)
        {
            //Caso seja uma nota ou silêncio
            case 'a':
                this.addObjeto(nota, musica);
                break;
            case 'b':
                this.addObjeto(nota, musica);
                break;
            case 'c':
                this.addObjeto(nota, musica);
                break;
            case 'd':
                this.addObjeto(nota, musica);
                break;
            case 'e':
                this.addObjeto(nota, musica);
                break;
            case 'f':
                this.addObjeto(nota, musica);
                break;
            case 'g':
                this.addObjeto(nota, musica);
                break;
            case ' ':
                this.addObjeto(nota, musica);
                break;
            
            //Caso seja uma ordem            
            case '!':
                ordem.aumentaVolume();
                this.addObjeto(ordem, musica);
                break;
            case 'o':
            case 'u':
            case 'i':
                ordem.diminuiVolume();
                this.addObjeto(ordem, musica);
                break;
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                nota.aumentaOitava(); // deve armazenar a nota anterior
                this.addObjeto(nota, musica);
                break;
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                nota.diminuiOitava(); // deve armazenar a nota anterior
                this.addObjeto(nota, musica);
                break;
            case '?':
            case '.':
                nota.voltaOitava(); // deve armazenar a nota anterior
                this.addObjeto(nota, musica);
                break;
            case ';':
                ordem.aumentaBPM();
                this.addObjeto(ordem, musica);
                break;
            case ',':
                ordem.diminuiBPM();
                this.addObjeto(ordem, musica);
                break;
            case '\n':
                ordem.trocaInstrumento();
                this.addObjeto(ordem, musica);
                break;
            default: break; //não faz nada
        }
    }
    
}

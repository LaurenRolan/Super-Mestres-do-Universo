/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaixa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author lsrsampaio
 */
public class DecodificaTexto2 {
    //String nomeArquivo;
    FileReader texto;
    
    //Essenciais
    char letra;
    ArrayList<ObjetoMusical> musica;
    private Nota ultimaNota;

    public DecodificaTexto2(String nomeArquivo) {
        //this.nomeArquivo = nomeArquivo;
        ultimaNota=new Nota();
        try {
            this.texto = new FileReader(nomeArquivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
        this.musica = new ArrayList<ObjetoMusical>();
    }
    
    public String montaMusica()
    {
        String som = new String();
        for(ObjetoMusical objeto : this.musica)
        {
            som = som + objeto.toString();
        }
        return som;
    }
    
    private void leCaracter() {
        //texto.
        int inteiro;
        try {
            while ((inteiro = this.texto.read()) != -1) {
                this.letra = Character.toUpperCase((char) inteiro); // converte para maiúscula (usada no JFugue)
                this.decodifica(letra, musica);
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
    
    private void addObjeto(ObjetoMusical adicionado, ArrayList<ObjetoMusical> musica)
    {
        musica.add(adicionado);
        if(adicionado instanceof Nota)  //se for nota, salva como ultimaNota
            ultimaNota=(Nota)adicionado;
    }

    public ArrayList<ObjetoMusical> getMusica() {
        return musica;
    }
    
    private void decodifica(char letra, ArrayList<ObjetoMusical> musica) {
        //Inicializa tanto a nota quanto a ordem. Adiciona dependendo do case
        Nota nota = ultimaNota;
        Ordem ordem = new Ordem();
        
        switch (letra)
        {
            //Caso seja uma nota ou silêncio
            case 'A':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'B':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'C':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'D':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'E':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'F':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case 'G':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            case ' ':
                nota.setNota(letra);
                this.addObjeto(nota, musica);
                break;
            
            //Caso seja uma ordem            
            case '!':
                ordem.aumentaVolume();
                this.addObjeto(ordem, musica);
                break;
            case 'O':
            case 'U':
            case 'I':
                ordem.diminuiVolume();
                this.addObjeto(ordem, musica);
                break;
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                nota.aumentaOitava();
                this.addObjeto(nota, musica);
                break;
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                nota.diminuiOitava();
                this.addObjeto(nota, musica);
                break;
            case '?':
            case '.':
                nota.voltaOitava(); 
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

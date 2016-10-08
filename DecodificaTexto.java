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

    public ArrayList<ObjetoMusical> getMusica() {
        return musica;
    }
    
    private void decodifica(char letra, ArrayList<ObjetoMusical> musica) {
        
    }
    
}

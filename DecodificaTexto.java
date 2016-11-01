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

    
    private final String NAO_ACHADO="Arquivo não encontrado!";
    public DecodificaTexto(String nomeArquivo) {
        ultimaNota=new Nota();
        //ultimoObjeto = new ObjetoMusical();
        try {
            this.texto = new FileReader(nomeArquivo);
        } catch (FileNotFoundException ex) {
            System.out.println(NAO_ACHADO);
        }
    }
    
    public String retornaMusica()
    {
        return som;
    }
    private final int FIM_DE_LEITURA=-1;
    private final String ERRO_LEITURA="Erro ao ler arquivo de texto!";
    private final String ERRO_FECHAMENTO="Erro ao fechar arquivo de texto!";
    public void leCaracter() {
        //texto.
        int caracter;
        try {
            while ((caracter = this.texto.read()) != FIM_DE_LEITURA) {
                this.letra = Character.toUpperCase((char) caracter); // converte para maiúscula (usada no JFugue)
                this.decodifica(letra);
            }
        } catch (IOException ex) {
            System.out.println(ERRO_LEITURA);
        } finally {
            if (this.texto != null) {
                try {
                    this.texto.close();
                } catch (IOException ex) {
                    System.out.println(ERRO_FECHAMENTO);
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
    }/*
    private final char PAUSA=' ';
    private void decodifica(char letra){
        Nota nota = ultimaNota;
        Ordem ordem = new Ordem();
         if(letra==PAUSA){
             nota.setNota('R');
             this.addObjeto(nota);
         }else if(ehNota(letra)){
             nota.setNota(letra);
             this.addObjeto(nota);
         }else if(ehNumero(letra)){
             if(ehPar(letra)){
                 nota.aumentaOitava();
             }else{
                 nota.diminuiOitava();
             }
             this.addObjeto(nota);
         }else if(ehVoltaOitava(letra)){
             nota.voltaOitava();
             this.addObjeto(nota);
         }
        
    }*/
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    public boolean ehNota(char letra){
        return letra>=PRIMEIRA_NOTA && letra<=ULTIMA_NOTA;
    }
    private final char PRIMEIR0_NUMERO='0';
    private final char ULTIMO_NUMERO='9';
    public boolean ehNumero(char letra){
        return letra>=PRIMEIR0_NUMERO && letra<=ULTIMO_NUMERO;
    }
    public boolean ehPar(char letra){
        switch(letra){
            case '0':
            case '2':
            case '4':
            case '6':
            case '8': return true;
            default: return false;
        }
    }
    public boolean ehVoltaOitava(char letra){
        return letra=='.'||letra=='?';
    }
    
}

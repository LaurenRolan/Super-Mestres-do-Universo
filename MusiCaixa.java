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
public class MusiCaixa {
    public static void main(String[] args) {
      DecodificaTexto teste;
        teste = new DecodificaTexto("C:\\Users\\Laure\\OneDrive\\Documentos\\TCP\\MusiCaixa\\src\\musicaixa\\letras.txt");
        try {
            teste.leCaracter();
        } catch (IOException ex) {
            System.out.println("Erro bizarro");
        }
        Player player = new Player();
        player.play(teste.montaMusica());
    }
    }
    
}

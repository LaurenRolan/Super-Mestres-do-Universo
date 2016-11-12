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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;

import java.util.Scanner;
/**
 *
 * @author Laure
 */
public class MusiCaixa {

    public static void main(String[] args) throws IOException, InvalidMidiDataException, MidiUnavailableException {
        ManagedPlayer toca = new ManagedPlayer();
        Player tocando = new Player();
        DecodificaTexto teste;
        teste = new DecodificaTexto("C:\\Users\\Laure\\OneDrive\\Documentos\\TCP\\MusiCaixa\\src\\musicaixa\\letras.txt");
        
        teste.leCaracter();
        System.out.println(teste.retornaMusica());
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        while (quit == false) {
            System.out.print("Enter a '+' to start, "+"'p' to pause, 'r' to resume or 'q' to quit: ");
            String entry = scanner.next();
            if (entry.startsWith("+")) {
               toca.start(tocando.getSequence(teste.retornaMusica())); //precisa de uma sequencia
            }
            else if (entry.equalsIgnoreCase("r")) {
                if (toca.isPaused()){
                    toca.resume();
                }
            }
            else if (entry.equalsIgnoreCase("p")) {
                if (toca.isPlaying()){
                    toca.pause();
                }
            }
            else if (entry.equalsIgnoreCase("q")) {
                if (toca.isPlaying()){
                    toca.finish();
                }
                quit = true;
            }
        }
    
    }
}

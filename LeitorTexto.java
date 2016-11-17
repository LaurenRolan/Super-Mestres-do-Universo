package som;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LeitorTexto{
  private BufferedReader leitor_arquivo;
  private String texto_lido; 
  private final String NAO_ACHADO="Arquivo não encontrado!";
  private final String ERRO_LEITURA="Erro ao ler arquivo de texto!";
  private final String ERRO_FECHAR="Erro ao fechar arquivo!"; 
  public String lerArquivo(File arquivo){
      String texto_buffer;
      texto_lido="";
      try {
          leitor_arquivo = new BufferedReader(new FileReader(arquivo));
          while((texto_buffer=leitor_arquivo.readLine())!=null){
              texto_lido+=texto_buffer;
          }
      } catch (FileNotFoundException ex) {
            System.out.println(NAO_ACHADO);
      } catch (IOException ex) {
          System.out.println(ERRO_LEITURA);
      }
      try {
          leitor_arquivo.close();
      } catch (IOException ex) {
          System.out.println(ERRO_FECHAR);
      }
      return texto_lido;
  }
  //Passar o código leitor de texto pra cá
}

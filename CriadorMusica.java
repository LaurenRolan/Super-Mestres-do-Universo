package musicaixa;

public class CriadorMusica{
    private Nota ultimaNota=new Nota();
    private ObjetoMusical ultimoObjeto;
    private String som;
    
    public void montaMusica(String texto){
       char caracteres[]=new char[texto.toCharArray().length];
       caracteres=texto.toCharArray();
       som="";
       for(char letra : caracteres){
           addObjeto(defineClasse(letra));
       }
    }
    
    public void comecaMusica(String endereco)
    {
        LeitorTexto leitor = new LeitorTexto();
        montaMusica(leitor.lerArquivo(endereco));
    }
    
    public String getSom(){
        return som;
    }
    
    private void addObjeto(Nota adicionado)
    {
        som = som + adicionado.toString();
    }
    //passar pra cá defineClasse e retornaMusica
    private final char LETRA_HARPSICHORD='!';
    private final int NUM_HARPSICHORD=7;
    private final char LETRA_TUBULAR_BELLS='\n';
    private final int NUM_TUBULAR_BELLS=15;
    private final char LETRA_PAN_FLUTE=';';
    private final int NUM_PAN_FLUTE=76;
    private final char LETRA_CHURCH_ORGAN=',';
    private final int NUM_CHURCH_ORGAN=20;
    private final char DOBRA_VOLUME = ' ';
    private boolean ultimoFoiNota=false;
    private Nota defineClasse(char letra){
        Ordem ordem = new Ordem();
        if(ehNota(letra)){
             ultimaNota.setNota(letra);
             ultimoFoiNota=true;
             return ultimaNota;
         }
        if(ehTrocaInstrumento(letra)){
             ordem.somaInstrumento(letra-'0');
             ultimoFoiNota=false;
             return ordem;
         }
        if(letra == DOBRA_VOLUME){
             ultimaNota.dobraVolume();
             ultimoFoiNota=false;
             return ultimaNota;
         }
        if(letra==LETRA_HARPSICHORD){
             ordem.setaInstrumento(NUM_HARPSICHORD);
             ultimoFoiNota=false;
             return ordem;
         }
        if(letra==LETRA_TUBULAR_BELLS){
             ordem.setaInstrumento(NUM_TUBULAR_BELLS);
             ultimoFoiNota=false;
             return ordem;
         }
        if(letra==LETRA_PAN_FLUTE){
             ordem.setaInstrumento(NUM_PAN_FLUTE);
             ultimoFoiNota=false;
             return ordem;
         }
        if(letra==LETRA_CHURCH_ORGAN){
             ordem.setaInstrumento(NUM_CHURCH_ORGAN);
             ultimoFoiNota=false;
             return ordem;
         }
        if(ehAumentaVolume(letra)){
             ultimaNota.aumentaVolume();
             ultimoFoiNota=false;
             return ultimaNota;
         }
        if(ehAumentaOitava(letra)){
             ultimaNota.aumentaOitava();
             ultimoFoiNota=false;
             return ultimaNota;
         }
        if(ultimoFoiNota)
            return ultimaNota;
        else{
            ultimaNota.setNota('R');
            ultimoFoiNota=false;
            return ultimaNota;
        }
    }
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    private boolean ehNota(char letra){
        return letra>=PRIMEIRA_NOTA && letra<=ULTIMA_NOTA;
    }
        
    private final char PRIMEIRO_NUMERO='0';
    private final char ULTIMO_NUMERO='9';
    private boolean ehNumero(char letra){
        return letra>=PRIMEIRO_NUMERO && letra<=ULTIMO_NUMERO;
    }
    
    private boolean ehTrocaInstrumento(char letra){
        return ehNumero(letra);
    }
    
    private char temporaria;
    private boolean ehVogal(char letra){
        temporaria = Character.toLowerCase(letra);
        return temporaria == 'o' || temporaria == 'i' || temporaria == 'u';
    }
    
    //Explaning Message! :D
    private boolean ehAumentaVolume(char letra){
        return ehVogal(letra);
    }
    
    private boolean ehAumentaOitava(char letra){
        return letra=='.'||letra=='?';
    }
     
}

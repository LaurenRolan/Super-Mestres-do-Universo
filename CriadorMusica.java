package musicaixa;

public class CriadorMusica{
    private Nota ultimaNota;
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
    
    public String getSom(){
        return som;
    }
    
    private void addObjeto(ObjetoMusical adicionado)
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
    private boolean ultimoFoiNota=false;
    private final char PAUSA=' ';
    private ObjetoMusical defineClasse(char letra){
        Ordem ordem = new Ordem();
         if(letra==PAUSA){
             ultimaNota.setNota('R');
             ultimoFoiNota=false;
             return ultimaNota;
         }else if(ehNota(letra)){
             ultimaNota.setNota(letra);
             ultimoFoiNota=true;
             return ultimaNota;
         }else if(ehNumero(letra)){
             ordem.somaInstrumento(letra-'0');
             ultimoFoiNota=false;
             return ordem;
         }else if(ehDobraVolume(letra)){
             ordem.dobraVolume();
             ultimoFoiNota=false;
             return ordem;
         }else if(letra==LETRA_HARPSICHORD){
             ordem.setaInstrumento(NUM_HARPSICHORD);
             ultimoFoiNota=false;
             return ordem;
         }else if(letra==LETRA_TUBULAR_BELLS){
             ordem.setaInstrumento(NUM_TUBULAR_BELLS);
             ultimoFoiNota=false;
             return ordem;
         }else if(letra==LETRA_PAN_FLUTE){
             ordem.setaInstrumento(NUM_PAN_FLUTE);
             ultimoFoiNota=false;
             return ordem;
         }else if(letra==LETRA_CHURCH_ORGAN){
             ordem.setaInstrumento(NUM_CHURCH_ORGAN);
             ultimoFoiNota=false;
             return ordem;
         }else if(ehAumentaVolume(letra)){
             ordem.aumentaVolume();
             ultimoFoiNota=false;
             return ordem;
         }else if(ehAumentaOitava(letra)){
             ultimaNota.aumentaOitava();
             ultimoFoiNota=false;
             return ultimaNota;
         }else{
             if(ultimoFoiNota)
                 return ultimaNota;
             else{
                 ultimaNota.setNota('R');
                 ultimoFoiNota=false;
                 return ultimaNota;
             }
         }
    }
    private final char PRIMEIRA_NOTA='A';
    private final char ULTIMA_NOTA='G';
    private boolean ehNota(char letra){
        return letra>=PRIMEIRA_NOTA && letra<=ULTIMA_NOTA;
    }
    
    private final char PRIMEIR0_NUMERO='0';
    private final char ULTIMO_NUMERO='9';
    private boolean ehNumero(char letra){
        return letra>=PRIMEIR0_NUMERO && letra<=ULTIMO_NUMERO;
    }
    
    private boolean ehDobraVolume(char letra){
        return letra==' ';
    }
    
    private boolean ehAumentaVolume(char letra){
        char letrinha=Character.toLowerCase(letra);
        return letrinha=='i'||letrinha=='o'||letrinha=='u';
    }
    
    private boolean ehAumentaOitava(char letra){
        return letra=='.'||letra=='?';
    }
     
}

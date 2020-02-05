import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enigma {

    public String cipher5 = "abcdefghijklmnopqrstuvwxyz";
    public String cipher6 = "bacedfhgikjlnmoqprtsuwvxzy";
    public String cipher7 = "zyxwvutsrqponmlkjihgfedcba";


    private String inicial; 
    private String cipherEven;
    private String cipherOdd;

    public List<String> c5;
    public List<String> c6;
    public List<String> c7;

    public String getInput(){

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        return input;
    }

    public String cipherSentence(String sentence){
        
        String ciphered = "";
        String cipheredLetter = "";
        
        sentence = sentence.replaceAll("\\s+","");

        for(int i=0;i<sentence.length();i++){
            if(i%2==0){
                cipheredLetter = String.valueOf(cipher7.charAt(cipher5.indexOf(String.valueOf(sentence.charAt(i)))));
            }else{
                cipheredLetter = String.valueOf(cipher6.charAt(cipher5.indexOf(String.valueOf(sentence.charAt(i)))));
            }
            ciphered += cipheredLetter;
        }

        return ciphered;
    }

    public String decipherSentence(String sentence){
        
        String deciphered = "";
        String decipheredLetter = "";

        sentence = sentence.replaceAll("\\s+","");

        for( int i=0;i<sentence.length();i++){
            if (i%2==0){
                decipheredLetter = String.valueOf(cipher5.charAt(cipher7.indexOf(String.valueOf(sentence.charAt(i)))));
            }else{
                decipheredLetter = String.valueOf(cipher5.charAt(cipher6.indexOf(String.valueOf(sentence.charAt(i)))));
            }
            
            deciphered += decipheredLetter;
        }

        return deciphered;
    }

    public Enigma(Integer key, String Cipher){

    }

    
    public static void main(String[] args){
        String mode = "";
        
            try{
                mode = args[0];
            }catch(Exception e){
                System.out.println("exception!");
                mode = "-c";
            }
        Integer key = 123;
        String cipher = "AAG";

        Enigma enigma = new Enigma(key, cipher);
        
        String userInput = null;

        while(userInput != ("q")){

            userInput = enigma.getInput();

            if(String.valueOf(mode.charAt(1))=="d"){
                
                System.out.println(enigma.decipherSentence(userInput));
            }else{
                System.out.println(enigma.cipherSentence(userInput));
            }
        }
        
        
    }
}
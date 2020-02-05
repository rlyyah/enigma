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
                cipheredLetter = String.valueOf(cipherEven.charAt(inicial.indexOf(String.valueOf(sentence.charAt(i)))));
            }else{
                cipheredLetter = String.valueOf(cipherOdd.charAt(inicial.indexOf(String.valueOf(sentence.charAt(i)))));
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
                decipheredLetter = String.valueOf(inicial.charAt(cipherEven.indexOf(String.valueOf(sentence.charAt(i)))));
            }else{
                decipheredLetter = String.valueOf(inicial.charAt(cipherOdd.indexOf(String.valueOf(sentence.charAt(i)))));
            }
            
            deciphered += decipheredLetter;
        }

        return deciphered;
    }

    public Enigma(Integer key, String cipher){
        switch(key){
            case 123:
            inicial = cipher5;
            cipherEven = cipher6;
            cipherOdd = cipher7;
            break;
            case 132:
            inicial = cipher5;
            cipherEven = cipher7;
            cipherOdd = cipher6;
            break;
            case 213:
            inicial = cipher6;
            cipherEven = cipher5;
            cipherOdd = cipher7;
            break;
            case 231:
            inicial = cipher6;
            cipherEven = cipher7;
            cipherOdd = cipher5;
            break;
            case 312:
            inicial = cipher7;
            cipherEven = cipher5;
            cipherOdd = cipher6;
            break;
            case 321:
            inicial = cipher7;
            cipherEven = cipher6;
            cipherOdd = cipher5;
            break;
            default:
            inicial = cipher5;
            cipherEven = cipher6;
            cipherOdd = cipher7;
        }
    String inicialHelp = "";

    for(int i = 0; i<inicial.length();i++){
        if(i<inicial.length()-inicial.indexOf(String.valueOf(cipher.charAt(0)))){
            inicialHelp += String.valueOf(inicial.charAt(i+inicial.indexOf(String.valueOf(cipher.charAt(0)))));
        }else{
            inicialHelp += String.valueOf(inicial.charAt(i-(inicial.length()-inicial.indexOf(String.valueOf(cipher.charAt(0))))));
        }
    }
    inicial = inicialHelp;

    String cipherEvenHelp = "";

    for(int i = 0; i<cipherEven.length();i++){
        if(i<cipherEven.length()-cipherEven.indexOf(String.valueOf(cipher.charAt(1)))){
            cipherEvenHelp += String.valueOf(cipherEven.charAt(i+cipherEven.indexOf(String.valueOf(cipher.charAt(1)))));
        }else{
            cipherEvenHelp += String.valueOf(cipherEven.charAt(i-(cipherEven.length()-cipherEven.indexOf(String.valueOf(cipher.charAt(1))))));
        }
    }
    cipherEven = cipherEvenHelp;

    String cipherOddHelp = "";
    for(int i = 0; i<cipherOdd.length();i++){
        if(i<cipherOdd.length()-cipherOdd.indexOf(String.valueOf(cipher.charAt(2)))){
            cipherOddHelp += String.valueOf(cipherOdd.charAt(i+cipherOdd.indexOf(String.valueOf(cipher.charAt(2)))));
        }else{
            cipherOddHelp += String.valueOf(cipherOdd.charAt(i-(cipherOdd.length()-cipherOdd.indexOf(String.valueOf(cipher.charAt(2))))));
        }
    }
    cipherOdd = cipherOddHelp;
    
    System.out.println(inicial);
    System.out.println(cipherEven);
    System.out.println(cipherOdd);
    
    }

    
    public static void main(String[] args){
        String mode = "";
        Integer key = 123;
        String cipher = "ddd";
        
            try{
                mode = args[0];
                key = Integer.parseInt(args[1]);
                cipher = args[2];
            }catch(Exception e){
                System.out.println("exception!");
                key = 123;
                mode = "-c";
                cipher = "abz";
            }
        

        Enigma enigma = new Enigma(key, cipher);
        
        String userInput = null;

        while(userInput != ("q")){

            userInput = enigma.getInput();

            if(String.valueOf(mode.charAt(1)).equals("d")){
                System.out.println("Deciphation completed:");
                System.out.println(enigma.decipherSentence(userInput));
            }else{
                System.out.println("Ciphation completed:");
                System.out.println(enigma.cipherSentence(userInput));
                System.out.println(enigma.decipherSentence(enigma.cipherSentence(userInput)));
            }
        }
        
        
    }
}
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Enigma {

    public String cipher5 = "abcdefghijklmnopqrstuvwxyz";
    public String cipher6 = "bacedfhgikjlnmoqprtsuwvxzy";
    public String cipher7 = "zyxwvutsrqponmlkjihgfedcba";
    public List<String> c5;
    public List<String> c6;
    public List<String> c7;

    public String getInput(){

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        return input;
    }



    public Enigma(){
        c5 = new ArrayList();
        c6 = new ArrayList();
        c7 = new ArrayList();
        for(int i=0; i<cipher5.length();i++){
            c5.add(String.valueOf(cipher5.charAt(i)));
            c6.add(String.valueOf(cipher6.charAt(i)));
            c7.add(String.valueOf(cipher7.charAt(i)));
        }



    }
    
    public static void main(String[] args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        Enigma enigma = new Enigma();
        for(String s: enigma.c5){
            System.out.println(s);
        }

    
        
    }
}
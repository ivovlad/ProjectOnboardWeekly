import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;

public class palindrome {
    public static String lexicographicPalindromes(String A,String B) {

        //this is default OUTPUT. You can change it.
        String[] a = mid(A);
        String[] b = mid(B);
        String centerA = a[0];
        String centerB = b[0];
        String halfA = a[1];
        String halfB = b[1];

        String halfX = halfA+halfB;
        ArrayList<String> combinations = generatePermutation(halfX,0,halfX.length());
        Collections.sort(combinations);
        String firstHalf = combinations.get(0);
        String secondHalf = "";
        for(int i = firstHalf.length()-1; i>=0; i--){
            secondHalf +=firstHalf.charAt(i);
        }


        return firstHalf+centerA+centerB+secondHalf;

        //write your Logic here
//        return String.join(",", combinations);

//        return centerA+"\n"+halfA+"\n"+centerB+"\n"+halfB;
    }

    public static String[] mid(String s){
        if(s.length()%2==0){
            return new String[]{"",s.substring(0,(int)(Math.floor(s.length()/2)))};
        }else{
            return new String[]{""+(s.charAt((int)(Math.floor(s.length()/2)))),s.substring(0,(int)(Math.floor(s.length()/2)))};
        }
    }
//function to swap the places of characters at positions i and j in string a
    public static String swapString(String a, int i, int j){
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    public static ArrayList<String> p = new ArrayList<String>();
    public static ArrayList<String> generatePermutation(String str, int start, int end){

        if (start==end-1){
            p.add(str);
        }else{
            for(int i = start;i<end;i++){
                str = swapString(str,start,i); //swapping the string by fixing a character
                generatePermutation(str,start+1,end); //recursively calling generatePermutation() for rest of characters
                str = swapString(str,start,i); // backtracking and swapping the characters again.
            }
        }
        return p;
    }

    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
//        Scanner sc = new Scanner(System.in);
        String A = "asdfdsa";
        String B = "qwwq";

        // OUTPUT [uncomment & modify if required]
        System.out.print(lexicographicPalindromes(A,B));
//        sc.close();
    }
}
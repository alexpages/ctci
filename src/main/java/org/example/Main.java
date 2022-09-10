package org.example;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


public class Main {
    public static void main(String[] args) {

    }
    public static boolean isUnique(String s){
        char[] sToArray = s.toCharArray();
        HashSet charSet=new HashSet();
        for (int i=0; i<sToArray.length; i++){
            if (charSet.contains(sToArray[i])){
                return false;
            }
            charSet.add(sToArray[i]);
        }
        return true;
    }

    public static boolean checkPermutation (String s, String s2){
        char[] content= s.toCharArray();
        char[] content2= s2.toCharArray();
        java.util.Arrays.sort(content);
        java.util.Arrays.sort(content2);
        String sSorted = new String(content);
        String s2Sorted = new String(content2);
        if (content.length!=content2.length){
            return false;
        }
        return sSorted.equals(s2Sorted);
    }

    public static String URLify (String s, int l){
        char[] sToArray = s.toCharArray();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<=l; i++){
            if (sToArray[i]==' '){
                sb.append(sToArray,counter,i-counter);
                if(i!=l){
                    sb.append("%20");
                    counter=i+1;
                }
            }
        }
        return sb.toString();
    }

    public static boolean  palindromePermutation(String s) {
        int count = 0;
        //HashMap<Character, Integer> hashMap = new HashMap<>();
        Hashtable<Character, Integer> hashTable = new Hashtable<>();
        for (int i = 0; i<s.length(); i++){
            hashTable.merge(s.toLowerCase().charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i<hashTable.size()-1;i++){
            if (hashTable.get(s.toLowerCase().charAt(i))%2!=0){
                count++;
            }
        }
        return count<=1;
    }
}



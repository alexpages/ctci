package org.example;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {

    }
    public static boolean isUnique(String s){
        //Hashtable/Hashmap for larger values of n
        //ArrayList for smaller values of n
        //HashSet for checking duplicates since it is a set of unique char
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

        return false;
    }
}



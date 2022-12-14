package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

//CHAPTER 1 - ARRAYS AND STRINGS
public class ArraysAndStrings {
    public static boolean isUnique(String s){
        //1.1
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
        //1.2
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
        //1.3
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

    public static boolean palindromePermutation(String s) {
        //1.4
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

    public static boolean oneWay (String s, String t){
        //1.5
        if (s.equals(t)) return true;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i<s.length(); i++){
            hashMap.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i<t.length(); i++){
            hashMap.merge(t.charAt(i), 1, Integer::sum);
        }
        for (char key : hashMap.keySet()) {
            if (hashMap.get(key) % 2 != 0) {
                count++;
            }
        }
        return count<=2;
    }

    public static String stringCompression (String s){
        //1.6
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i =0; i< s.length(); i++){
            if (i==0){
                sb.append(s.charAt(i));
                counter++;
            }
            if (counter==0 || i>=1 && s.charAt(i)==s.charAt(i-1)){
                counter++;
            }
            if (i>=1 && s.charAt(i)!=s.charAt(i-1)){
                sb.append(counter);
                counter=0;
                sb.append(s.charAt(i));
                counter++;
            }
            if (i== s.length()-1){
                sb.append(counter);
            }
        }
        return sb.toString().length()<s.length() ? sb.toString() : s;
    }

    public static boolean stringRotation(String s1, String s2){
        //1.9
        int len = s1.length();
        if (len==s2.length() && len>0) {
            String s1s1 = s1 + s1;
            if (s1s1.indexOf(s2) != -1) {
                return true;
            }
        }
        return false;
    }



}

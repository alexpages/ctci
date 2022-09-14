package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

    }
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

    public LinkedList removeDups(LinkedList ll){
        //2.1
        HashMap<Integer,Integer> hashMap = new HashMap<>(); //HashSet also can be used since it does not contain duplicates
        for (int i = 0; i<ll.size();i++){
            hashMap.merge((Integer) ll.get(i), 1, Integer::sum);
        }
        for (Integer key : hashMap.keySet()){
            if (hashMap.get(key)>=2){
                ll.removeLastOccurrence(key);
            }
        }
        return ll;
    }

    public int returnKfromLast (Node head, int k){
        //2.2
//        Node auxiliarNode = head;
//        int counter = 0;
//        while (auxiliarNode!=null){
//            auxiliarNode = auxiliarNode.next;
//            counter++;
//        }
//        if (counter>=k){
//            auxiliarNode=head;
//            for (int i = 0; i <counter-k;i++){
//                auxiliarNode=auxiliarNode.next;
//            }
//        }
//        return auxiliarNode.data;
        //Using 2 pointers pl will hit the end of the linked list after LENGTH - k steps. At that point, p2 will be LENGTH - k nodes
        // into the list, or k nodes from the end.
        Node p1 = head;
        Node p2 = head;
        //position p1 pointer k positions.
        for (int i = 0; i<k; i++){
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.data;
    }

    public boolean deleteMiddleNode (Node n){
        //2.3
        if (n == null || n.next ==null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public Integer deleteNode (Node head, int dataNode){
        //2.3.1
        Node n = head;
        int suma = 0;
        if (n.data==dataNode){
            head =head.next;
            while (head!=null){
                suma+=head.data;
                head=head.next;
            }
            return suma;
        }
        while (n.next!=null){
            if (n.next.data == dataNode){
                n.next = n.next.next;
            }
            n = n.next;
        }
        while (head!=null){
            suma+=head.data;
            head=head.next;
        }
        return suma;
    }
}




















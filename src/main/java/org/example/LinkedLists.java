package org.example;

import auxiliarClasses.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//CHAPTER 2 - LINKED LISTS
public class LinkedLists {
    public static LinkedList removeDups(LinkedList ll){
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

    public static int returnKfromLast(Node head, int k){
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

    public static boolean deleteMiddleNode(Node n){
        //2.3
        if (n == null || n.next ==null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static Integer deleteNode(Node head, int dataNode){
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

    public static String partition(Node head, int x){
        //2.4
        Node lessX = null;
        Node biggerX = null;

        while (head!=null){
            if (head.data<x){
                lessX= new Node(head.data, lessX);
            }
            else{
                biggerX = new Node(head.data,biggerX);
            }
            head=head.next;
        }
        head = lessX;
        while (lessX!=null){
            if (lessX.next == null){
                lessX.next=biggerX;
                break;
            }
            lessX = lessX.next;
        }
        StringBuilder sb = new StringBuilder();
        while (head!=null){
            sb.append(head.data);
            if (head.next!=null){
                sb.append("->");
            }
            head=head.next;
        }
        return sb.toString();
    }

    public static String sumListsBackwards (Node n1, Node n2){
        //2.5
        List<Integer> firstNumb = new ArrayList();
        List<Integer> secondNumb = new ArrayList();

        while (n1!=null) {
            firstNumb.add(n1.data);
            n1=n1.next;
        }
        while (n2!=null) {
            secondNumb.add(n2.data);
            n2=n2.next;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = firstNumb.size()-1; i>=0; i--) {
            sb.append(firstNumb.get(i));
        }
        int number1 =Integer.parseInt(sb.toString());
        //reuse sb
        sb.setLength(0);
        for (int i = secondNumb.size()-1; i>=0; i--) {
            sb.append(secondNumb.get(i));
        }
        int number2 =Integer.parseInt(sb.toString());

        number1+=number2; //912
        //reuse a previous list
        firstNumb.clear();
        while (number1>0) {
            firstNumb.add(number1%10);
            number1/=10;
        }
        Node head = null;
        for (int i = firstNumb.size()-1; i>=0; i-- ){
            head = new Node(firstNumb.get(i), head);
        }
        //reuse sb
        sb.setLength(0);
        while (head!=null){
            sb.append(head.data);
            if (head.next!=null){
                sb.append("->");
            }
            head=head.next;
        }
        return sb.toString();
    }

    public static boolean palindromeLinkedList(Node head){
        //2.6
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (head!=null){
            hashMap.merge(head.data, 1, Integer::sum);
            head=head.next;
        }

        int counter=0;
        for (Integer key : hashMap.keySet()){
            if (hashMap.get(key)==1){
                counter++;
            }
        }
        return counter>1 ? false : true;
    }

    public static Node intersection(Node n1, Node n2){
        //2.7
        //HasMap approach
        HashMap<Node, Integer> hashMap = new HashMap<>();
        while (n1!=null){
            hashMap.merge(n1,1,Integer::sum);
            n1=n1.next;
        }
        while (n2!=null){
            if (hashMap.containsKey(n2)){
                return n2;
            }
            n2=n2.next;
        }
        return null;
    }

    public static Node loopDetection(Node head){
        //2.8
        HashMap<Node, Integer> hashMap = new HashMap<>();

        while (head!=null){
            if (hashMap.containsKey(head)){
                return head;
            }
            hashMap.merge(head, 1, Integer::sum);
            head=head.next;
        }
        return null;
    }


}

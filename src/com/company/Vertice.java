package com.company;

import java.util.LinkedList;

public class Vertice {
    Vertice parent;
    int low;
    boolean active = true;
    int disc;
    int SCC;
    boolean inS = false;
    boolean hasExplored;
    String name;
    LinkedList<Vertice> adjVertice = new LinkedList<>() ;
    static void print(LinkedList<Vertice> linkedList){
        if (linkedList == null){
            System.out.println("NULL");

        }
        else {
            for (Vertice i : linkedList) {
                System.out.print(i.name + "  ");
            }
        }
        System.out.println();
    }


}

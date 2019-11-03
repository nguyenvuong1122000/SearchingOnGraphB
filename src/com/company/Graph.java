package com.company;

import java.io.File;
import java.util.*;
import static com.company.Vertice.*;

public class Graph {
    int SCC,time;
    LinkedList<Vertice> verticeList = new LinkedList<>();
    Map<String, Vertice> verticeMap = new HashMap<>();
    Queue<Vertice> verticeQueue = new LinkedList<>();
    Stack<Vertice> verticeStack = new Stack<>();
    //Contrustor
    Graph(File file) {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String v1 = sc.nextLine();
                verticeMap.put(v1, new Vertice());
                verticeMap.get(v1).name = v1;
                verticeList.add(verticeMap.get(v1));
                }
            for(Vertice vertice : verticeList) {
                for(Vertice i : verticeList){
                    if((checkEdge(vertice,i)) && (i != vertice) ){
                        addEgde(vertice,i);
                    }
                }
            }
            sc.close();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }


     boolean checkEdge(Vertice s1, Vertice s2) {    //ktra xem co canh s1->s2 ko
        int count = 0;
        char[] a1 =s1.name.toCharArray();
        char[] a2 =s2.name.toCharArray();
        for (int i = 1; i < 5; i++){
            for(int j = 0 ; j < 5 ; j++){
                if (a1[i] == a2[j]){
                    count++;
                    a2[j] = '2';
                    break;
        }
     }
        }
        if (count < 4){
            return false;
        }
        return true;
    }

    static int min(int a,int b){
        if(a > b)
            return b;
        else
            return a;
    }

    void addEgde(Vertice vertice1, Vertice vertice2) {
        vertice1.adjVertice.add(vertice2);
    }

    public void FindWay(String s1, String s2) {
        LinkedList<Vertice> result = new LinkedList<>();
        for (Vertice abc : verticeList) {
            abc.parent = null;
        }
        Vertice vertice1 = verticeMap.get(s1);
        Vertice vertice2 = verticeMap.get(s2);
        verticeQueue.add(vertice1);
        try {
            while (verticeQueue.size() != 0) {
                Vertice v3 = verticeQueue.poll();
                for (Vertice _adjVertice : v3.adjVertice) {
                    if ((_adjVertice.parent == null) && (_adjVertice != vertice1)) {
                        verticeQueue.add(_adjVertice);
                        _adjVertice.parent = v3;
                    }
                }
            }
            Vertice v1 = vertice2;
            while (v1 != vertice1) {
                result.add(v1);
                v1 = v1.parent;
            }
            result.add(vertice1);
            Collections.reverse(result);
            print(result);
        } catch (Exception e) {
            System.out.println("Check du lieu nhap vao");
        }
    }
    void findAllRoot(){
        SCC = 0;
        int time = 0;
        for(Vertice verticea : verticeList){
            verticea.hasExplored = false;
        }
        for(Vertice vertice : verticeList){
            if (vertice.hasExplored == false){
                markRoot(vertice);
            }
        }
    }
    void markRoot(Vertice vertice ){
        vertice.hasExplored = true;
        verticeStack.push(vertice);
        time = time +1;
        vertice.disc = time;
        vertice.low = vertice.disc;
        for(Vertice vertice1 : vertice.adjVertice){
           if(vertice1.hasExplored = false){
               markRoot(vertice1);
           }
           vertice.low = min(vertice1.low,vertice.low);
        }

        if (vertice.low == vertice.disc){
            SCC++;
            LinkedList<Vertice> list = new LinkedList<>();
            while (verticeStack.peek() !=vertice){
                verticeStack.pop().SCC = SCC;
            }
        }
    }
    boolean check(Vertice vertice1, Vertice vertice2){
        findAllRoot();
        if (vertice1.SCC == vertice2.SCC){
            return true;
        }
        return false;
    }
}





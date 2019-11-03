package com.company;

import java.io.File;
import java.util.Scanner;

import static com.company.Vertice.print;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/INPUT//sgb-words.txt");

        Graph graph = new Graph(file);
        System.out.println("So thanh phan lien thong manh la  " + graph.SCC);
       System.out.println("Nhap 2 tu de thuc hien tim duong ");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        graph.FindWay(a,b);

        System.out.println("Nhap 2 tu de kiem tra co cung nam trong mot \n thanh phan lien thong manh hay ko");
        String c =sc.nextLine();
        String d = sc.nextLine();
        sc.close();

        graph.findAllRoot();
        System.out.println(graph.check(graph.verticeMap.get(c),graph.verticeMap.get(d)));

    }
}

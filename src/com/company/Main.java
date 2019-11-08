package com.company;

import java.io.File;
import java.util.Scanner;

import static com.company.Vertice.print;

public class Main {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/INPUT//sgb-words.txt");

        Graph graph = new Graph(file);
        graph.findAllRoot();
        System.out.println(graph.SCC);

        System.out.println("So thanh phan lien thong manh la : " + graph.SCC);
        Scanner sc = new Scanner(System.in);


        System.out.println("Nhap mot tu");
        String c = sc.nextLine();
        System.out.println("Thanh phan lien thong voi no la ");
        graph.printSCC(graph.verticeMap.get(c));


        System.out.println("\nNhap 2 tu de thuc hien tim duong ");

        String a = sc.nextLine();
        String b = sc.nextLine();

        graph.FindWay(a,b);

    }
}
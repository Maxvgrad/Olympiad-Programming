////Реализация задачи №1 "A+B" на Java
//package org.olymp.task0001;
//
//import java.util.*;
//import java.io.*;
//
//public class Main{ //имя класса должно быть Main
//  PrintWriter pw;
//  Scanner sc;
//  public static void main(String[] argv) throws IOException{
//    new Main().run();
//  }
//  public void run() throws IOException{
//    sc = new Scanner(new File("input.txt"));
//    int n = sc.nextInt();
//    pw = new PrintWriter(new File("output.txt"));
//    pw.print(sum(n));
//    pw.close();
//  }
//  public long sum(int n) {
//    long result = 0;
//    for(int i = 1; i <= n; i++) {
//    	result += i;
//    }
//    return result;
//  }
//
//}

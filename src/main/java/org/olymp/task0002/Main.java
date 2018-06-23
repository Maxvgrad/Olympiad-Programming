//package org.olymp.task0002;
//
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    PrintWriter pw;
//    Scanner sc;
//    public static void main(String[] argv) throws IOException{
//        new Main().run();
//    }
//    public void run() throws IOException{
//        sc = new Scanner(new File("input.txt"));
//        int n = sc.nextInt();
//        pw = new PrintWriter(new File("output.txt"));
//        pw.print(solution(n));
//        pw.close();
//    }
//
//    public int solution(int n) {
//      	return n * 100 + 99 - n;
//    }
//}

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
//        pw = new PrintWriter(new File("output.txt"));
//        System.out.println(solution(sc));
//        pw.print(solution(sc));
//        pw.close();
//    }
//
//    public String solution(Scanner sc) {
//        int size = sc.nextInt();
//        StringBuilder evenBuilder = new StringBuilder();
//        StringBuilder oddBuilder = new StringBuilder();
//        int evenCounter = 0;
//        int oddCounter = 0;
//
//        for (int i = 0; i <= size && sc.hasNext(); i++) {
//            int day = sc.nextInt();
//            if (day % 2 == 0) {
//                evenBuilder.append(day).append(" ");
//                evenCounter++;
//            } else {
//                oddBuilder.append(day).append(" ");
//                oddCounter++;
//            }
//        }
//
//        oddBuilder.deleteCharAt(oddBuilder.length()-1).append(System.lineSeparator());
//        evenBuilder.deleteCharAt(evenBuilder.length()-1).append(System.lineSeparator());
//        return "" + oddBuilder + evenBuilder + (evenCounter >= oddCounter?"YES":"NO");
//    }
//}

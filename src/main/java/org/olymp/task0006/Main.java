//import java.util.*;
//import java.io.*;
//import static java.lang.Integer.*;
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
//        //pw.print(solution(sc));
//        pw.close();
//    }
//
//    public String solution(Scanner sc) {
//        String pattern = "^[A-H][1-8]-[A-H][1-8]$";
//        if (!sc.hasNext(pattern)) {
//            return "ERROR";
//        }
//        String step = sc.next(pattern);
//        System.out.println(step);
//        int d1 = Math.abs(step.charAt(0) - step.charAt(step.length() - 2));
//        int d2 = Math.abs(parseInt(step.substring(1,2)) - parseInt(step.substring(step.length() - 1)));
//        System.out.println(d1);
//        System.out.println(d2);
//        return (Math.pow(d1, 2) + Math.pow(d2, 2)) == 5 ? "YES" : "NO";
//    }
//}

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        GraphALTraversal  graphAL = new GraphALTraversal( "GraphAL" ) ;


        Scanner scanner = new Scanner(System.in);
        String filePath = "";
        Scanner graphFile = null;
/***
 *
 * .0...00...
 * .0F0......
 * ..0..0....
 * .0.0.....0
 * ..........
 * ..........
 * ....0.0.0.
 * .0.0......
 * 0........0
 * S.0.....00
 *
 */

//        while(true) {
            System.out.print("Enter file path of map: ");
//            filePath = scanner.nextLine().trim().replace("\"", "");
//            filePath = "C:\\Users\\INUKA PERERA\\Documents\\Files\\IIT\\Algorithms\\CW\\test.txt";
        filePath = "C:\\Users\\INUKA PERERA\\Documents\\Files\\IIT\\Algorithms\\CW\\examples\\maze10_1.txt";
//            filePath = "C:\\Users\\INUKA PERERA\\Documents\\Files\\IIT\\Algorithms\\CW\\benchmark_series" +
//                    "\\benchmark_series\\puzzle_2560.txt";
//        filePath = "C:\\Users\\INUKA PERERA\\Downloads\\examples\\maze10_1.txt";
        try {


                graphFile = new Scanner(new File(filePath));

//                break;
            } catch (Exception e) {
                System.out.println("Could not open Graph input file: " + filePath + ". Error: " + e);
                System.out.println("Please try again.");
//                continue;
            }
//        }

        long parserStartTime = System.currentTimeMillis();

        graphAL.createGraphFromFile(graphFile);

        long parserEndTime = System.currentTimeMillis();


        graphAL.BreadthFirstSearch(graphAL.startPosition, (parserEndTime - parserStartTime) );



    }

}
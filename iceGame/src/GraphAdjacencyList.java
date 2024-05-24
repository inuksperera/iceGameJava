import java.io.File;
import java.util.*;
import java.util.function.BiFunction;

public class GraphAdjacencyList {

    public String printLine = "";

    private String graphName;
    private int numberOfVertices = 0;

    public HashSet<String> boundaryList;
    public HashMap<String, HashSet<String>> bounceMovementList;

    /***
     * Hashmap
     * Number of steps: 98417
     * visitedVertex size: 118107
     * Time taken: 5880ms
     * BFS Time taken: 1307ms
     * Bounce size: 118105
     *
     * ArrayList
     * ***/
    private int columnCount = 0;
    private int rowCount = 0;

    public String startPosition = "";
    public String finishPosition = "";

    public GraphAdjacencyList(String graphName) {
        this.graphName = graphName;
    }


    /**
     * Graph interface methods
     **/

    public String graphName() {
        return graphName;
    }

    public int numberOfVertices() {
        return numberOfVertices;
    }




    public void createGraphFromFile(Scanner graphFile) {

        bounceMovementList = new HashMap<>();




        try {


            String string = "";
//            String currentLine = "";
            String prevLine = null;
            String nextLine = null;
            String currentLine = graphFile.nextLine().trim();

            boundaryList = new HashSet<>(currentLine.length() ^ 2);

//            testFile.nextLine();
            boolean eof = false;
//        String top = "";
//        String bottom = "";
//        String left = "";
//        String right = "";


//        String[] a = new String[10];


            // While there are numbers left, read two and use them to add an edge
            while (!eof) {

                if (!graphFile.hasNextLine()) {

                    eof = true;
                    nextLine = null;
                } else {
                    nextLine = graphFile.nextLine().trim();

                    if (nextLine.equals("")) {
                        eof = true;
                        nextLine = null;
                    }

                }


//                System.out.println("round        " + (columnCount + 1));
//                System.out.println("prevLine:    " + prevLine);
//                System.out.println("currentLine: " + currentLine);
//                System.out.println("nextLine:    " + nextLine);
//                System.out.println();


//                System.out.println("currentLine: " + currentLine);

                rowCount = 0;

                for (int i = 0; i < currentLine.length(); i++) {
//                if ((!"0".equals(String.valueOf(currentLine.charAt(rowCount)))) && (!"F".equals(String.valueOf(currentLine.charAt(rowCount))))) {
//                if ((!"0".equals(String.valueOf(currentLine.charAt(rowCount))))) {
////                    System.out.println("row: " + rowCount + ", col: " + columnCount + ", line length: " + currentLine.length());
//
////                    if (prevLine!=null && nextLine!=null && rowCount>0 && rowCount<currentLine.length()) {
////                        //if all surrounding nodes arent ".", then add
////                        if ( !( (".".equals(String.valueOf(prevLine.charAt(rowCount)))) &&
////                                (".".equals(String.valueOf(nextLine.charAt(rowCount)))) &&
////                                (".".equals(String.valueOf(currentLine.charAt(rowCount - 1)))) &&
////                                (".".equals(String.valueOf(currentLine.charAt(rowCount + 1)))) )
////                        ){
////                            boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
////                        }else {
//////                            boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
////                        }
////                    }else{
//                        boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
////                    }
//
//
//                }
                    //if row = 0 or row = length of currentLine then add those nodes too
                    if (rowCount == 0) {
                        boundaryList.add("(x" + (rowCount - 1) + ", " + "y" + columnCount + ")");
//                        System.out.println("(x" + (rowCount - 1) + ", " + "y" + columnCount + ")");

                    }
                    if (rowCount == currentLine.length()-1) {
                        boundaryList.add("(x" + (rowCount + 1) + ", " + "y" + columnCount + ")");
//                        System.out.println("(x" + (rowCount + 1) + ", " + "y" + columnCount + ")");
                    }
                    if (columnCount == 0) {
                        boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount - 1) + ")");
//                        System.out.println("(x" + rowCount + ", " + "y" + (columnCount - 1) + ")");

                    }
                    if (nextLine == null) {
                        boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount + 1) + ")");
//                        System.out.println("(x" + rowCount + ", " + "y" + (columnCount + 1) + ")");

                    }

                        if (!(".".equals(String.valueOf(currentLine.charAt(rowCount)))) && !("S".equals(String.valueOf(currentLine.charAt(rowCount)))) && !("F".equals(String.valueOf(currentLine.charAt(rowCount))))) {
//                    System.out.println("row: " + rowCount + ", col: " + columnCount + ", line length: " + currentLine.length());
//                    System.out.println(currentLine.charAt(rowCount));

//                            System.out.println(currentLine.charAt(rowCount));
                            boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
//                            System.out.println("(x" + rowCount + ", " + "y" + (columnCount) + ")");
                            /**
                             * top
                             * "(x" + rowCount + ", " + "y" + (columnCount-1)  + ")"
                             * bottom
                             *  "(x" + rowCount + ", " + "y" + (columnCount+1)  + ")";
                             *  left
                             *  "(x" + (rowCount - 1) + ", " + "y" + columnCount  + ")";
                             *  right
                             *   "(x" + (rowCount + 1) + ", " + "y" + columnCount  + ")";
                             * */
//                    if (prevLine!=null && nextLine!=null && rowCount>0 && rowCount<currentLine.length()) {
//                        //if all surrounding nodes arent ".", then add
//                        if ( !( (".".equals(String.valueOf(prevLine.charAt(rowCount)))) &&
//                                (".".equals(String.valueOf(nextLine.charAt(rowCount)))) &&
//                                (".".equals(String.valueOf(currentLine.charAt(rowCount - 1)))) &&
//                                (".".equals(String.valueOf(currentLine.charAt(rowCount + 1)))) )
//                        ){
//                            boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
//                        }else {
////                            boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
//                        }
//                    }else{
//                    boundaryList.add("(x" + rowCount + ", " + "y" + (columnCount) + ")");
//                    }


                        }

                    if (String.valueOf(currentLine.charAt(rowCount)).contains("S")) {
                        startPosition = "(x" + rowCount + ", " + "y" + columnCount + ")";
                    } else if (String.valueOf(currentLine.charAt(rowCount)).contains("F")) {
                        finishPosition = "(x" + rowCount + ", " + "y" + columnCount + ")";
                    }
//                    }

                    rowCount++;
                }

//            printLine = printLine + "\n" + currentLine;


                columnCount++;

                prevLine = currentLine;
                currentLine = nextLine;

            }

//            System.out.println(boundaryList);

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


            graphFile.close();

            long bounceStartTime = System.currentTimeMillis();
            bounceMovement();
            long bounceEndTime = System.currentTimeMillis();
//            System.out.println("Bounce time: " + (bounceEndTime - bounceStartTime));

        } catch (Exception e) {
            System.out.println("Error: There was a problem with the file." + e);

        }

//        return boundaryList;

//        System.out.println(boundaryList);
    }


    /**
     * CONSUMER FUNCTION
     * public void map(DoubleFunction<Double> fn) {
     * //do something
     * setData(10.0, Math::cos);
     * //do something
     * }
     * private double setData(double data,  DoubleFunction<Double> fn) {
     * data = fn.apply(data);
     * return data;
     * }
     */
    public void bounceMovement() {


        /**
         *
         *
         * //            String[] ar = key.split(", y");
         * //
         * //            int currentRow = Integer.valueOf((ar[0].substring(2)));
         * //            int currentColumn = Integer.valueOf(ar[1].replace(")", ""));
         *
         *
         * ////                setBounceValues(key, currentRow, currentColumn, (nextRow, nextColumn) -> {
         * ////                    return new Integer[]{nextRow + 1, nextColumn};
         * ////                });
         *
         *
         * */



//        printBounce();
    }

    public void setBounceValues(String key, int currentRow, int currentColumn,
                                BiFunction<Integer, Integer, Integer[]> action) {


//        System.out.println(ar[1].replace(")", ""));


        boolean boundaryNotFound = true;
//            String key = "(x3, y7)";

//        int currentRow = Integer.valueOf(String.valueOf( key.charAt(2)));
//        int currentColumn = Integer.valueOf(String.valueOf( key.charAt(6)));
        String currentNode = key;
//        currentNode = "(x" + currentRow + ", " + "y" + currentColumn  + ")";

        int nextRow = currentRow;
//             int nextColumn = currentColumn-1;
        int nextColumn = currentColumn;

        //assign first then minus function
//        System.out.println("Row: " + currentRow + ", Column: " + currentColumn);
        //trying to find the top most value till a boundary is hit.
        while (boundaryNotFound) {
//            nextColumn--;
            Integer[] newValuesArray = action.apply(nextRow, nextColumn);
            nextRow = newValuesArray[0];
            nextColumn = newValuesArray[1];

            currentNode = "(x" + currentRow + ", " + "y" + currentColumn + ")";
            String nextNode = "(x" + nextRow + ", " + "y" + nextColumn + ")";

//            System.out.println("nextRow: " + nextRow + ", nextColumn: " + nextColumn);


            //boundaryNotFound = isAdjacent(src = (x0, y0), dest= (x0, y-1))
            boundaryNotFound = !isAdjacent(currentNode, nextNode);
            if (currentNode.equals(finishPosition)) {
                boundaryNotFound = false;
            }
//                boundaryNotFound = isAdjacent("(x0, y1)", "(x" + nextRow + ", " + "y" + nextColumn  + ")");
//            System.out.println(boundaryNotFound);
            currentRow = nextRow;
            currentColumn = nextColumn;
        }

//        System.out.println("top: " + "(x" + currentRow + ", " + "y" + currentColumn  + ")");
//        System.out.println("top: " + currentNode);


        if (!key.equals(currentNode)) {
            bounceMovementList.get(key).add(currentNode);
        }


    }

    public void printBounce() {
//        bounceMovementList.get("(x" + 0 + ", " + "y" + 0  + ")").add("harro") ;
        for (int destVertex = 0; destVertex < columnCount; destVertex++) {
//            System.out.println( srcVertex + " --> " + adjacencyList.get( srcVertex + ", ") ) ;

            for (int srcVertex = 0; srcVertex < rowCount; srcVertex++) {
//                bounceMovementList.put( "(x" + srcVertex + ", " + "y" + destVertex  + ")", new HashSet<String>());

//                bounceMovementList.get("(x" + srcVertex + ", " + "y" + destVertex  + ")").add(String.valueOf(adjacencyList.get("(x" + srcVertex + ", " + "y" + destVertex  + ")"))) ;

//                System.out.println( srcVertex + " --> " + destVertex ) ;
                System.out.println("(x" + srcVertex + ", " + "y" + destVertex + ")" + " --> " + bounceMovementList.get(
                        "(x" + srcVertex + ", " + "y" + destVertex + ")"));
//                bounceMovementList.get("(x" + srcVertex + ", " + "y" + destVertex  + ")");


            }
//            System.out.println("BOUNCE: " + bounceMovementList.toString());
//            System.out.println();
        }
    }

    // used to check if 2 vertices are adjacent, i.e. neighbours
    public boolean isAdjacent(String sourceVertex, String destinationVertex) {
        // check if edge "(sV, dV)" exists in the graph by
        // checking if the adjacency list for sV "contains" dV.

        // **** TO-DO ****
        // replace "false" with correct code

        return boundaryList.contains(destinationVertex);
    }


    //    private String toStringEdge()

    public void printGraph() {
//        System.out.println("test: " + adjacencyList.get());
        System.out.println("Graph: " + graphName + "\n" + "Edges: ");

        for (int destVertex = 0; destVertex < columnCount; destVertex++)
//        for ( int srcVertex = 0; srcVertex < numberOfVertices; srcVertex++ )
        {
//            System.out.println( srcVertex + " --> " + adjacencyList.get( srcVertex + ", ") ) ;

            for (int srcVertex = 0; srcVertex < rowCount; srcVertex++) {
//                System.out.println( srcVertex + " --> " + destVertex ) ;
                System.out.println("(x" + srcVertex + ", " + "y" + destVertex + ")" + " --> " + boundaryList.contains(
                        "(x" + srcVertex + ", " + "y" + destVertex + ")"));

            }
            System.out.println();
        }

        System.out.println();
//        for ( int f=0; f<5; f++){
////            System.out.println("wonderhoy adjacencyList.get(\"(x0, y0)\")" + adjacencyList.get("(x0, y0)"));
//            System.out.println("WONDERHOY: " + adjacencyList.get(adjacencyList.get("(x0, y0)").get(f)));
//        }

        System.out.println("start: " + startPosition);
        System.out.println("finish: " + finishPosition);
    }

} // class GraphAdjancencyList
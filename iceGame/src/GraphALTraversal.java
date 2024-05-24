import java.util.*;


public class GraphALTraversal extends GraphAdjacencyList
{

    // DFS & BFS traversal

//    private ArrayList<String> visitedVertex ;
    private HashSet<String> visitedVertex;
    public HashMap< String, String > previousNodeList ;

    private List< Integer > DFSpath ;

    private List< String > BFSpath ;

    private long parserTime;
    private Queue<String> vertexQueue = new LinkedList<>();



    public GraphALTraversal( String graphName )
    {
        super( graphName ) ;
    }


    /** GraphTraversal interface methods **/


    public List< Integer > DepthFirstSearch( int startingVertex )
    {
        // Initialise DFS data structures

//        visitedVertex = new boolean[ numberOfVertices() ] ;
//
//        /* Initialisation: NO vertex has been visited */
//        System.out.println() ;
//        System.out.println( "DepthFirstSearch: NO vertex has been visited" ) ;
//        System.out.println() ;
//
//        for ( int vertex = 0 ; vertex < numberOfVertices() ; vertex++ )
//        {
//            System.out.println( "visitedVertex[ " + vertex + " ] = false " ) ;
//
//            visitedVertex[ vertex ] = false ;
//        }
//
//        /* Initialisation: create the empty DFS traversal path list */
//        DFSpath = new ArrayList< Integer >( numberOfVertices() ) ;
//
//        // STEP 1:
//        // Start the DFS search from the vertex specified by parameter: startingVertex
//
//        System.out.println( "DepthFirstSearch CALLING DFS, param: " + startingVertex ) ;
//        DFS( startingVertex ) ;
//
//        // STEP 2:
//        // Continue the DFS from all vertices (including startingVertex)
//        // in case DFS failed to visit all vertices
//        //
//        // COMMENT OUT the following FOR-loop to just do DFS from startingVertex.
//
//        /* Start search from first vertex. */
//        for ( int vertex =  0 ; vertex < numberOfVertices(); vertex++ )   //  vertex = STARTING_VERTEX
//        {
//            // performs DFS recursively.
//            if ( ! visitedVertex[ vertex ] )
//            {
//                System.out.println( "DepthFirstSearch CALLING DFS, param: " + vertex ) ;
//
//                DFS( vertex ) ;
//            }
//        }

        return DFSpath ;
    }


    public void DFS( int startingVertex )
    {
//        // Mark startingVertex as having been visited
//        visitedVertex[ startingVertex ] = true ;
//
//        // **** TO-DO ****
//        // Process Vertex: add startingVertex to the DFS traversal path
//        DFSpath.add( startingVertex ) ;
//
//        System.out.println( "visitedVertex[ " + startingVertex + " ] = true " ) ;
//        printPath( DFSpath ) ;

        /* Process vertex vs */
//        for ( int destinationVertex = 0;  destinationVertex < numberOfVertices(); destinationVertex++ )
//        {
//            // Check for an edge from startingVertex to destinationVertex
//            // & destinationVertex not visited,
//            // i.e. destinationVertex is an unvisited neighbour/adjacent vertex to startingVertex
//
//            // **** TO-DO ****
//            // replace "false" with correct boolean expression
//            if ( isAdjacent( startingVertex, destinationVertex ) & !visitedVertex[ destinationVertex ] )
//            {
//                // Visit destinationVertex
//                System.out.println( "DFS CALLING DFS, param: " + destinationVertex ) ;
//                DFS( destinationVertex ) ;
//            }
//        }
    }


    //------------------------------------------------------------------------------
    // Breadth First Search of Graph using Adjacency Matrix
    //------------------------------------------------------------------------------

    public List< String > BreadthFirstSearch(String startingVertex, long parserTime) {
        this.parserTime = parserTime;

        // Initialise BFS data structures
//        visitedVertex = new ArrayList<>();
        visitedVertex = new HashSet<>();


        /* Initialisation: NO vertex has been visited */
//        for ( int vertex = 0 ; vertex < numberOfVertices() ; vertex++ )
//        {
//            System.out.println( "visitedVertex[ " + vertex + " ] = false " ) ;
//
//            visitedVertex[ vertex ] = false ;
//        }

        /* Initialisation: create the empty BFS traversal path list */
        BFSpath = new ArrayList<String>();

        // STEP 1:
        // Start the BFS search from the vertex specified by parameter: startingVertex
        String[] startingVertexString = startPosition.split(", y");
        int startingVertexStringRow = Integer.valueOf((startingVertexString[0].substring(2))) +1;
        int startingVertexStringColumn = Integer.valueOf(startingVertexString[1].replace(")", "")) +1;


        String[] finishVertexString = finishPosition.split(", y");
        int finishVertexStringRow = Integer.valueOf((finishVertexString[0].substring(2))) +1;
        int finishVertexStringColumn = Integer.valueOf(finishVertexString[1].replace(")", "")) +1;



        System.out.println("Starting Breadth First Search at start node: " + "(" + startingVertexStringRow + ", " + startingVertexStringColumn  + ")" +
                " and finish node: " + "(" + finishVertexStringRow + ", " + finishVertexStringColumn  + ")");
        BFS(startingVertex);

        // STEP 2:  now continue the BFS from all vertices (including startingVertex)
        //          in case BFS failed to visit all vertices
        //
        // COMMENT OUT the following FOR-loop to just do DFS from startingVertex.

        /* Start search BFS from first vertex. */

//        for (String vertex : keySet) //  vertex = STARTING_VERTEX
//            {
//                // perform BFS on vertex
//                if (!visitedVertex.contains(vertex)) {
//                    System.out.println("BreadthFirstSearch CALLING BFS, param: " + vertex);
//
//                    BFS(vertex);
//                }
//            }

            return BFSpath;

    }


        public void BFS (String startingVertex )
        {
            long startTime = System.currentTimeMillis( ) ;

            previousNodeList = new HashMap<String, String>();
//            ArrayList<String> vertexQueue = new ArrayList<>();

            vertexQueue.offer(startingVertex);
            visitedVertex.add(startingVertex);
            BFSpath.add(startingVertex);
            boolean notFound = true;
            int testCount = 0;
            while (!vertexQueue.isEmpty() && notFound)  {   // vertexQueue is not empty  && notFound)
                String firstVertex = vertexQueue.remove();
                bounceMovementList.put(firstVertex, new HashSet<>());

                /***/
                  String[] ar = firstVertex.split(", y");
                  int currentRow = Integer.valueOf((ar[0].substring(2)));
                  int currentColumn = Integer.valueOf(ar[1].replace(")", ""));


                    //for top
                    setBounceValues(firstVertex, currentRow, currentColumn, (nextRow, nextColumn) -> {
                        return new Integer[]{nextRow, nextColumn - 1};
                    });

                    //for bottom
                    setBounceValues(firstVertex, currentRow, currentColumn, (nextRow, nextColumn) -> {
                        return new Integer[]{nextRow, nextColumn + 1};
                    });

                    //for left
                    setBounceValues(firstVertex, currentRow, currentColumn, (nextRow, nextColumn) -> {
                        return new Integer[]{nextRow - 1, nextColumn};
                    });

                    //for right
                    setBounceValues(firstVertex, currentRow, currentColumn, (nextRow, nextColumn) -> {
                        return new Integer[]{nextRow + 1, nextColumn};
                    });


                for (String adjacentVertex: bounceMovementList.get(firstVertex)) {
                    testCount++;
//                    System.out.println("TESTTTT: " + testCount);
//                    System.out.println(firstVertex + "  " + adjacentVertex);
//                    System.out.println(bounceMovementList.get(firstVertex).contains( adjacentVertex ));
//                    System.out.println("vertexqueue: " + vertexQueue.toString());
//                    System.out.println(isAdjacent( firstVertex, adjacentVertex));
                     if (!visitedVertex.contains(adjacentVertex)) {
// || adjacentVertex.equals(finishPosition)
//                         System.out.println("current vertex: " + adjacentVertex);

                         vertexQueue.offer(adjacentVertex);
                         visitedVertex.add(adjacentVertex);
//                         BFSpath.add(adjacentVertex);
                         previousNodeList.putIfAbsent(adjacentVertex, firstVertex);
                         if (adjacentVertex.equals(finishPosition)) {
//
                             notFound = false;
                         }
                     }
                }
//                System.out.println("VERTEXQUEUE: " + vertexQueue.toString());


            }

            long endTime = System.currentTimeMillis( ) ;

//            System.out.println(previousNodeList.toString());
//            printPath(BFSpath);

//            for (String value:previousNodeList.keySet()
//                 ) {
//
//            } {
//            }

            String child = (finishPosition);
            String parent = previousNodeList.get(child);
            ArrayList<String> path = new ArrayList<>();

            //parent, child
            //child, parent
            while(true){
                if (parent==null) {
                    break;
                }
//                System.out.print(child + "  ");
                path.add(child);
                child = parent;
                parent = previousNodeList.get(child);

            }

            path.add(startPosition);
//            System.out.println("visited: " + visitedVertex.toString());
//            System.out.println("start: " + startPosition);
//            System.out.println("finish: " + finishPosition);
            System.out.println("Shortest Path: " );
            Collections.reverse(path);

            String previousPath = startPosition;
            int count = 1;
            for (String currentPath:path) {

                String[] previousPathString = previousPath.split(", y");
                int previousPathRow = Integer.valueOf((previousPathString[0].substring(2))) +1;
                int previousPathColumn = Integer.valueOf(previousPathString[1].replace(")", "")) +1;


                String[] currentPathString = currentPath.split(", y");
                int currentPathRow = Integer.valueOf((currentPathString[0].substring(2))) +1;
                int currentPathColumn = Integer.valueOf(currentPathString[1].replace(")", "")) +1;


                String movementString = "";

                //top
                if (previousPathColumn > currentPathColumn) {
                    movementString = count + ". Move up to (" + currentPathRow + ", " + currentPathColumn  + ")";
                }
                //bottom
                else if (previousPathColumn < currentPathColumn) {
                    movementString = count + ". Move down to (" + currentPathRow + ", " + currentPathColumn  + ")";

                }
                //left
                else if (previousPathRow > currentPathRow) {
                    movementString = count + ". Move left to (" + currentPathRow + ", " + currentPathColumn  + ")";

                }
                //right
                else if (previousPathRow < currentPathRow) {
                    movementString = count + ". Move right to (" + currentPathRow + ", " + currentPathColumn  + ")";

                }

                if (count == 1) {
                    movementString = "1. Start at (" + currentPathRow + ", " + currentPathColumn  + ")";
                }

                System.out.println(movementString);
                previousPath = currentPath;
                count++;
            }

//            printBounce();
            System.out.println("Done!");
            System.out.println("Number of steps: " + path.size());
            System.out.println("Parser time: " + parserTime  + "ms");
            System.out.println("BFS Time taken: " + (endTime-startTime) + "ms");

//            System.out.println("visitedVertex size: " + visitedVertex.size());



            //        for (String vertex : bounceMovementList.get(startingVertex)) //  vertex = STARTING_VERTEX
//            {
//                // perform BFS on vertex
//                if (!visitedVertex.contains(vertex)) {
//                    System.out.println("BreadthFirstSearch CALLING BFS, param: " + vertex);
//
//                    BFS(vertex);
//                }
//            }
//            System.out.println("hello");


//            // Intialise queue
//
//            // Mark startingVertex as having been visited
////        visitedVertex[ startingVertex ] = true ;
//            visitedVertex.add(startingVertex);
//
//            System.out.println("visitedVertex[ " + startingVertex + " ] = true ");
//            printPath(BFSpath);
//
//            // **** TO-DO ****
//            // add startingVertex to rear of queue
//            vertexQueue.add(startingVertex);
//
//
//            while (!vertexQueue.isEmpty())   // vertexQueue is not empty
//            {
//                // return & remove 1st visited vertex from queue
//                String firstVertex = vertexQueue.remove(0);
//
//                for (int destinationVertex = 0; destinationVertex < bounceMovementList.get(firstVertex).size(); destinationVertex++) {
//                    // Check for an edge from neighbourVertex to destinationVertex
//                    // & destinationVertex not visited,
//                    // i.e. destinationVertex is an unvisited neighbour/adjacent vertex to neighbourVertex
//
//                    // **** TO-DO ****
//                    // replace "false" with correct boolean expression
//                if ( isAdjacent( firstVertex, bounceMovementList.get(firstVertex).get(destinationVertex)) & !visitedVertex.contains(destinationVertex) )
//                {
//                    // **** TO-DO ****
//                    // 1. set destinationVertex as having been visited
//                    // 2. add destinationVertex to rear of queue
//
//                    if (!visitedVertex.contains((bounceMovementList.get(firstVertex).get(destinationVertex)))) {
//                    visitedVertex.add(bounceMovementList.get(firstVertex).get(destinationVertex)) ;
//
//                }
//
//                    if (!vertexQueue.contains((bounceMovementList.get(firstVertex).get(destinationVertex)))) {
//                        vertexQueue.add(bounceMovementList.get(firstVertex).get(destinationVertex)) ;
//
//                    }
////                    vertexQueue.add( bounceMovementList.get(firstVertex).get(destinationVertex) ) ;
//
////                    System.out.println( "visitedVertex[ " + destinationVertex + " ] = true " ) ;
////                    System.out.println( "BFS VISITED, vertex: " + destinationVertex ) ;
//                }
//                }
//
//                // Process firstVertex:
//                BFSpath.add(firstVertex);
////                System.out.println("VERTEX QUEUE: " + vertexQueue);
////                System.out.print("BFSpath: ");
//                printPath(BFSpath);
//            }


    }




    // Print out a DFS or BFS traversal path
    public void printPath( List< String > path )
    {
        if ( path == null )
        {
            System.out.println("No traversal path found") ;
        }
        else
        {
            for( String vertex : path )
            {
                System.out.print( vertex + " ") ;
            }
            System.out.println() ;
        }
    }

} // class GraphALTraversal

package a02;

/**
 * 
 * @author Yejay Demirkan
 * @author Vasiliki Ioannidou
 *
 */
public class PrimsAlgorithmTest {
	// File path to first example minimal spanning tree (change if necessary)
	final static String BSP_MST_1 = "..\\Algorithms\\BspMST\\bsp_mst_1.txt";
	// File path to second example minimal spanning tree (change if necessary)
	final static String BSP_MST_2 = "..\\Algorithms\\BspMST\\bsp_mst_2.txt";
	// File path to third example minimal spanning tree (change if necessary)
	final static String BSP_MST_3 = "..\\Algorithms\\BspMST\\bsp_mst_3.txt";

	public static void main(String[] args) {
		PrimsAlgorithm prim_test_1 = new PrimsAlgorithm(BSP_MST_1);
		PrimsAlgorithm prim_test_2 = new PrimsAlgorithm(BSP_MST_2);
		PrimsAlgorithm prim_test_3 = new PrimsAlgorithm(BSP_MST_3);

		// Test 1: run primMST to see if there are any runtime errors
		prim_test_1.primMST();
		prim_test_2.primMST();
		prim_test_3.primMST();

		// Test 2: getGraph to see if the file got converted correctly into a graph
		System.out.println("\n--------------BSP_MST_1 Graph--------------\n");
		System.out.println(prim_test_1.getGraph());
		System.out.println("\n--------------BSP_MST_2 Graph--------------\n");
		System.out.println(prim_test_2.getGraph());
		System.out.println("\n--------------BSP_MST_3 Graph--------------\n");
		System.out.println(prim_test_3.getGraph());
		
		// Test MINW: getGraph to see if the file got converted correctly into a graph
		System.out.println("\n--------------BSP_MST_1 MST--------------\n");
		System.out.println(prim_test_1.getMinW());
		System.out.println("\n--------------BSP_MST_2 MST--------------\n");
		System.out.println(prim_test_2.getMinW());
		System.out.println("\n--------------BSP_MST_3 MST--------------\n");
		System.out.println(prim_test_3.getMinW());

		// Test 3: getStartVertex to see if correct start vertex of graph has been
		// determined
		System.out.println("\n--------------BSP_MST_1 Start Vertex-------\n");
		System.out.println(prim_test_1.getStartVertex());
		System.out.println("\n--------------BSP_MST_2 Start Vertex-------\n");
		System.out.println(prim_test_2.getStartVertex());
		System.out.println("\n--------------BSP_MST_3 Start Vertex-------\n");
		System.out.println(prim_test_3.getStartVertex());
		System.out.println("\n-------------------------------------------\n");

		// Final Test: check if weight of the minimal spanning tree and graph as a whole
		// is correct
		System.out.println("Total weight of graph: " + prim_test_1.weightOfGraph() + " | weight of MST: "
				+ prim_test_1.weightOfMinW() + " for BSP_MST_1\n");
		System.out.println("Total weight of graph: " + prim_test_2.weightOfGraph() + " | weight of MST: "
				+ prim_test_2.weightOfMinW() + "  for BSP_MST_2\n");
		System.out.println("Total weight of graph: " + prim_test_3.weightOfGraph() + " | weight of MST: "
				+ prim_test_3.weightOfMinW() + " for BSP_MST_3\n");

	}
}

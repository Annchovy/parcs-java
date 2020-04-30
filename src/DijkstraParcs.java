import parcs.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DijkstraParcs implements AM {
    public void run(AMInfo info) {
        Graph graph = (Graph) info.parent.readObject();
        ArrayList<String> names = (ArrayList<String>) info.parent.readObject();
        System.out.println(names);
        String result = "";
        try {
            for (String name : names) {
                System.out.println(name);
                Graph new_graph = Dijkstra.calculateShortestPathFromSource(graph, graph.hashNodes.get(name));
                result = result + new_graph.printDistances(graph.hashNodes.get(name));
                System.out.println(result);
            }
            info.parent.write(result);
        } catch (IOException ex) {
        }
    }
}

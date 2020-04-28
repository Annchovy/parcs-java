import parcs.*;

import java.io.IOException;


public class DijkstraParcs implements AM {
    public void run(AMInfo info){
        Graph graph = (Graph) info.parent.readObject();
        String nodes;
        nodes = (String) info.parent.readObject();
        System.out.println(nodes);
        String[] splited = nodes.split(" ");
        for (String name : splited) {
            try {
                System.out.println(name);
                Graph new_graph = Dijkstra.calculateShortestPathFromSource(graph, graph.hashNodes.get(name));
                String result = new_graph.printDistances(graph.hashNodes.get(name));
                System.out.println(result);
                info.parent.write(result);
            } catch (IOException ex) {

            }
        }
    }
}

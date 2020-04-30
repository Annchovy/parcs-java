import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node implements Serializable {

    private String name;

    private LinkedList<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public List<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setDistance(Integer newDistance) {
        this.distance = newDistance;
    }

    public void setShortestPath(LinkedList<Node> newShortestPath) {
        this.shortestPath = newShortestPath;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }
    // getters and setters
}
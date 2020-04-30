import java.io.*;
import java.util.*;

public class Graph implements Serializable{

    public HashMap<String, Node> hashNodes = new HashMap<>();
    public Set<Node> nodes = new HashSet<>();
    public ArrayList<String> names = new ArrayList<>();

    public Graph(String fileName)throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(
                fileName));
        String line = reader.readLine();
        while (line != null) {
            String[] splited = line.split(" ");
            Node nodeFirst;
            Node nodeSecond;
            if (this.hashNodes.containsKey(splited[0])) {
                nodeFirst = this.hashNodes.get(splited[0]);
            } else {
                nodeFirst = new Node(splited[0]);
            }
            if (this.hashNodes.containsKey(splited[1])) {
                nodeSecond = this.hashNodes.get(splited[1]);
            } else {
                nodeSecond = new Node(splited[1]);
            }
            nodeFirst.addDestination(nodeSecond, Integer.parseInt(splited[2]));
            if (!this.hashNodes.containsKey(splited[0])) {
                this.addNode(splited[0], nodeFirst);
            }
            if (!this.hashNodes.containsKey(splited[1])) {
                this.addNode(splited[1], nodeSecond);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public void addNode(String name, Node nodeA) {
        nodes.add(nodeA);
        names.add(name);
        hashNodes.put(name, nodeA);
    }

    public String printDistances(Node nodeStart)
            throws IOException {
        String result = "";
        for (Node node : nodes) {
            Integer distance = node.getDistance();
            String print_distance = " is " + distance.toString();
            if (distance == Integer.MAX_VALUE){
                print_distance = " path doesn't exist ";
            }
            String str = "From " + nodeStart.getName() + " to " + node.getName() + print_distance + "\n";
            result = result + str;
        }
        return result;
//        FileWriter fileWriter = new FileWriter("results");
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        for (Node node : nodes) {
//            String str = "From " + nodeStart.getName() + " to " + node.getName() + " is " + node.getDistance().toString() + "\n";
//            printWriter.print(str);
//        }
//        printWriter.close();
    }
}
import java.io.*;
import java.util.List;

import parcs.*;

public class Main{

    public static void main(String[] args)
            throws IOException {
        task curtask = new task();
        curtask.addJarFile("DijkstraParcs.jar");
        Graph graph = new Graph(curtask.findFile("input"));
        AMInfo info = new AMInfo(curtask, null);
//        Graph graph = new Graph("graph");
        int len = graph.names.size();
        for (int i = 0; i < 4; i ++){
            List subnames = graph.names.subList(i*len/4, i*len/4 + len/4);
            String names = "";
            for (int j = 0; j < subnames.size(); j++){
                names = names + " " + subnames.get(j);
            }
            System.out.println(names);
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("DijkstraParcs");
            c.write(graph);
            c.write(names);
            System.out.println("Waiting for result...");
            System.out.println("Result: " + (String) c.readObject());
            curtask.end();
        }
    }
}

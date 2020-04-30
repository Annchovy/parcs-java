import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
        ArrayList<ArrayList<String>> array_names = new ArrayList<ArrayList<String>>();
//        List<channel> channels = new ArrayList<>();
//        List<point> points = new ArrayList<>();
        for (int i = 0; i < 4; i ++){
            ArrayList<String> subnames = new ArrayList<String>(graph.names.subList(i*len/4, i*len/4 + len/4));
            array_names.add(subnames);
        }
        point p1 = info.createPoint();
        channel c1 = p1.createChannel();
        p1.execute("DijkstraParcs");
        c1.write(graph);
        c1.write(array_names.get(0));

        point p2 = info.createPoint();
        channel c2 = p2.createChannel();
        p2.execute("DijkstraParcs");
        c2.write(graph);
        c2.write(array_names.get(1));

        point p3 = info.createPoint();
        channel c3 = p3.createChannel();
        p3.execute("DijkstraParcs");
        c3.write(graph);
        c3.write(array_names.get(2));

        point p4 = info.createPoint();
        channel c4 = p4.createChannel();
        p4.execute("DijkstraParcs");
        c4.write(graph);
        c4.write(array_names.get(3));

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c1.readObject());
        System.out.println("Waiting for result...");
        System.out.println("Result: " + c2.readObject());
        System.out.println("Waiting for result...");
        System.out.println("Result: " + c3.readObject());
        System.out.println("Waiting for result...");
        System.out.println("Result: " + c4.readObject());
        curtask.end();
    }
}

all: run

clean:
	rm -f out/Main.jar out/DijkstraParcs.jar

out/Main.jar: out/parcs.jar src/Main.java src/Node.java src/Graph.java src/Dijkstra.java
	@javac -cp out/parcs.jar src/Main.java src/Node.java src/Graph.java src/Dijkstra.java
	@jar cf out/Main.jar -C src Main.class -C src Node.class Graph.class Dijkstra.class
	@rm -f src/Main.class src/Node.class src/Graph.class src/Dijkstra.class

out/DijkstraParcs.jar: out/parcs.jar src/DijkstraParcs.java src/Node.java src/Graph.java src/Dijkstra.java
	@javac -cp out/parcs.jar src/DijkstraParcs.java src/Node.java src/Graph.java src/Dijkstra.java
	@jar cf out/DijkstraParcs.jar -C src DijkstraParcs.class -C src Node.class Graph.class Dijkstra.class
	@rm -f src/DijkstraParcs.class src/Node.class src/Graph.class src/Dijkstra.class

build: out/Main.jar out/DijkstraParcs.jar

run: out/Main.jar out/DijkstraParcs.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main
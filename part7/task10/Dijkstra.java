package main.ru.mephi.java.part7.task10;

import java.util.*;

public class Dijkstra {
    private Map<String, Set<Neighboor>> graph = new HashMap<>();

    private Map<String, Set<Neighboor>> getGraph() {
        return graph;
    }

    //add new node
    public void addNodeOriented(String source, String neighbor, int distance) {
        Set<Neighboor> set1 = graph.getOrDefault(source, new HashSet<>());
        set1.add(new Neighboor(neighbor, distance));
        graph.put(source, set1);
        /*
        Set<Neighboor> set2= graph.getOrDefault(neighbor, new HashSet<>());
        set2.add(new Neighboor(source,distance));
        graph.put(neighbor, set2);

         */
    }

    public void addNodeNotOriented(String source, String neighbor, int distance) {
        Set<Neighboor> set1 = graph.getOrDefault(source, new HashSet<>());
        set1.add(new Neighboor(neighbor, distance));
        graph.put(source, set1);

        Set<Neighboor> set2 = graph.getOrDefault(neighbor, new HashSet<>());
        set2.add(new Neighboor(source, distance));
        graph.put(neighbor, set2);
    }

    /**
     * if value <0, it means this node is unreachable
     */
    public Map<String, Integer> calculate(String source) {
        Set<String> unused = getUnused();

        PriorityQueue<Neighboor> neighbors = new PriorityQueue<>();
        neighbors.add(new Neighboor(source, 0));
        Map<String, Integer> distances = new HashMap<>();
        Neighboor neighboor;
        while (!unused.isEmpty() && neighbors.size() > 0) {
            neighboor = neighbors.poll();
            if (unused.remove(neighboor.getName())) {//mark as visited
                int len = neighboor.getLengths();//distance to neighbor from source
                Set<Neighboor> neighborDistances = graph.get(neighboor.getName());//neighbors of neighbor
                if(neighborDistances!=null)
                for (Neighboor neighborOfNeighbor : neighborDistances) {
                    int lenTo = distances.getOrDefault(neighborOfNeighbor.getName(), Integer.MAX_VALUE);
                    int lenVTo = neighborOfNeighbor.getLengths();//distance from neighbor to TO(neighbor of neighbor)
                    if (lenTo > len + lenVTo) {
                        lenTo = len + lenVTo;
                        distances.put(neighborOfNeighbor.getName(), lenTo);
                        neighbors.add(new Neighboor(neighborOfNeighbor.getName(), lenTo));
                    }
                }
            }
        }
        if (!unused.isEmpty()) {
            unused.forEach(p -> distances.put(p, Integer.MIN_VALUE));
        }
        distances.remove(source);
        return distances;
    }

    private Set<String> getUnused() {
        Set<String> unused = new HashSet<>(graph.keySet()); //not used nodes
        for (String node : graph.keySet()) {
            for (Neighboor neighboor : graph.get(node)) {
                unused.add(neighboor.getName());
            }
        }
        return unused;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.addNodeNotOriented("1", "2", 7);
        dijkstra.addNodeNotOriented("1", "3", 9);
        dijkstra.addNodeNotOriented("1","6",14);

        dijkstra.addNodeNotOriented("2", "3", 10);
        dijkstra.addNodeNotOriented("2","4",15);


        dijkstra.addNodeNotOriented("3","4",11);
        dijkstra.addNodeNotOriented("3","6",2);

        dijkstra.addNodeNotOriented("4","5",6);
        dijkstra.addNodeNotOriented("5","6",9);

        dijkstra.calculate("1").forEach((k,v)->System.out.println(k+"->"+v));
    }
}

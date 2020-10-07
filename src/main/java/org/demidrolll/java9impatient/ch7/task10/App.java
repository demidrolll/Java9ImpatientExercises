package org.demidrolll.java9impatient.ch7.task10;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implement Dijkstra’s algorithm to find the shortest paths in a network of
 * cities, some of which are connected by roads. (For a description, check
 * out your favorite book on algorithms or the Wikipedia article.) Use a
 * helper class Neighbor that stores the name of a neighboring city and the
 * distance. Represent the graph as a map from cities to sets of neighbors.
 * Use a PriorityQueue<Neighbor> in the algorithm.
 */
public class App {
    public static void main(String[] args) {
        Map<City, Set<Neighbor>> map = new HashMap<>();
        fillBelarusMap(map);
        Map<City, Integer> result = findPath(map, City.BREST);
        System.out.println(result);
    }

    public static Map<City, Integer> findPath(Map<City, Set<Neighbor>> map, City from) {
        Map<City, Integer> result = new HashMap<>();
        Set<City> visitedCities = new HashSet<>();
        PriorityQueue<Neighbor> neighborsQueue = new PriorityQueue<>(Comparator.comparing(Neighbor::getDistance));

        result.put(from, 0);
        while (from != null) {
            neighborsQueue.clear();
            neighborsQueue.addAll(map.get(from));
            Neighbor neighbor;
            City nearestCity = null;

            // View neighbors from lo to high distance
            while ((neighbor = neighborsQueue.poll()) != null) {
                if (visitedCities.contains(neighbor.getCity())) {
                    continue;
                }
                // First neighbor is nearest
                if (nearestCity == null) {
                    nearestCity = neighbor.getCity();
                }
                Integer labelDistance = result.computeIfAbsent(neighbor.getCity(), k -> -1);
                Integer newDistance = result.get(from) + neighbor.getDistance();
                if (labelDistance == -1 || newDistance < labelDistance) {
                    result.put(neighbor.getCity(), newDistance);
                }
            }
            visitedCities.add(from);
            from = nearestCity;
        }

        return result;
    }

    public static void fillBelarusMap(Map<City, Set<Neighbor>> map) {
        Set<Neighbor> neighbors;

        // Brest neighbors (1)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.GRODNO, 14));
        neighbors.add(new Neighbor(City.MINSK, 9));
        neighbors.add(new Neighbor(City.GOMEL, 7));
        map.put(City.BREST, neighbors);

        // Gomel neighbors (2)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.BREST, 7));
        neighbors.add(new Neighbor(City.MINSK, 10));
        neighbors.add(new Neighbor(City.MOGILEV, 15));
        map.put(City.GOMEL, neighbors);

        // Minsk neighbors (3)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.BREST, 9));
        neighbors.add(new Neighbor(City.GOMEL, 10));
        neighbors.add(new Neighbor(City.MOGILEV, 11));
        neighbors.add(new Neighbor(City.GRODNO, 2));
        map.put(City.MINSK, neighbors);

        // Mogilev neighbors (4)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.GOMEL, 15));
        neighbors.add(new Neighbor(City.MINSK, 11));
        neighbors.add(new Neighbor(City.VITEBSK, 6));
        map.put(City.MOGILEV, neighbors);

        // Vitebsk neighbors (5)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.MOGILEV, 6));
        neighbors.add(new Neighbor(City.GRODNO, 9));
        map.put(City.VITEBSK, neighbors);

        // Grodno neighbors (6)
        neighbors = new HashSet<>();
        neighbors.add(new Neighbor(City.BREST, 14));
        neighbors.add(new Neighbor(City.MINSK, 2));
        neighbors.add(new Neighbor(City.VITEBSK, 9));
        map.put(City.GRODNO, neighbors);
    }
}

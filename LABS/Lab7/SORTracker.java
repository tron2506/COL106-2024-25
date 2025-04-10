import java.util.*;
import java.util.PriorityQueue;
public class SORTracker {
    // Max Heap to store the best locations (top i)
    private PriorityQueue<Location> bestHalf;
    // Min Heap to store the remaining locations
    private PriorityQueue<Location> remainingHalf;
    private int queryCount;

    public SORTracker() {
        // Max heap: Sort by highest score first, then lexicographically smallest name
        bestHalf = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return a.name.compareTo(b.name);
            return b.score - a.score;
        });

        // Min heap: Opposite of bestHalf
        remainingHalf = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return b.name.compareTo(a.name);
            return a.score - b.score;
        });

        queryCount = 0;
    }

    public void add(String name, int score) {
        Location newLocation = new Location(name, score);
        remainingHalf.offer(newLocation);

        // Move the best element from remainingHalf to bestHalf
        bestHalf.offer(remainingHalf.poll());

        // Ensure bestHalf only contains the top (queryCount + 1) elements
        if (bestHalf.size() > queryCount + 1) {
            remainingHalf.offer(bestHalf.poll());
        }
    }

    public String get() {
        queryCount++;
        return bestHalf.peek().name; // The best-ranked location
    }

    private static class Location {
        String name;
        int score;

        Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    // Example usage
    public static void main(String[] args) {
        SORTracker tracker = new SORTracker();
        tracker.add("location1", 5);
        tracker.add("location2", 3);
        tracker.add("location3", 8);
        tracker.add("location4", 8);
        
        System.out.println(tracker.get()); // "location3"
        System.out.println(tracker.get()); // "location4"
    }
}

import java.util.*;

public class CityRoadNetwork {
    static class Graph {
        private Map<String, List<String>> roadMap = new HashMap<>();

        public void addCity(String city) {
            roadMap.putIfAbsent(city, new ArrayList<>());
        }

        public void addRoad(String city1, String city2) {
            roadMap.get(city1).add(city2);
            roadMap.get(city2).add(city1);
        }

        public void displayAllRoads() {
            System.out.println("Road Connections:");
            for (String city : roadMap.keySet()) {
                System.out.println(city + " -> " + roadMap.get(city));
            }
        }

        public void displayConnectedCities(String city) {
            if (roadMap.containsKey(city)) {
                System.out.println("Cities connected to " + city + ": " + roadMap.get(city));
            } else {
                System.out.println(city + " is not in the network.");
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        System.out.println("City Road Network Manager");
        System.out.println("1. Add City");
        System.out.println("2. Add Road");
        System.out.println("3. Display All Roads");
        System.out.println("4. Display Connected Cities");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    graph.addCity(city);
                    System.out.println(city + " added to the network.");
                    break;
                case 2:
                    System.out.print("Enter first city: ");
                    String city1 = scanner.nextLine();
                    System.out.print("Enter second city: ");
                    String city2 = scanner.nextLine();
                    graph.addRoad(city1, city2);
                    System.out.println("Road added between " + city1 + " and " + city2 + ".");
                    break;
                case 3:
                    graph.displayAllRoads();
                    break;
                case 4:
                    System.out.print("Enter city name: ");
                    String sourceCity = scanner.nextLine();
                    graph.displayConnectedCities(sourceCity);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

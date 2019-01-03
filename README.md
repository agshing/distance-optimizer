# Distance Optimizer

```Distance Optimizer``` challenge is a classic example of [Shortest Path](https://en.wikipedia.org/wiki/Shortest_path_problem) problem.

There are many algorithms for solving the Shortest Path problem. As a default solution for solving this problem, I used [Dijkstra Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm). The main disadvantage of this algorithm is the fact that it does not deal well with a graph with negative distances or cycles. For cases with negative distances [Bellman-Ford Algorithm](https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm) may be used. However, that algorithm doesn't work correctly with negative cyclic graphs either. The approach used in solution allows to easily switch between algorithms by adding new implementations and modifying property file accordingly.

## Getting Started

This solution is not hardcoded and it follows ```Program to Interface``` and ```SOLID``` principles.

The solution is separated into small parts:

- Data Reading
- Data Parsing
- Graph Building
- Solver Initialisation
- Shortest Distance Calculation

```Strategy``` design pattern was used for data input and distance optimizer algorithms. This approach helps to modify the application's behavior without adding too much code. Several contracts were created for data reading and shortest distance calculation. By implementing these contracts application behavior could be changed easily.

Below is the description of application structure:

```DataReader``` interface is responsible for changing or adding a new input data source. As a default implementation a class named ```FileReader``` was used. It reads data from the specified file. If needed ```ConsoleReader``` and ```DbReader``` could be easily added in order to read data from the console or database accordingly.

```ShortestPath``` interface is responsible for adding other custom shortest path calculation algorithms. As a default implementation, Dijkstra's algorithm was used which is described in a class named ```Dijkstra```. Other algorithms could be easily added to the module by implementing ```ShortestPath``` interface.

The main class ```DistanceOptimizer``` has 2 methods: ```addConnection``` and ```computeShortestDistance```. Method ```addConnection``` takes 4 parameters ```from```, ```to```, ```distance```, ```isBidirectional```. It connects 2 edges and sets the distance between them. If the last parameter is true then method adds a bidirectional connection between nodes.  Other method ```computeShortestDistance``` takes names of the source and destination nodes as the parameter and calculates the shortest distance between them.

Application structure ensures that all parts of the system are decoupled and can live independently.

## Let's start

In order to use/test system use below git command to clone project to your computer:

```bash
git clone https://github.com/agshing/distance-optimizer.git
```

Alternatively, download the whole project folder as a .zip file from GitHub.

### Prerequisites

- Java 8+
- Apache Maven 4+
- Junit 4+

### Installing

```bash
mvn clean install
```

### Running the tests

The solution is fully unit tested. In order to run the tests following command should be used:

```bash
mvn test
```
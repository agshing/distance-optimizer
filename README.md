## Distance Optimizer

```Distance Optimizer``` challenge is a classic example of [Shortest Path](https://en.wikipedia.org/wiki/Shortest_path_problem) problem.

There are many algorithms for solving Shortest Path problem. As a default solution I used [Dijkstra Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) for solving this problem. The main disadvantage of this algorithm is that it does not calculate shortest path if there exist negative distance or cycle. For negative distances we could use [Bellman-Ford Algorithm](https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm) which also have limitations(can't work if there exist negative cycle). Approach used in solution allows to switch between algorithms easily by adding new implementations and modifying property file accordingly.

## Getting Started

This solution is not hardcoded and it follows ```Program to Interface``` and ```SOLID``` principles.

Solution is separated into small parts:
```
- Data Reading
- Data Parsing
- Graph Building
- Initializing Solver
- Calculating Shortest Distance
```

```Strategy``` design pattern was used for data input and for distance optimizer algorithms. It helps to modify application's behaviour without adding too much code. Several contracts were created for data reading and calculating shortest distance. By implementing these contracts application behaviour could be changed easily.

Below is descrition of application structure:

```DataReader``` interface is responsible for changing or adding new data input source. As a default implementation a class named ```FileReader``` is used. It reads data from the specified file. If needed ```ConsoleReader``` and ```DbReader``` could be easily added in order to read data from console or from database accordingly.

```ShortestPath``` interface is responsible for adding other custom algorithms. As a default implementations Dijkstra's algorithm is used which described in a class named ```Dijkstra```. Other algorithms could be easily added to the module by implementing ```ShortestPath``` interface.

The main class ```DistanceOptimizer``` has 2 methods: ```addConnection``` and ```computeShortestDistance```. Method ```addConnection``` takes 4 parameters ```from```, ```to```, ```distance```, ```isBidirectional```. It connects 2 edges and sets distance between them. If last parameter is true then method adds bidirectional connection between nodes.  Other method ```computeShortestDistance``` takes 2 parameters ```source```, ```destination``` and calculates shortest distance between source and destination.

Application structure ensures that all parts of the system are decoupled and can live independently.

### Let's start

In order to use/test system use below git command to clone project to your computer:
```
git clone https://github.com/agshing/distance-optimizer.git
```
Otherwise download the whole project folder as .zip file from github page.

### Prerequisites
```
Java 8+
Apache Maven 4+
Junit 4+
```
### Installing
```
mvn clean install
```
### Running the tests
Solution is fully unit tested. In order to run the tests following command should be used:
```
mvn test
```
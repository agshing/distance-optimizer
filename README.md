Distance optimizer challenge is a classic example of [Shortest Path](https://en.wikipedia.org/wiki/Shortest_path_problem) problem.

There are many algorithms for solving Shortest Path problem. As a default solution I used a [Dijkstra Algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) for solving this problem. The main disadvantage of this algorithm is that it does not calculate shortest path if there exist negative distance. For negative distances we could use [Bellman-Ford Algorithm](https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm) which also have limitations(can't work if there exist negative cycle). My approach allows to switch between algorithms easily by adding new implementations and modifying property file accordingly.

## Getting Started

This solution is not hardcoded and I tried to follow ```Program to Interface``` and ```SOLID``` principles.

Solution is separated into small parts:
```
- Data Reading
- Data Parsing
- Graph Building
- Initializing Solver
- Calculating Shortest Distance
```

I have implemented ```Strategy``` design pattern for data input and for distance optimizer algorithms. It helped me to change application behaviour without adding too much code. I have created several contracts for data reading and calculating shortest distance. So we can easily implement defined interfaces and change our solution behaviour.

Below I describe application structure in details:

Our ```DataReader``` interface is in order to change or add new data input source. As a default I implemented a class named ```FileReader``` that reads data from file. If needed we can easily add ```ConsoleReader``` and ```DbReader``` classes in order to read data from console or from database accordingly.

```ShortestPath``` interface is in order to add other custom algorithms. As a default I implemented Dijkstra's algorithm in a class named ```Dijkstra```. Other algorithms could be easily added to the module by implementing ```ShortestPath``` interface.

Our main class ```DistanceOptimizer``` has 2 methods: ```addConnection``` and ```computeShortestDistance```. Method ```addConnection``` takes 4 parameters ```from```, ```to```, ```distance```, ```isBidirectional```. It connects 2 edges and sets distance between them. If last parameter is true then method adds bidirectional connection between nodes.  Other method ```computeShortestDistance``` takes 2 parameters ```source```, ```destination``` and calculates shortest distance between source and destination.

Application structure ensures that all parts of the system are decoupled and can live independently.

### Let's start

In order to use/test system you should use below git command to clone project to your computer:
```
git clone https://github.com/agshing/distance-optimizer.git
```
Otherwise you can download the whole project folder as .zip file from github page.

### Prerequisites
```
Java 8
Apache Maven 4+
Junit 4+
```
### Installing
```
mvn clean install
```
### Running the tests
Solution fully unit tested. In order to run the tests following command should be used:
```
mvn test
```
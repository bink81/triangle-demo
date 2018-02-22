# triangle-demo

This is a simple demo of a triangle analysis to determine whether it is equilateral, isosceles or scalene.

## Getting Started

These instructions will get the project running on your local machine.

### Prerequisites

Maven and Java SE Development Kit 8

### To run unit tests
```
mvn clean verify
```

### To build a fat jar
```
mvn clean compile assembly:single
```

### To execute the jar
```
java -cp target/triangle-demo-0.0.1-SNAPSHOT-jar-with-dependencies.jar math.TriangleDemo
```

## Built With

* [Java SE Development Kit 8](http://http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) - Java environment
* [Maven](https://maven.apache.org/) - Dependency Management

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

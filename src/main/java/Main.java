import graph.GraphLink;

public class Main {
    public static void main(String[] args) {
        // Crear un grafo no dirigido
        GraphLink<String> graphLink = new GraphLink<>();

        // Insertar vértices
        graphLink.insertVertex("A");
        graphLink.insertVertex("B");
        graphLink.insertVertex("C");
        graphLink.insertVertex("D");

        // Insertar aristas
        graphLink.insertEdge("A", "B");
        graphLink.insertEdge("A", "C");
        graphLink.insertEdge("B", "D");
        graphLink.insertEdge("C", "D");

        // Ejercicio 5: Identificación de tipos de grafos
        System.out.println("Grado de A: " + graphLink.getDegree("A"));
        System.out.println("Grado de B: " + graphLink.getDegree("B"));
        System.out.println("Grado de C: " + graphLink.getDegree("C"));

        // Verificar si es un Camino
        System.out.println("Es un Camino: " + graphLink.isPath());

        // Verificar si es un Ciclo
        System.out.println("Es un Ciclo: " + graphLink.isCycle());

        // Verificar si es una Rueda
        System.out.println("Es una Rueda: " + graphLink.isWheel());

        // Verificar si es Completo
        System.out.println("Es Completo: " + graphLink.isComplete());

        // Representaciones del grafo
        graphLink.printFormalRepresentation();
        graphLink.printAdjacencyList();
        graphLink.printAdjacencyMatrix();
    }
}

import graph.GraphLink;
import graph.EdgeObj;
import graph.VertexObj;
import graph.GraphListEdge;

import java.util.ArrayList;

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

        // --- Ejercicio 5: Identificación de tipos de grafos ---
        // Verificar grado de los nodos
        System.out.println("Grado de A: " + graphLink.getDegree("A"));
        System.out.println("Grado de B: " + graphLink.getDegree("B"));
        System.out.println("Grado de C: " + graphLink.getDegree("C"));

        // Verificar si el grafo es un Camino
        System.out.println("Es un Camino: " + graphLink.isPath());

        // Verificar si el grafo es un Ciclo
        System.out.println("Es un Ciclo: " + graphLink.isCycle());

        // Verificar si el grafo es una Rueda
        System.out.println("Es una Rueda: " + graphLink.isWheel());

        // Verificar si el grafo es Completo
        System.out.println("Es Completo: " + graphLink.isComplete());

        // --- Ejercicio 6: Representaciones del grafo ---
        System.out.println("\n--- Ejercicio 6: Representaciones del grafo ---");
        graphLink.printFormalRepresentation();
        graphLink.printAdjacencyList();
        graphLink.printAdjacencyMatrix();


        // --- Ejercicio 7: Métodos para grafos dirigidos ---
        // Crear un grafo dirigido (usando GraphListEdge)
        GraphListEdge<String, Integer> directedGraph = new GraphListEdge<>();

        // Insertar vértices en el grafo dirigido
        directedGraph.insertVertex(new VertexObj<>("A", 0));
        directedGraph.insertVertex(new VertexObj<>("B", 1));
        directedGraph.insertVertex(new VertexObj<>("C", 2));
        directedGraph.insertVertex(new VertexObj<>("D", 3));

        // Crear objetos EdgeObj y luego insertarlos en el grafo
        EdgeObj<String, Integer> edge1 = new EdgeObj<>(directedGraph.searchVertex("A"), directedGraph.searchVertex("B"), 1, 0);
        EdgeObj<String, Integer> edge2 = new EdgeObj<>(directedGraph.searchVertex("A"), directedGraph.searchVertex("C"), 2, 1);
        EdgeObj<String, Integer> edge3 = new EdgeObj<>(directedGraph.searchVertex("B"), directedGraph.searchVertex("D"), 3, 2);
        EdgeObj<String, Integer> edge4 = new EdgeObj<>(directedGraph.searchVertex("C"), directedGraph.searchVertex("D"), 4, 3);

        // Insertar las aristas en el grafo dirigido
        directedGraph.insertEdge(edge1);
        directedGraph.insertEdge(edge2);
        directedGraph.insertEdge(edge3);
        directedGraph.insertEdge(edge4);

        // Mostrar el grafo dirigido
        System.out.println("\nGrafo con lista de aristas completo:");
        System.out.println(directedGraph);

        // --- Ejercicio 7: Verificar propiedades del grafo dirigido ---
        // Verificar el grado de un nodo en el grafo dirigido
        System.out.println("\nGrado de A en el grafo dirigido: " + directedGraph.getOutDegree("A"));

        // Verificar si el grafo dirigido es un Camino
        System.out.println("Es un Camino dirigido: " + directedGraph.isPathDirected());

        // Verificar si el grafo dirigido es un Ciclo
        System.out.println("Es un Ciclo dirigido: " + directedGraph.isCycleDirected());

        // Verificar si el grafo dirigido es una Rueda
        System.out.println("Es una Rueda dirigida: " + directedGraph.isWheelDirected());

        // Verificar si el grafo dirigido es Completo
        System.out.println("Es Completo dirigido: " + directedGraph.isCompleteDirected());

        // --- Ejercicio 8: Representaciones para grafos dirigidos ---
        System.out.println("\n--- Ejercicio 8: Representaciones para grafos dirigidos ---");
        directedGraph.printFormalRepresentation();
        directedGraph.printAdjacencyList();
        directedGraph.printAdjacencyMatrix();


        // --- Ejercicio 9: Propiedades de los grafos dirigidos ---
        // Verificar si el grafo dirigido es Isomorfo
        System.out.println("\nEs el grafo dirigido isomorfo al otro? " + directedGraph.isIsomorphic(directedGraph));

        // Verificar si el grafo dirigido es Plano
        System.out.println("Es el grafo dirigido plano? " + directedGraph.isPlanar());

        // Verificar si el grafo dirigido es Conexo
        System.out.println("Es el grafo dirigido conexo? " + directedGraph.isConnected());

        // Verificar si el grafo dirigido es Auto-complementario
        System.out.println("Es el grafo dirigido auto-complementario? " + directedGraph.isSelfComplementary());
    }
}

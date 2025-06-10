import graph.GraphLink;
import graph.GraphListEdge;
import jgrapht.JGraphTExample;

public class Main {

    public static void main(String[] args) {

        // Ejercicio 5: Identificación de tipos de grafos no dirigidos
        GraphLink<String> graphLink = new GraphLink<>();

        // Insertar vértices (nodos)
        graphLink.insertVertex("A");
        graphLink.insertVertex("B");
        graphLink.insertVertex("C");
        graphLink.insertVertex("D");

        // Insertar aristas (conexiones entre vértices)
        graphLink.insertEdge("A", "B");
        graphLink.insertEdge("A", "C");
        graphLink.insertEdge("B", "D");
        graphLink.insertEdge("C", "D");

        // Ejercicio 5: Verificando el tipo de grafo
        System.out.println("\nVerificando el tipo de grafo:");

        // Grado de los nodos
        System.out.println("Grado de A: " + graphLink.getDegree("A"));
        System.out.println("Grado de B: " + graphLink.getDegree("B"));
        System.out.println("Grado de C: " + graphLink.getDegree("C"));

        // Verificando si es un Camino
        if (graphLink.isPath()) {
            System.out.println("El grafo es un Camino (P3).");
        } else {
            System.out.println("El grafo no es un Camino.");
        }

        // Verificando si es un Ciclo
        if (graphLink.isCycle()) {
            System.out.println("El grafo es un Ciclo (C3).");
        } else {
            System.out.println("El grafo no es un Ciclo.");
        }

        // Verificando si es una Rueda
        if (graphLink.isWheel()) {
            System.out.println("El grafo es una Rueda (W3).");
        } else {
            System.out.println("El grafo no es una Rueda.");
        }

        // Verificando si es Completo
        if (graphLink.isComplete()) {
            System.out.println("El grafo es Completo (K4).");
        } else {
            System.out.println("El grafo no es Completo.");
        }

        // Ejercicio 6: Representación del grafo
        graphLink.printFormalRepresentation();
        graphLink.printAdjacencyList();
        graphLink.printAdjacencyMatrix();

        // Ejercicio 7: Grafos dirigidos con GraphListEdge
        GraphListEdge<String, Integer> graphListEdge = new GraphListEdge<>();

        // Insertar vértices
        graphListEdge.insertVertex("A", 0);
        graphListEdge.insertVertex("B", 1);
        graphListEdge.insertVertex("C", 2);
        graphListEdge.insertVertex("D", 3);

        // Insertar aristas dirigidas
        graphListEdge.insertEdge("A", "B", 1, 0);
        graphListEdge.insertEdge("A", "C", 2, 1);
        graphListEdge.insertEdge("B", "D", 3, 2);
        graphListEdge.insertEdge("C", "D", 4, 3);

        // Ejercicio 8: Representación dirigida del grafo
        graphListEdge.printFormalRepresentation();
        graphListEdge.printAdjacencyList();
        graphListEdge.printAdjacencyMatrix();

        // Ejercicio 9: Propiedades de grafos dirigidos (isomorfismo, plano, conexo)
        System.out.println("\n¿Es el grafo isomorfo?");
        if (graphListEdge.isIsomorphic(graphListEdge)) {
            System.out.println("El grafo es isomorfo.");
        } else {
            System.out.println("El grafo no es isomorfo.");
        }

        System.out.println("\n¿Es el grafo plano?");
        if (graphListEdge.isPlanar()) {
            System.out.println("El grafo es plano.");
        } else {
            System.out.println("El grafo no es plano.");
        }

        System.out.println("\n¿Es el grafo conexo?");
        if (graphListEdge.isConnected()) {
            System.out.println("El grafo es conexo.");
        } else {
            System.out.println("El grafo no es conexo.");
        }

        System.out.println("\n¿Es el grafo auto complementario?");
        if (graphListEdge.isSelfComplementary()) {
            System.out.println("El grafo es auto complementario.");
        } else {
            System.out.println("El grafo no es auto complementario.");
        }

        // Ejercicio 4: Usando JGraphT (opcional)
        JGraphTExample.jgraphExample();
    }
}

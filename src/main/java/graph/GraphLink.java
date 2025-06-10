package graph;

import java.util.*;

public class GraphLink<V> {

    private List<Vertex<V>> vertices;

    public GraphLink() {
        this.vertices = new ArrayList<>();
    }

    // --- Ejercicio 5: Insertar un vértice ---
    public void insertVertex(V data) {
        if (searchVertex(data) == null) {
            vertices.add(new Vertex<>(data));
        }
    }

    // --- Ejercicio 5: Insertar una arista ---
    public void insertEdge(V data1, V data2) {
        Vertex<V> v1 = searchVertex(data1);
        Vertex<V> v2 = searchVertex(data2);
        if (v1 != null && v2 != null) {
            v1.getAdjacencyList().add(new Edge<>(v2));
        }
    }

    // --- Ejercicio 5: Buscar un vértice ---
    public Vertex<V> searchVertex(V data) {
        for (Vertex<V> vertex : vertices) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    // --- Ejercicio 5: Identificar el tipo de grafo - Camino (Px) ---
    public boolean isPath() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 1) {
                count++;
            }
        }
        return count == 2;
    }

    // --- Ejercicio 5: Identificar el tipo de grafo - Ciclo (Cx) ---
    public boolean isCycle() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 2) {
                count++;
            }
        }
        return count == vertices.size();
    }

    // --- Ejercicio 5: Identificar el tipo de grafo - Rueda (Wx) ---
    public boolean isWheel() {
        int countCycle = 0;
        int countCenter = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == vertices.size() - 1) {
                countCenter++;
            } else if (vertex.getAdjacencyList().size() == 2) {
                countCycle++;
            }
        }
        return countCycle == vertices.size() - 1 && countCenter == 1;
    }

    // --- Ejercicio 5: Identificar el tipo de grafo - Completo (Kx) ---
    public boolean isComplete() {
        int totalEdges = vertices.size() * (vertices.size() - 1) / 2;
        int edgeCount = 0;
        for (Vertex<V> vertex : vertices) {
            edgeCount += vertex.getAdjacencyList().size();
        }
        return edgeCount / 2 == totalEdges;
    }

    // --- Ejercicio 6: Grado de un nodo (Gx) ---
    public int getDegree(V data) {
        Vertex<V> vertex = searchVertex(data);
        return vertex != null ? vertex.getAdjacencyList().size() : 0;
    }

    // --- Ejercicio 6: Representación Formal ---
    public void printFormalRepresentation() {
        for (Vertex<V> vertex : vertices) {
            System.out.print("Vértice: " + vertex.getData() + " - Conectado a: ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    // --- Ejercicio 6: Lista de Adyacencia ---
    public void printAdjacencyList() {
        for (Vertex<V> vertex : vertices) {
            System.out.print(vertex.getData() + ": ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    // --- Ejercicio 6: Matriz de Adyacencia ---
    public void printAdjacencyMatrix() {
        int size = vertices.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Vertex<V> v1 = vertices.get(i);
            for (Edge<V> edge : v1.getAdjacencyList()) {
                int j = vertices.indexOf(edge.getEndVertex());
                matrix[i][j] = 1;
                matrix[j][i] = 1;
            }
        }
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

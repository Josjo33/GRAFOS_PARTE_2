package graph;

import java.util.*;

public class GraphLink<V> {
    private List<Vertex<V>> vertices;

    public GraphLink() {
        this.vertices = new ArrayList<>();
    }

    // Métodos que se implementan para el ejercicio 5 (grados, tipos de grafo)
    public void insertVertex(V data) {
        if (searchVertex(data) == null) {
            vertices.add(new Vertex<>(data));
        }
    }

    public void insertEdge(V data1, V data2) {
        Vertex<V> v1 = searchVertex(data1);
        Vertex<V> v2 = searchVertex(data2);
        if (v1 != null && v2 != null) {
            v1.getAdjacencyList().add(new Edge<>(v2));
        }
    }

    public Vertex<V> searchVertex(V data) {
        for (Vertex<V> vertex : vertices) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    // --- Ejercicio 5: Métodos para identificar tipos de grafo ---
    // Grado de un nodo
    public int getDegree(V data) {
        Vertex<V> vertex = searchVertex(data);
        return vertex != null ? vertex.getAdjacencyList().size() : 0;
    }

    // Camino (Px)
    public boolean isPath() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 1) {
                count++;
            }
        }
        return count == 2;  // Camino tiene 2 nodos con grado 1
    }

    // Ciclo (Cx)
    public boolean isCycle() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 2) {
                count++;
            }
        }
        return count == vertices.size();  // Un ciclo tiene todos los vértices con grado 2
    }

    // Rueda (Wx)
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
        return countCycle == vertices.size() - 1 && countCenter == 1;  // Una rueda tiene 1 nodo central y un ciclo
    }

    // Completo (Kx)
    public boolean isComplete() {
        int totalEdges = vertices.size() * (vertices.size() - 1) / 2;
        int edgeCount = 0;
        for (Vertex<V> vertex : vertices) {
            edgeCount += vertex.getAdjacencyList().size();
        }
        return edgeCount / 2 == totalEdges;
    }

    // Métodos para representación
    public void printFormalRepresentation() {
        for (Vertex<V> vertex : vertices) {
            System.out.print("Vértice: " + vertex.getData() + " - Conectado a: ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList() {
        for (Vertex<V> vertex : vertices) {
            System.out.print(vertex.getData() + ": ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

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

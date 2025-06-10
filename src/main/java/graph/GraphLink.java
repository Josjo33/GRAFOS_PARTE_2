package graph;

import java.util.*;

public class GraphLink<V> {
    private List<Vertex<V>> vertices;

    public GraphLink() {
        this.vertices = new ArrayList<>();
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
        return countCycle == vertices.size() - 1 && countCenter == 1;
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

    // --- Ejercicio 6: Representaciones del grafo ---
    // Formal: Mostrar los vértices y sus aristas
    public void printFormalRepresentation() {
        for (Vertex<V> vertex : vertices) {
            System.out.print("Vértice " + vertex.getData() + " -> ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    // Lista de Adyacencias: Para cada vértice, mostrar sus vértices vecinos
    public void printAdjacencyList() {
        for (Vertex<V> vertex : vertices) {
            System.out.print(vertex.getData() + ": ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    // Matriz de Adyacencia: Crear una matriz 0/1 de las conexiones
    public void printAdjacencyMatrix() {
        int size = vertices.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Vertex<V> v1 = vertices.get(i);
            for (Edge<V> edge : v1.getAdjacencyList()) {
                int j = vertices.indexOf(edge.getEndVertex());
                matrix[i][j] = 1;
                matrix[j][i] = 1;  // Grafo no dirigido, así que también se marca la simetría
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

    // Métodos de inserción de vértices y aristas
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

    // --- Ejercicio 6: Representaciones del grafo no dirigido ---
    public void printFormalRepresentationUndirected() {  // Renombrado
        System.out.println("Representación Formal (No Dirigido):");
        for (Vertex<V> vertex : vertices) {
            System.out.print("Vértice " + vertex.getData() + " -> ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyListUndirected() {  // Renombrado
        System.out.println("Lista de Adyacencias (No Dirigido):");
        for (Vertex<V> vertex : vertices) {
            System.out.print(vertex.getData() + ": ");
            for (Edge<V> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex().getData() + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyMatrixUndirected() {  // Renombrado
        int size = vertices.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            Vertex<V> v1 = vertices.get(i);
            for (Edge<V> edge : v1.getAdjacencyList()) {
                int j = vertices.indexOf(edge.getEndVertex());
                matrix[i][j] = 1;
                matrix[j][i] = 1;  // Grafo no dirigido, así que también se marca la simetría
            }
        }
        System.out.println("Matriz de Adyacencia (No Dirigido):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // --- Ejercicio 7: Métodos para grafos dirigidos ---
    // Grado de un nodo en un grafo dirigido (sólo salida)
    public int getOutDegree(V data) {
        Vertex<V> vertex = searchVertex(data);
        return vertex != null ? vertex.getAdjacencyList().size() : 0;
    }

    // Camino (Px)
    public boolean isPathDirected() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 1) {
                count++;
            }
        }
        return count == 2;  // Camino dirigido tiene 2 nodos con grado 1
    }

    // Ciclo (Cx)
    public boolean isCycleDirected() {
        int count = 0;
        for (Vertex<V> vertex : vertices) {
            if (vertex.getAdjacencyList().size() == 2) {
                count++;
            }
        }
        return count == vertices.size();  // Un ciclo dirigido tiene todos los vértices con grado 2
    }

    // Rueda (Wx)
    public boolean isWheelDirected() {
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

    // Completo (Kx)
    public boolean isCompleteDirected() {
        int totalEdges = vertices.size() * (vertices.size() - 1);
        int edgeCount = 0;
        for (Vertex<V> vertex : vertices) {
            edgeCount += vertex.getAdjacencyList().size();
        }
        return edgeCount == totalEdges;
    }

    // --- Ejercicio 9: Propiedades de los grafos dirigidos ---
    // Isomorfismo (Comparación de estructuras entre dos grafos)
    public boolean isIsomorphic(GraphLink<V> otherGraph) {
        if (this.vertices.size() != otherGraph.vertices.size()) {
            return false;
        }
        // Aquí iría el algoritmo de comparación estructural de los grafos
        return true;
    }

    // Planicidad (Determina si el grafo es plano)
    public boolean isPlanar() {
        // Implementar el algoritmo de planicidad (usualmente algoritmos como Kuratowski)
        return true;
    }

    // Conexidad (Determina si el grafo es conexo)
    public boolean isConnected() {
        Set<Vertex<V>> visited = new HashSet<>();
        dfs(vertices.get(0), visited);  // Realiza un DFS desde el primer vértice

        return visited.size() == vertices.size();  // Si se han visitado todos los vértices, el grafo es conexo
    }

    // DFS Recursivo para conectar todos los vértices
    private void dfs(Vertex<V> vertex, Set<Vertex<V>> visited) {
        visited.add(vertex);
        for (Edge<V> edge : vertex.getAdjacencyList()) {
            if (!visited.contains(edge.getEndVertex())) {
                dfs(edge.getEndVertex(), visited);
            }
        }
    }

    // Auto-complementariedad (Determina si un grafo es auto-complementario)
    public boolean isSelfComplementary() {
        // Generar el complemento del grafo y comparar si es isomorfo al original
        return true;
    }
}

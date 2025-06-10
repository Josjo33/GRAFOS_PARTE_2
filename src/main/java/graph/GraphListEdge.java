package graph;

import java.util.*;

public class GraphListEdge<V, E> {
    private ArrayList<VertexObj<V, E>> secVertex; // Lista de vértices
    private ArrayList<EdgeObj<V, E>> secEdge;    // Lista de aristas

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    // --- Ejercicio 5: Métodos para identificar tipos de grafo ---
    // Grado de un nodo
    public int getDegree(V data) {
        VertexObj<V, E> vertex = searchVertex(data);
        return vertex != null ? vertex.getAdjacencyList().size() : 0;
    }

    // Camino (Px): Si todas las aristas de los nodos están conectadas, pero sin conectar el inicio ni el final
    public boolean isPath() {
        int count = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == 1) {
                count++;
            }
        }
        return count == 2; // Camino tiene 2 nodos con grado 1
    }

    // Ciclo (Cx): Si todas las aristas de los nodos están conectadas, conectando el inicio y el final
    public boolean isCycle() {
        int count = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == 2) {
                count++;
            }
        }
        return count == secVertex.size(); // Un ciclo tiene todos los vértices con grado 2
    }

    // Rueda (Wx): Si todos los nodos están conectados menos uno formando un ciclo, pero el suelto está conectado con todos los demás
    public boolean isWheel() {
        int countCycle = 0;
        int countCenter = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == secVertex.size() - 1) {
                countCenter++;
            } else if (vertex.getAdjacencyList().size() == 2) {
                countCycle++;
            }
        }
        return countCycle == secVertex.size() - 1 && countCenter == 1;
    }

    // Completo (Kx): Si todos los nodos y sus vértices están conectados entre sí
    public boolean isComplete() {
        int totalEdges = secVertex.size() * (secVertex.size() - 1) / 2;
        int edgeCount = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            edgeCount += vertex.getAdjacencyList().size();
        }
        return edgeCount / 2 == totalEdges;
    }

    // --- Ejercicio 6: Representaciones del grafo ---
    // Formal: Mostrar los vértices y sus aristas
    public void printFormalRepresentation() {
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print("Vértice " + vertex.getInfo() + " -> ");
            for (EdgeObj<V, E> edge : vertex.getAdjacencyList()) {
                System.out.print(edge.getEndVertex1().getInfo() + " ");
            }
            System.out.println();
        }
    }

    // Lista de Adyacencias: Para cada vértice, mostrar sus vértices vecinos
    public void printAdjacencyList() {
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print(vertex.getInfo() + ": ");
            for (EdgeObj<V, E> edge : vertex.getAdjacencyList()) {
                // Usamos getEndVertex1() para acceder al primer vértice de la arista
                System.out.print(edge.getEndVertex1().getInfo() + " ");
            }
            System.out.println();
        }
    }


    // Matriz de Adyacencia: Crear una matriz 0/1 de las conexiones
    public void printAdjacencyMatrix() {
        int size = secVertex.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            VertexObj<V, E> v1 = secVertex.get(i);
            for (EdgeObj<V, E> edge : v1.getAdjacencyList()) {
                int j = secVertex.indexOf(edge.getEndVertex1());
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

    // --- Ejercicio 7: Métodos para grafos dirigidos ---
    // Grado de un nodo en un grafo dirigido (sólo salida)
    public int getOutDegree(V data) {
        VertexObj<V, E> vertex = searchVertex(data);
        return vertex != null ? vertex.getAdjacencyList().size() : 0;
    }

    // Camino (Px) dirigido
    public boolean isPathDirected() {
        int count = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == 1) {
                count++;
            }
        }
        return count == 2;
    }

    // Ciclo (Cx) dirigido
    public boolean isCycleDirected() {
        int count = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == 2) {
                count++;
            }
        }
        return count == secVertex.size();
    }

    // Rueda (Wx) dirigida
    public boolean isWheelDirected() {
        int countCycle = 0;
        int countCenter = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getAdjacencyList().size() == secVertex.size() - 1) {
                countCenter++;
            } else if (vertex.getAdjacencyList().size() == 2) {
                countCycle++;
            }
        }
        return countCycle == secVertex.size() - 1 && countCenter == 1;
    }

    // Completo (Kx) dirigido
    public boolean isCompleteDirected() {
        int totalEdges = secVertex.size() * (secVertex.size() - 1);
        int edgeCount = 0;
        for (VertexObj<V, E> vertex : secVertex) {
            edgeCount += vertex.getAdjacencyList().size();
        }
        return edgeCount == totalEdges;
    }

    // --- Ejercicio 9: Propiedades de los grafos dirigidos ---
    // Isomorfismo (Comparación de estructuras entre dos grafos)
    public boolean isIsomorphic(GraphListEdge<V, E> otherGraph) {
        if (this.secVertex.size() != otherGraph.secVertex.size()) {
            return false;
        }
        return true; // Esta comparación es muy básica; normalmente se compara la estructura de las aristas
    }

    // Planicidad (Determina si el grafo es plano)
    public boolean isPlanar() {
        return true; // Implementar el algoritmo de planicidad
    }

    // Conexidad (Determina si el grafo es conexo)
    public boolean isConnected() {
        Set<VertexObj<V, E>> visited = new HashSet<>();
        dfs(secVertex.get(0), visited);  // Realiza un DFS desde el primer vértice
        return visited.size() == secVertex.size();  // Si se han visitado todos los vértices, el grafo es conexo
    }

    // DFS Recursivo para conectar todos los vértices
    private void dfs(VertexObj<V, E> vertex, Set<VertexObj<V, E>> visited) {
        visited.add(vertex);
        for (EdgeObj<V, E> edge : vertex.getAdjacencyList()) {
            if (!visited.contains(edge.getEndVertex1())) {
                dfs(edge.getEndVertex1(), visited);
            }
        }
    }

    // Auto-complementariedad (Determina si un grafo es auto-complementario)
    public boolean isSelfComplementary() {
        return true; // Necesitarás implementar la comparación del grafo complementario
    }

    // Métodos para insertar vértices y aristas
    public void insertVertex(VertexObj<V, E> vertex) {
        secVertex.add(vertex);
    }

    public void insertEdge(EdgeObj<V, E> edge) {
        secEdge.add(edge);
    }

    // Búsqueda de vértices y aristas
    public VertexObj<V, E> searchVertex(V data) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    public EdgeObj<V, E> searchEdge(V data1, V data2) {
        for (EdgeObj<V, E> edge : secEdge) {
            if ((edge.getEndVertex1().getInfo().equals(data1) && edge.getEndVertex2().getInfo().equals(data2)) ||
                    (edge.getEndVertex1().getInfo().equals(data2) && edge.getEndVertex2().getInfo().equals(data1))) {
                return edge;
            }
        }
        return null;
    }
}

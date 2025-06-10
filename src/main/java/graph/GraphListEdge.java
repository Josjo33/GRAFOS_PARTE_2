package graph;

import java.util.*;

public class GraphListEdge<V, E> {
    private ArrayList<VertexObj<V, E>> secVertex;
    private ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V v, int position) {
        if (searchVertex(v) == null) {
            secVertex.add(new VertexObj<>(v, position));
        }
    }

    public void insertEdge(V v1, V v2, E info, int position) {
        VertexObj<V, E> vertex1 = searchVertex(v1);
        VertexObj<V, E> vertex2 = searchVertex(v2);
        if (vertex1 != null && vertex2 != null) {
            EdgeObj<V, E> edge = new EdgeObj<>(vertex1, vertex2, info, position);
            if (searchEdge(v1, v2) == null) {
                secEdge.add(edge);
            }
        }
    }

    public VertexObj<V, E> searchVertex(V v) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(v)) {
                return vertex;
            }
        }
        return null;
    }

    public EdgeObj<V, E> searchEdge(V v1, V v2) {
        for (EdgeObj<V, E> edge : secEdge) {
            if ((edge.getEndVertex1().getInfo().equals(v1) && edge.getEndVertex2().getInfo().equals(v2)) ||
                    (edge.getEndVertex1().getInfo().equals(v2) && edge.getEndVertex2().getInfo().equals(v1))) {
                return edge;
            }
        }
        return null;
    }

    // Métodos de representación
    public void printFormalRepresentation() {
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print("Vértice: " + vertex.getInfo() + " - Conectado a: ");
            for (EdgeObj<V, E> edge : secEdge) {
                if (edge.getEndVertex1().getInfo().equals(vertex.getInfo())) {
                    System.out.print(edge.getEndVertex2().getInfo() + " ");
                } else if (edge.getEndVertex2().getInfo().equals(vertex.getInfo())) {
                    System.out.print(edge.getEndVertex1().getInfo() + " ");
                }
            }
            System.out.println();
        }
    }

    public void printAdjacencyList() {
        for (VertexObj<V, E> vertex : secVertex) {
            System.out.print(vertex.getInfo() + ": ");
            for (EdgeObj<V, E> edge : secEdge) {
                if (edge.getEndVertex1().getInfo().equals(vertex.getInfo())) {
                    System.out.print(edge.getEndVertex2().getInfo() + " ");
                } else if (edge.getEndVertex2().getInfo().equals(vertex.getInfo())) {
                    System.out.print(edge.getEndVertex1().getInfo() + " ");
                }
            }
            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        int size = secVertex.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            VertexObj<V, E> v1 = secVertex.get(i);
            for (EdgeObj<V, E> edge : secEdge) {
                if (edge.getEndVertex1().getInfo().equals(v1.getInfo())) {
                    int j = secVertex.indexOf(edge.getEndVertex2());
                    matrix[i][j] = 1;
                }
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

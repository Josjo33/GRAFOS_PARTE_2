package graph;

public class EdgeObj<V, E> {
    private VertexObj<V, E> endVertex1;
    private VertexObj<V, E> endVertex2;
    private E info;
    private int position;

    // Constructor
    public EdgeObj(VertexObj<V, E> endVertex1, VertexObj<V, E> endVertex2, E info, int position) {
        this.endVertex1 = endVertex1;
        this.endVertex2 = endVertex2;
        this.info = info;
        this.position = position;
    }

    // Métodos de acceso
    public VertexObj<V, E> getEndVertex1() {
        return endVertex1;
    }

    public VertexObj<V, E> getEndVertex2() {
        return endVertex2;
    }

    public E getInfo() {
        return info;
    }

    public int getPosition() {
        return position;
    }

    // Método para la representación en String de la arista
    @Override
    public String toString() {
        return "EdgeObj{" +
                "endVertex1=" + endVertex1.getInfo() +
                ", endVertex2=" + endVertex2.getInfo() +
                ", info=" + info +
                '}';
    }
}

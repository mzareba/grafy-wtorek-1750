package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;

public class P1 implements Production {
    @Override
    public boolean applicableTo(Vertex vertex) {
        return vertex.getSiblingsEdges().size() == 0;
    }

    @Override
    public void apply(Vertex vertex) {
        Vertex leftTop = Vertex.withoutParent();
        Vertex leftBottom = Vertex.withoutParent();
        Vertex rightTop = Vertex.withoutParent();
        Vertex rightBottom = Vertex.withoutParent();

        leftTop.connectToSibling(EdgeDirection.E, rightTop);
        leftTop.connectToSibling(EdgeDirection.S, leftBottom);

        rightBottom.connectToSibling(EdgeDirection.N, rightTop);
        rightBottom.connectToSibling(EdgeDirection.W, leftBottom);

        vertex.connectToSibling(EdgeDirection.NW, leftTop);
        vertex.connectToSibling(EdgeDirection.NE, rightTop);
        vertex.connectToSibling(EdgeDirection.SW, leftBottom);
        vertex.connectToSibling(EdgeDirection.SE, rightBottom);
    }
}

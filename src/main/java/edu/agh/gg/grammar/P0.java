package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import javafx.scene.input.ScrollEvent;

public class P0 implements Production {
    @Override
    public boolean applicableTo(Vertex vertex) {
        return vertex.getLabel().equals(VertexLabel.S);
    }

    @Override
    public void apply(Vertex vertex) {
        Vertex leftTop = Vertex.withoutParent(VertexLabel.E);
        Vertex leftBottom = Vertex.withoutParent(VertexLabel.E);
        Vertex rightTop = Vertex.withoutParent(VertexLabel.E);
        Vertex rightBottom = Vertex.withoutParent(VertexLabel.E);

        leftTop.connectToSibling(EdgeDirection.E, rightTop);
        leftTop.connectToSibling(EdgeDirection.S, leftBottom);

        rightBottom.connectToSibling(EdgeDirection.N, rightTop);
        rightBottom.connectToSibling(EdgeDirection.W, leftBottom);

        vertex.connectToSibling(EdgeDirection.NW, leftTop);
        vertex.connectToSibling(EdgeDirection.NE, rightTop);
        vertex.connectToSibling(EdgeDirection.SW, leftBottom);
        vertex.connectToSibling(EdgeDirection.SE, rightBottom);

        vertex.setLabel(VertexLabel.I);
    }
}

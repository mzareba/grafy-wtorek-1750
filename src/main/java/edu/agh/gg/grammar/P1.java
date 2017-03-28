package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;

public class P1 implements Production {
    @Override
    public boolean applicableTo(Vertex vertex) {
        return vertex.getLabel().equals(VertexLabel.I);
    }

    @Override
    public void apply(Vertex vertex) {
        Vertex leftTopI = Vertex.withoutParent(VertexLabel.I);
        Vertex leftBottomI = Vertex.withoutParent(VertexLabel.I);
        Vertex rightTopI = Vertex.withoutParent(VertexLabel.I);
        Vertex rightBottomI = Vertex.withoutParent(VertexLabel.I);

        Vertex leftTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex leftMiddleE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightMiddleE = Vertex.withoutParent(VertexLabel.E);
        Vertex leftBottomE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleBottomE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightBottomE = Vertex.withoutParent(VertexLabel.E);

        leftTopE.connectToSibling(EdgeDirection.E, middleTopE);
        leftTopE.connectToSibling(EdgeDirection.S, leftMiddleE);
        rightTopE.connectToSibling(EdgeDirection.W, middleTopE);
        rightTopE.connectToSibling(EdgeDirection.S, rightMiddleE);
        leftBottomE.connectToSibling(EdgeDirection.N, leftMiddleE);
        leftBottomE.connectToSibling(EdgeDirection.E, middleBottomE);
        rightBottomE.connectToSibling(EdgeDirection.W, middleBottomE);
        rightBottomE.connectToSibling(EdgeDirection.N, rightMiddleE);

        leftTopI.connectToSibling(EdgeDirection.NW, leftTopE);
        leftTopI.connectToSibling(EdgeDirection.NE, middleTopE);
        leftTopI.connectToSibling(EdgeDirection.SW, leftMiddleE);
        leftTopI.connectToSibling(EdgeDirection.SE, vertex);

        rightTopI.connectToSibling(EdgeDirection.NW, middleTopE);
        rightTopI.connectToSibling(EdgeDirection.NE, rightTopE);
        rightTopI.connectToSibling(EdgeDirection.SW, vertex);
        rightTopI.connectToSibling(EdgeDirection.SE, rightMiddleE);

        leftBottomI.connectToSibling(EdgeDirection.NW, leftMiddleE);
        leftBottomI.connectToSibling(EdgeDirection.NE, vertex);
        leftBottomI.connectToSibling(EdgeDirection.SW, leftBottomE);
        leftBottomI.connectToSibling(EdgeDirection.SE, middleBottomE);

        rightBottomI.connectToSibling(EdgeDirection.NW, vertex);
        rightBottomI.connectToSibling(EdgeDirection.NE, rightMiddleE);
        rightBottomI.connectToSibling(EdgeDirection.SW, middleBottomE);
        rightBottomI.connectToSibling(EdgeDirection.SE, rightBottomE);

        vertex.connectToSibling(EdgeDirection.W, leftMiddleE);
        vertex.connectToSibling(EdgeDirection.N, middleTopE);
        vertex.connectToSibling(EdgeDirection.E, rightMiddleE);
        vertex.connectToSibling(EdgeDirection.S, middleBottomE);

        vertex.setLabel(VertexLabel.E);
    }
}

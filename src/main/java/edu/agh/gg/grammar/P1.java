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
        Vertex leftTopI = vertex.createChild(EdgeDirection.SE);
        Vertex leftBottomI = vertex.createChild(EdgeDirection.NE);
        Vertex rightTopI = vertex.createChild(EdgeDirection.SW);
        Vertex rightBottomI = vertex.createChild(EdgeDirection.NW);
        
        leftTopI.setLabel(VertexLabel.I); 
        leftBottomI.setLabel(VertexLabel.I); 
        rightTopI.setLabel(VertexLabel.I); 
        rightBottomI.setLabel(VertexLabel.I); 


        Vertex leftTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex leftMiddleE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleMiddleE = Vertex.withoutParent(VertexLabel.E);

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
        leftTopI.connectToSibling(EdgeDirection.SE, middleMiddleE);

        rightTopI.connectToSibling(EdgeDirection.NW, middleTopE);
        rightTopI.connectToSibling(EdgeDirection.NE, rightTopE);
        rightTopI.connectToSibling(EdgeDirection.SW, middleMiddleE);
        rightTopI.connectToSibling(EdgeDirection.SE, rightMiddleE);

        leftBottomI.connectToSibling(EdgeDirection.NW, leftMiddleE);
        leftBottomI.connectToSibling(EdgeDirection.NE, middleMiddleE);
        leftBottomI.connectToSibling(EdgeDirection.SW, leftBottomE);
        leftBottomI.connectToSibling(EdgeDirection.SE, middleBottomE);

        rightBottomI.connectToSibling(EdgeDirection.NW, middleMiddleE);
        rightBottomI.connectToSibling(EdgeDirection.NE, rightMiddleE);
        rightBottomI.connectToSibling(EdgeDirection.SW, middleBottomE);
        rightBottomI.connectToSibling(EdgeDirection.SE, rightBottomE);

        middleMiddleE.connectToSibling(EdgeDirection.W, leftMiddleE);
        middleMiddleE.connectToSibling(EdgeDirection.N, middleTopE);
        middleMiddleE.connectToSibling(EdgeDirection.E, rightMiddleE);
        middleMiddleE.connectToSibling(EdgeDirection.S, middleBottomE);

        vertex.setLabel(VertexLabel.i);
    }
}

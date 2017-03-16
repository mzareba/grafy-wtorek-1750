package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import org.junit.Test;

import static edu.agh.gg.EdgeDirection.*;
import static org.junit.Assert.*;

public class P0Test {
    @Test
    public void shouldApplyToSNode() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.S);
        Production p0 = new P0();

        assertTrue(p0.applicableTo(disconnectedNode));
    }

    @Test
    public void shouldNotAllowEditingNonSNodes() throws Exception {
        Vertex node1 = Vertex.withoutParent(VertexLabel.I);
        Vertex node2 = Vertex.withoutParent(VertexLabel.E);
        node1.connectToSibling(N, node2);
        Production p0 = new P0();

        assertFalse(p0.applicableTo(node1));
        assertFalse(p0.applicableTo(node2));
    }

    @Test
    public void shouldNotCreateAnyChildren() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.S);
        Production p0 = new P0();

        p0.apply(disconnectedNode);

        assertEquals(0, disconnectedNode.getChildrenEdges().size());
    }

    @Test
    public void shouldCreateTheRequiredLevelStructureAndNothingElse() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.S);
        Production p1 = new P0();

        p1.apply(disconnectedNode);

        assertEquals(4, disconnectedNode.getSiblingsEdges().size());
        Vertex leftTop = disconnectedNode.getSibling(NW);
        Vertex leftBottom = disconnectedNode.getSibling(SW);
        Vertex rightBottom = disconnectedNode.getSibling(SE);
        Vertex rightTop = disconnectedNode.getSibling(NE);

        assertNotNull(leftTop);
        assertNotNull(rightTop);
        assertNotNull(rightBottom);
        assertNotNull(leftBottom);

        assertEquals(3, leftTop.getSiblingsEdges().size());
        assertEquals(3, rightTop.getSiblingsEdges().size());
        assertEquals(3, rightBottom.getSiblingsEdges().size());
        assertEquals(3, leftBottom.getSiblingsEdges().size());

        assertEquals(VertexLabel.E, leftTop.getLabel());
        assertEquals(VertexLabel.E, rightTop.getLabel());
        assertEquals(VertexLabel.E, rightBottom.getLabel());
        assertEquals(VertexLabel.E, leftBottom.getLabel());
        assertEquals(VertexLabel.I, disconnectedNode.getLabel());

        assertEquals(leftTop, rightTop.getSibling(W));
        assertEquals(leftTop, leftBottom.getSibling(N));

        assertEquals(rightBottom, rightTop.getSibling(S));
        assertEquals(rightBottom, leftBottom.getSibling(E));
    }

}
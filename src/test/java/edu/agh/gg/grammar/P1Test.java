package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;
import org.junit.Test;

import static edu.agh.gg.EdgeDirection.*;
import static org.junit.Assert.*;

public class P1Test {
    @Test
    public void shouldAllowApplicationToDisconnectedNode() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent();
        Production p1 = new P1();

        assertTrue(p1.applicableTo(disconnectedNode));
    }

    @Test
    public void shouldNotAllowConnectionToConnectedNode() throws Exception {
        Vertex node1 = Vertex.withoutParent();
        Vertex node2 = Vertex.withoutParent();
        node1.connectToSibling(N, node2);
        Production p1 = new P1();

        assertFalse(p1.applicableTo(node1));
        assertFalse(p1.applicableTo(node2));
    }

    @Test
    public void shouldNotCreateAnyChildren() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent();
        Production p1 = new P1();

        p1.apply(disconnectedNode);

        assertEquals(0, disconnectedNode.getChildrenEdges().size());
    }

    @Test
    public void shouldCreateTheRequiredLevelStructureAndNothingElse() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent();
        Production p1 = new P1();

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

        assertEquals(leftTop, rightTop.getSibling(W));
        assertEquals(leftTop, leftBottom.getSibling(N));

        assertEquals(rightBottom, rightTop.getSibling(S));
        assertEquals(rightBottom, leftBottom.getSibling(E));
    }

}
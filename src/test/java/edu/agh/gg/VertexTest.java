package edu.agh.gg;

import org.junit.Test;

import static edu.agh.gg.EdgeDirection.E;
import static org.junit.Assert.*;

public class VertexTest {
    @Test
    public void vertexCreatedWithoutParentShouldNotHaveParents() throws Exception {
        Vertex newVertex = Vertex.withoutParent(VertexLabel.E);

        assertNotNull(newVertex);
        assertNull(newVertex.getParent());
        assertNull(newVertex.getParentDirection());
    }

    @Test
    public void connectedSiblingsShouldKnowAboutEachOther() throws Exception {
        Vertex vertexA = Vertex.withoutParent(VertexLabel.E);
        Vertex vertexB = Vertex.withoutParent(VertexLabel.E);

        EdgeDirection direction = E;
        vertexA.connectToSibling(direction, vertexB);

        assertEquals(vertexB, vertexA.getSibling(direction));
        assertEquals(vertexA, vertexB.getSibling(direction.opposite()));
    }

    @Test
    public void childrenShouldKnwAboutParentAndParentsAboutChildren() throws Exception {
        Vertex parent = Vertex.withoutParent(VertexLabel.E);
        EdgeDirection direction = EdgeDirection.NW;

        Vertex child = parent.createChild(direction);

        assertNotNull(child);

        assertEquals(child, parent.getChild(direction));
        assertEquals(parent, child.getParent());
        assertEquals(direction.opposite(), child.getParentDirection());
    }

    @Test
    public void attributesShouldBeRetrievable() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.E);

        String name = "attribute";
        String value = "value";

        vertex.setAttribute(name, value);

        assertEquals(1, vertex.getAttributes().size());
        assertEquals(value, vertex.getAttribute(name));
    }

}
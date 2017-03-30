package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class P1Test {

    @Test
    public void shouldNotCreateAnyChildren() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.I);
        Production p1 = new P1();

        p1.apply(disconnectedNode);

        assertEquals(4, disconnectedNode.getChildrenEdges().size());
    }

    @Test
    public void sizesOfTheSiblingsShouldBe4or5P1() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.I);
        Production p1 = new P1();
        p1.apply(disconnectedNode);
        
        Vertex northWestChildren = disconnectedNode.getChild(EdgeDirection.NW);
        Vertex central = northWestChildren.getSibling(EdgeDirection.SE);       
        
        Vertex west = central.getSibling(EdgeDirection.W);
        Vertex southWest = central.getSibling(EdgeDirection.SW);
        Vertex north = central.getSibling(EdgeDirection.N);
        Vertex east = central.getSibling(EdgeDirection.E);
        Vertex south = central.getSibling(EdgeDirection.S);
        Vertex northWest = central.getSibling(EdgeDirection.NW);
        Vertex northEast = central.getSibling(EdgeDirection.NE);
        Vertex southEast = central.getSibling(EdgeDirection.SE);

        assertEquals(8, central.getSiblingsEdges().size());
        assertNotNull(west);
        assertNotNull(southWest);
        assertNotNull(north);
        assertNotNull(east);
        assertNotNull(south);
        assertNotNull(northWest);
        assertNotNull(northEast);
        assertNotNull(southEast);

        assertEquals(west.getSiblingsEdges().size(), 5);
        assertEquals(southWest.getSiblingsEdges().size(), 3);
        assertEquals(north.getSiblingsEdges().size(), 5);
        assertEquals(east.getSiblingsEdges().size(), 5);
        assertEquals(south.getSiblingsEdges().size(), 5);
        assertEquals(northWest.getSiblingsEdges().size(), 3);
        assertEquals(northEast.getSiblingsEdges().size(), 3);
        assertEquals(southEast.getSiblingsEdges().size(), 3);
    }

    @Test
    public void shouldHaveCorrectSiblingsDirections() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.I);
        Production p1 = new P1();
        p1.apply(disconnectedNode);
        
        Vertex northWestChildren = disconnectedNode.getChild(EdgeDirection.NW);
        Vertex central = northWestChildren.getSibling(EdgeDirection.SE);       
        
        Vertex west = central.getSibling(EdgeDirection.W);
        Vertex southWest = central.getSibling(EdgeDirection.SW);
        Vertex north = central.getSibling(EdgeDirection.N);
        Vertex east = central.getSibling(EdgeDirection.E);
        Vertex south = central.getSibling(EdgeDirection.S);
        Vertex northWest = central.getSibling(EdgeDirection.NW);
        Vertex northEast = central.getSibling(EdgeDirection.NE);
        Vertex southEast = central.getSibling(EdgeDirection.SE);

        ConcurrentMap<EdgeDirection, Vertex> westSiblings = west.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> southWestSiblings = southWest.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> northSiblings = north.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> eastSiblings = east.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> southSiblings = south.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> northWestSiblings = northWest.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> northEastSiblings = northEast.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> southEastSiblings = southEast.getSiblingsEdges();

        assertNotNull(westSiblings.get(EdgeDirection.N));
        assertNotNull(westSiblings.get(EdgeDirection.E));
        assertNotNull(westSiblings.get(EdgeDirection.S));
        assertNotNull(westSiblings.get(EdgeDirection.NE));
        assertNotNull(westSiblings.get(EdgeDirection.SE));

        assertNotNull(southWestSiblings.get(EdgeDirection.SW));
        assertNotNull(southWestSiblings.get(EdgeDirection.NW));
        assertNotNull(southWestSiblings.get(EdgeDirection.NE));
        assertNotNull(southWestSiblings.get(EdgeDirection.SE));

        assertNotNull(northSiblings.get(EdgeDirection.W));
        assertNotNull(northSiblings.get(EdgeDirection.SW));
        assertNotNull(northSiblings.get(EdgeDirection.E));
        assertNotNull(northSiblings.get(EdgeDirection.S));
        assertNotNull(northSiblings.get(EdgeDirection.SE));

        assertNotNull(eastSiblings.get(EdgeDirection.W));
        assertNotNull(eastSiblings.get(EdgeDirection.SW));
        assertNotNull(eastSiblings.get(EdgeDirection.N));
        assertNotNull(eastSiblings.get(EdgeDirection.S));
        assertNotNull(eastSiblings.get(EdgeDirection.NW));

        assertNotNull(southSiblings.get(EdgeDirection.W));
        assertNotNull(southSiblings.get(EdgeDirection.N));
        assertNotNull(southSiblings.get(EdgeDirection.E));
        assertNotNull(southSiblings.get(EdgeDirection.NW));
        assertNotNull(southSiblings.get(EdgeDirection.NE));

        assertNotNull(northWestSiblings.get(EdgeDirection.SW));
        assertNotNull(northWestSiblings.get(EdgeDirection.NW));
        assertNotNull(northWestSiblings.get(EdgeDirection.NE));
        assertNotNull(northWestSiblings.get(EdgeDirection.SE));

        assertNotNull(northEastSiblings.get(EdgeDirection.SW));
        assertNotNull(northEastSiblings.get(EdgeDirection.NW));
        assertNotNull(northEastSiblings.get(EdgeDirection.NE));
        assertNotNull(northEastSiblings.get(EdgeDirection.SE));

        assertNotNull(southEastSiblings.get(EdgeDirection.SW));
        assertNotNull(southEastSiblings.get(EdgeDirection.NW));
        assertNotNull(southEastSiblings.get(EdgeDirection.NE));
        assertNotNull(southEastSiblings.get(EdgeDirection.SE));
    }

    @Test
    public void shouldHaveCorrectLabels() throws Exception {
        Vertex disconnectedNode = Vertex.withoutParent(VertexLabel.I);
        Production p1 = new P1();
        p1.apply(disconnectedNode);
        
        Vertex northWestChildren = disconnectedNode.getChild(EdgeDirection.NW);
        Vertex central = northWestChildren.getSibling(EdgeDirection.SE);       
        
        Vertex west = central.getSibling(EdgeDirection.W);
        Vertex southWest = central.getSibling(EdgeDirection.SW);
        Vertex north = central.getSibling(EdgeDirection.N);
        Vertex east = central.getSibling(EdgeDirection.E);
        Vertex south = central.getSibling(EdgeDirection.S);
        Vertex northWest = central.getSibling(EdgeDirection.NW);
        Vertex northEast = central.getSibling(EdgeDirection.NE);
        Vertex southEast = central.getSibling(EdgeDirection.SE);

        assertEquals(VertexLabel.E, west.getLabel());
        assertEquals(VertexLabel.E, north.getLabel());
        assertEquals(VertexLabel.I, southWest.getLabel());
        assertEquals(VertexLabel.E, east.getLabel());
        assertEquals(VertexLabel.E, south.getLabel());
        assertEquals(VertexLabel.I, northWest.getLabel());
        assertEquals(VertexLabel.I, northEast.getLabel());
        assertEquals(VertexLabel.I, southEast.getLabel());
    }
}

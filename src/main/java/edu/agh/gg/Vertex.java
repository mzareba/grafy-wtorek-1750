package edu.agh.gg;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Vertex {
    private final Vertex parent;
    private final EdgeDirection parentDirection;
    private final ConcurrentMap<EdgeDirection, Vertex> childrenEdges = new ConcurrentHashMap<>();
    private final ConcurrentMap<EdgeDirection, Vertex> siblingsEdges = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, Object> attributes = new ConcurrentHashMap<>();
    private VertexLabel label;

    private Vertex(Vertex parent, EdgeDirection parentDirection, VertexLabel label) {
        this.parent = parent;
        this.parentDirection = parentDirection;
        this.label = label;
    }

    public static Vertex withoutParent(VertexLabel label) {
        return new Vertex(null, null, label);
    }

    public VertexLabel getLabel() {
        return label;
    }

    public void setLabel(VertexLabel label) {
        this.label = label;
    }

    public void connectToSibling(EdgeDirection direction, Vertex sibling) {
        siblingsEdges.put(direction, sibling);
        sibling.siblingsEdges.put(direction.opposite(), this);
    }

    public Vertex createChild(EdgeDirection direction) {
        Vertex child = new Vertex(this, direction.opposite(), label);
        childrenEdges.put(direction, child);
        return child;
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Vertex getSibling(EdgeDirection direction) {
        return siblingsEdges.get(direction);
    }

    public Vertex getChild(EdgeDirection direction) {
        return childrenEdges.get(direction);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public Vertex getParent() {
        return parent;
    }

    public EdgeDirection getParentDirection() {
        return parentDirection;
    }

    public ConcurrentMap<String, Object> getAttributes() {
        return attributes;
    }

    public ConcurrentMap<EdgeDirection, Vertex> getChildrenEdges() {
        return childrenEdges;
    }

    public ConcurrentMap<EdgeDirection, Vertex> getSiblingsEdges() {
        return siblingsEdges;
    }

}

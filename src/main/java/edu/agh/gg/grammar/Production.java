package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

public interface Production {
    boolean applicableTo(Vertex vertex);

    void apply(Vertex vertex);
}

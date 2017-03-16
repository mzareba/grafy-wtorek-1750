package edu.agh.gg;

import org.junit.Test;

import static edu.agh.gg.EdgeDirection.*;
import static org.junit.Assert.assertEquals;

public class EdgeDirectionTest {
    @Test
    public void oppositeDirectionsShouldBeRight() throws Exception {
        assertEquals(N, S.opposite());
        assertEquals(S, N.opposite());

        assertEquals(W, E.opposite());
        assertEquals(E, W.opposite());

        assertEquals(NW, SE.opposite());
        assertEquals(SE, NW.opposite());

        assertEquals(NE, SW.opposite());
        assertEquals(SW, NE.opposite());
    }
}
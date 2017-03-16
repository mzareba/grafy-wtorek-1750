# Graph structure

It's assumed that the processed graph has the following properties:

- each vertex belongs to a single level - that is for each vertex (let's call it A) it's possible to point out their:
    - parent - the vertex from a higher level to which A is connected, if exists
    - siblings - vertices located on the same level (either children of the parent's siblings or parentless vertices connected to A)
    - children - vertices whose parent is A
- information about edges is stored locally within the vertex from which it leaves
- each edge is labeled with a direction in which it points - one of N, NE, E, SE, S, SW, W, NW
- for each edge A -> B there is defined an edge B -> A, labeled with the opposite direction. This allows to freely traverse the graph.
- each vertex has a set of attributes which can be freely defined and accessed by the user

# Grammar

The grammar consists of productions, each of them has a set of two rules:

- applicability rules - a predicate which given a vertex determines if it can be applied to it
- modification rules - a method which, given a vertex to which it's applicable, modifies the graph using a well-defined algorithm.

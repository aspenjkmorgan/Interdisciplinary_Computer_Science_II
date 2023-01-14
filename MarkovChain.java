import java.util.ArrayList;
import java.util.List;

/*
To-Do:
-next(v) method to return a random neighbor of vertex v
-addTransition(v, w):   add a transition from state v to state w.
-toString():   return a string representation of this Markov chain.
 */

public class MarkovChain {

    // symbol table: key = string vertex, value = list of neighboring vertices
    private ST<String, List<String>> st;

    // number of edges
    private int E;

    /**
     * Initializes an empty graph with no vertices or edges.
     */
    public MarkovChain() {
        st = new ST<String, List<String>>();
    }

    /**
     * Initializes a graph from the specified file, using the specified delimiter.
     *
     * @param filename  the name of the file
     * @param delimiter the delimiter
     */
    public MarkovChain(String filename, String delimiter) {
        st = new ST<String, List<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addTransition(names[0], names[i]);
            }
        }
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return st.size();
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an exception if v is not a vertex
    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

    /**
     * Returns the degree of vertex v in this graph.
     *
     * @param v the vertex
     * @return the degree of {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public int degree(String v) {
        validateVertex(v);
        return st.get(v).size();
    }

    /**
     * Adds the edge v-w to this graph (if it is not already an edge).
     *
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     */
    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

    /*
      Adds a one way transition from vertex v to vertex w
     */
    public void addTransition(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);

        // omit st.get(w).add(v) so it doesn't go both ways??
    }

    /**
     * Adds vertex v to this graph (if it is not already a vertex).
     *
     * @param v the vertex
     */
    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new ArrayList<>());
    }


    /**
     * Returns the vertices in this graph.
     *
     * @return the set of vertices in this graph
     */
    public Iterable<String> vertices() {
        return st.keys();
    }

    /**
     * Returns the set of vertices adjacent to v in this graph.
     *
     * @param v the vertex
     * @return the set of vertices adjacent to vertex {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
    }

    /*
     * Return a random vertex adjacent to current vertex
     */
    public String next(String v) {
        // checks if vertex is illegal argument
        validateVertex(v);

        // get random number, multiply by length of list string
        int lg = st.get(v).size();
        int ran = (int) Math.floor(Math.random() * lg);

        // return the assigned vertex (one string)
        return st.get(v).get(ran);
    }

    /**
     * Returns true if v is a vertex in this graph.
     *
     * @param v the vertex
     * @return {@code true} if {@code v} is a vertex in this graph,
     * {@code false} otherwise
     */
    public boolean hasVertex(String v) {
        return st.contains(v);
    }

    /**
     * Returns true if v-w is an edge in this graph.
     *
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @return {@code true} if {@code v-w} is a vertex in this graph,
     * {@code false} otherwise
     * @throws IllegalArgumentException if either {@code v} or {@code w}
     *                                  is not a vertex in this graph
     */
    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        return st.get(v).contains(w);
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return string representation of this graph
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st) {
            s.append(v + ": ");
            for (String w : st.get(v)) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }

    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // create chain using "bbbabbabbbbaba"
        MarkovChain testChain = new MarkovChain();
        String testLine = "bbbabbabbbbaba";

        // get k and m as command line args
        int k = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // create vertices and edges using training data and k info
        String[] bit = new String[testLine.length()];
        for (int i = 0; i < testLine.length(); i++) {
            // remember periodic boundary condition
            if (i + (k - 1) < testLine.length()) {
                bit[i] = testLine.substring(i, i + k);
            } else {
                int buf = k - Math.abs((testLine.length() - i));
                bit[i] = testLine.substring(i).concat(testLine.substring(0, buf));
            }
        }

        for (int i = 0; i < bit.length - 1; i++) {
            testChain.addTransition(bit[i], bit[i + 1]);
        }

        // print toString version of test chain
        StdOut.println(testChain);

        // generate text
        String cur = bit[0];
        StdOut.print(cur);

        int calls = m - k;
        while (calls > 0) {
            StdOut.print(cur.substring(k - 1));
            cur = testChain.next(cur);

            calls--;
        }

    }

}

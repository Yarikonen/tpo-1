package org.example.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {
    Graph graph = new Graph(6);

    @Test
    public void testTree(){
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);

        Assertions.assertEquals("0 1 3 4 2 5 ",graph.DFS(0,"") );
    }
    @Test
    public void testDot(){
        Assertions.assertEquals("0 ", graph.DFS(0,""));
    }

    @Test
    public void testFromNonExistingVertex(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> graph.DFS(123,""),"Vertex with this number must be presented");
    }

    @Test
    public void testIfVertexLessThenZero(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> graph.DFS(-1,""),"Vertex with this number must be presented");

    }

    @Test
    public void testFullOrientedGraph(){
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(2,0);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(3,0);

        Assertions.assertEquals("0 1 2 3 ",graph.DFS(0,"") );
        graph.setVisited(new boolean[6]);
        Assertions.assertEquals("1 0 2 3 ",graph.DFS(1,"") );


    }


}
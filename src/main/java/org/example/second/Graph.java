package org.example.second;
import lombok.Setter;

import java.util.*;

class Graph {
    private LinkedList<Integer> adjLists[];
    @Setter
    private boolean visited[];

    // Создание графа
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // Алгоритм
    String DFS(int vertex, String path) {
        if(vertex<0 || vertex> visited.length){
            throw new IllegalArgumentException("Vertex with this number must be presented");
        }
        visited[vertex] = true;
        path = String.valueOf(vertex) +" ";
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                path += DFS(adj,path);
        }
        return path;
    }
}
package org.example.grokking_algorithms.chapter6;

import java.util.*;
import java.util.logging.Logger;

public class _01_breadth_first_search {

    private static final Logger logger = Logger.getLogger(_01_breadth_first_search.class.getName());

    // 6.1 Find the length of the shortest path
    // from start to finish.
    // ... 2

    // 6.2 Find the length of the shortest path
    // from “cab” to “bat.”
    // ... 2

    public static void queues() {
        Queue<String> q = new LinkedList<>();
//        Queue<String> q = new PriorityQueue<>();
        q.add("C");
        q.add("A");
        q.add("B");
        System.out.println(q.peek()); // get head
        System.out.println(q.poll()); // remove head
    }

    static class Tree<T> {
        private T value;
        private List<Tree<T>> children;

        public Tree(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public T getValue() {
            return this.value;
        }

        public List<Tree<T>> getChildren() {
            return this.children;
        }

        public static <T> Tree<T> of(T value) {
            return new Tree<>(value);
        }

        public Tree<T> addChild(T value) {
            Tree<T> child = new Tree<>(value);
            children.add(child);
            return child;
        }
    }

    static class Node<T> {
        private T value;
        private Set<Node<T>> neighbors;

        public Node(T value) {
            this.value = value;
            this.neighbors = new HashSet<>();
        }

        public T getValue() {
            return this.value;
        }

        public Set<Node<T>> getNeighbors() {
            return this.neighbors;
        }

        public void connect(Node<T> node) throws Exception {
            if (this == node) throw new IllegalAccessException("cant connect node to itself");
            this.neighbors.add(node);
            node.neighbors.add(this);
        }
    }


    public static <T> Optional<Tree<T>> searchTree(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
            logger.info("visited node with value " + currentNode.getValue().toString());
            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else queue.addAll(currentNode.getChildren());
        }
        return Optional.empty();
    }

    public static <T> Optional<Node<T>> searchGraph(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
        Node<T> current;
        Set<Node<T>> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            current = queue.remove();
            logger.info("visited node with value " + current.getValue().toString());
            if (!visited.contains(current)) {
                if (current.getValue().equals(value)) {
                    return Optional.of(current);
                } else {
                    visited.add(current);
                    queue.addAll(current.getNeighbors());
                }
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) throws Exception {

//        Tree<Integer> root = Tree.of(10);
//        Tree<Integer> rootFirstChild = root.addChild(2);
//        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
//        Tree<Integer> rootSecondChild = root.addChild(4);
//        searchTree(4, root);

        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);
        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);
        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);
        searchGraph(10, firstNeighborNeighbor);

    }

    // 6.3 For these three lists, mark whether each one is valid or invalid.
    // ... A (invalid), B (valid), C (invalid)

    // 6.4 Here’s a larger graph. Make a valid list for this graph.
    // ... wake up - brush teeth - exercise - eat breakfast - shower - get dressed - pack lunch

    // 6.5 Which of the following graphs are also trees?
    // ... A and C

}
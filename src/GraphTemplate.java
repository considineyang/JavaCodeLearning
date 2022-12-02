import java.util.*;

public class GraphTemplate {
    //Node
    public static class Node{
        public int Value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int Value){
            this.Value = Value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    //Edge
    public static class Edge{
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    //graph
    public static class Graph{
        public HashSet<Edge> edges;
        public HashMap<Integer, Node> nodes;

        public Graph(){
            edges = new HashSet<>();
            nodes = new HashMap<>();
        }
    }


    //CreateGraphMethod
    public static Graph createGraph(Integer[][] matrix){

        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node curFrom = graph.nodes.get(from);
            Node curTo = graph.nodes.get(to);
            Edge curEdge = new Edge(weight,curFrom,curTo);
            curFrom.edges.add(curEdge);
            curFrom.nexts.add(curTo);
            curFrom.out++;
            curTo.in++;
            graph.edges.add(curEdge);
        }
        return graph;
    }

    public static void graph_BFS(Node node){
        if (node == null){
          return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        Set<Node> nodeSet = new HashSet<>();
        nodeQueue.add(node);
        nodeSet.add(node);

        while(!nodeQueue.isEmpty()){
            Node curNode = nodeQueue.poll();
            System.out.println(curNode.Value);
            for (Node n:curNode.nexts
                 ) {
                if (!nodeSet.contains(n)){
                    nodeQueue.add(n);
                    nodeSet.add(n);
                }
            }
        }
    }

    public static void graph_DFS(Node head){
        if (head == null){
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Set<Node> nodeSet = new HashSet<>();
        nodeStack.push(head);
        nodeSet.add(head);
        while (!nodeStack.empty()){
            Node curNode = nodeStack.pop();
            System.out.println(curNode.Value);
            for (Node n:curNode.nexts
                 ) {
                if (!nodeSet.contains(n)){
                    nodeSet.add(n);
                    nodeStack.push(n);
                }
            }
        }

    }

    public static void dfs(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        stack.push(node);
        System.out.println(node.Value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next:cur.nexts
                 ) {
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.Value);
                    break;
                }
            }
        }
    }

    public static List<Node> sortedTopology(Graph graph){
            HashMap<Node, Integer> hashMap = new HashMap<>();
            Queue<Node> nodeQueue = new LinkedList<>();
            for (Node node:graph.nodes.values()
                 ) {
                hashMap.put(node,node.in);
                if (node.in == 0){
                    nodeQueue.add(node);
                }
            }
            List<Node> nodeList = new ArrayList<>();
            while (!nodeQueue.isEmpty()){
                Node cur = nodeQueue.poll();
                nodeList.add(cur);
                for (Node next: cur.nexts) {
                    hashMap.put(next, hashMap.get(next)-1);
                    if (hashMap.get(next) == 0){
                        nodeQueue.add(next);
                    }
                }
            }
            return nodeList;
    }

    //Kruskal
    public static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMSF(Graph graph){
        UnionFindSet.UnionFind unionFind = new UnionFindSet.UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge:graph.edges
             ) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from,edge.to)){
                result.add(edge);
                unionFind.Union(edge.from,edge.to);
            }
        }
        return result;
    }

    public static Set<Edge> primMSF(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> nodes = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node curNode: graph.nodes.values()
             ) {
            if (!nodes.contains(curNode)){
                nodes.add(curNode);
                for (Edge edge:curNode.edges
                     ) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    Edge curEdge = priorityQueue.poll();
                    Node toNode = curEdge.to;
                    if (!nodes.contains(toNode)){
                        result.add(curEdge);
                        nodes.add(toNode);
                        for (Edge e:toNode.edges
                             ) {
                            priorityQueue.add(e);
                        }
                    }
                }
            }
        }
        return result;
    }


//    //单元最短路径算法 Dijkstra 没有累加和权值为负数的环
//    public static HashMap<Node, Integer> dijkstra(Node head){
//        //从head出发到所有点的最小距离
//        //Key : 从head出发到key
//        //value ： 从head出发到达Key的最小距离
//        //如果在表中，没有T的记录，含义是从head出发到T这个点的距离为正无穷
//        HashMap<Node, Integer> distanceMap = new HashMap<>();
//        distanceMap.put(head, 0);
//        HashSet<Node> selectedNodes = new HashSet<>();
//        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
//        while (minNode != null){
//            int distance = distanceMap.get(minNode);
//            for (Edge e : minNode.edges) {
//                Node toNode = e.to;
//                if (!distanceMap.containsKey(toNode)){
//                    distanceMap.put(toNode,distance + e.weight);
//                }
//                distanceMap.put(e.to, Math.min(distanceMap.get(toNode),distance + e.weight));
//            }
//            selectedNodes.add(minNode);
//            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
//        }
//        return distanceMap;
//    }
//
//    public static Node getMinDistanceAndUnselectedNode(
//            HashMap<Node, Integer> distanceMap,
//            HashSet<Node> touchedNodes){
//        Node minNode = null;
//        int minDistance = Integer.MAX_VALUE;
//        for (Map.Entry<Node, Integer> entry: distanceMap.entrySet()){
//            Node node = entry.getKey();
//            int distance = entry.getValue();
//            if (!touchedNodes.contains(node) && distance < minDistance){
//                minNode = node;
//                minDistance = distance;
//            }
//        }
//        return minNode;
//    }


    public static HashMap<Node, Integer> dijkstra(Node head){
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getNode(distanceMap, selectedNodes);
        while (minNode != null){
            int distance = distanceMap.get(minNode);
            for (Edge edge: minNode.edges
                 ) {
                Node toNode = edge.to;
                if (!selectedNodes.contains(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(toNode,Math.min(distanceMap.get(toNode),distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    public static Node getNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNode){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry: distanceMap.entrySet()
             ) {
            Node curNode = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNode.contains(curNode) && distance < minDistance){
                minNode = curNode;
                minDistance = distance;
            }
        }
        return minNode;
    }



    public static void main(String[] args) {


        Integer[][] matrix = {{1,1,2},{1,2,1},{100,1,3},{100,3,1},{2,2,3},{2,3,2},{30,1,5},{30,5,1},{103,3,5},{103,5,3},{4,4,5},{4,5,4},{3,3,4},{3,4,3}};
        Graph graph = createGraph(matrix);
        Node node = graph.nodes.get(1);
        HashMap<Node, Integer> map = dijkstra(node);
        for (Map.Entry<Node, Integer> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey().Value+"  "+entry.getValue());
        }

//
//        Integer[][] matrix = {{0,1,2},{0,1,3},{0,1,4},{0,2,5},{0,2,6}};
//        Graph graph = createGraph(matrix);
//        Node node = graph.nodes.get(1);
//        graph_BFS(node);
//        System.out.println("----------------------------------------");
//        graph_DFS(node);
//        System.out.println("----------------------------------------");
//        dfs(node);
//        System.out.println("----------------------------------------");
//        Integer[][] matrix2 = {{0,1,2},{0,1,3},{0,2,4},{0,3,4},{0,4,5},{0,2,5}};
//        Graph graph1 = createGraph(matrix2);
//        for (Node item:sortedTopology(graph1)
//             ) {
//            System.out.print(item.Value+" ");
//        }


//        Integer[][] matrix = {{1,1,2},{2,2,3},{5,1,4},{100,4,3},{120,1,3},{130,2,4}};
//        Graph graph = createGraph(matrix);
//        Set<Edge> edgeSet = kruskalMSF(graph);
//        for (Edge edge:edgeSet
//             ) {
//            System.out.println(edge.weight);
//        }
//        System.out.println("----------------------------------------");
//        Set<Edge> edgeSet2 = primMSF(graph);
//        for (Edge edge:edgeSet2
//        ) {
//            System.out.println(edge.weight);
//        }
    }

}

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

public class UnionFindSet {
    public static class UnionFind{
        private HashMap<GraphTemplate.Node, GraphTemplate.Node> fatherMap;
        private HashMap<GraphTemplate.Node, Integer> sizeMap;

        public UnionFind(){
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<GraphTemplate.Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (GraphTemplate.Node node:nodes
                 ) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private GraphTemplate.Node findFather(GraphTemplate.Node node){
            Stack<GraphTemplate.Node> nodeStack = new Stack<>();
            while (node != fatherMap.get(node)){
                nodeStack.add(node);
                node = fatherMap.get(node);
            }
            while (!nodeStack.isEmpty()){
                fatherMap.put(nodeStack.pop(),node);
            }
            return node;
        }

        public boolean isSameSet(GraphTemplate.Node a, GraphTemplate.Node b){
            return findFather(a) == findFather(b);
        }

        public void Union(GraphTemplate.Node a, GraphTemplate.Node b){
            if (a == null || b == null){
                return;
            }
            GraphTemplate.Node fatherOfA = findFather(a);
            GraphTemplate.Node fatherOfB = findFather(b);
            if (fatherOfA != fatherOfB){
                int aSetSize = sizeMap.get(fatherOfA);
                int bSetSize = sizeMap.get(fatherOfB);
                if (aSetSize <= bSetSize){
                    fatherMap.put(fatherOfA,fatherOfB);
                    sizeMap.put(fatherOfB,aSetSize+bSetSize);
                    sizeMap.remove(fatherOfA);
                }else {
                    fatherMap.put(fatherOfB,fatherOfA);
                    sizeMap.put(fatherOfA,aSetSize+bSetSize);
                    sizeMap.remove(fatherOfB);
                }
            }
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();
        Collection<GraphTemplate.Node> nodes = new ArrayList<>();
        nodes.add(new GraphTemplate.Node(11));
        nodes.add(new GraphTemplate.Node(12));
        nodes.add(new GraphTemplate.Node(13));
        nodes.add(new GraphTemplate.Node(10));
        unionFind.makeSets(nodes);
        for (GraphTemplate.Node node:unionFind.fatherMap.values()
             ) {
            System.out.println(node.Value);
        }
    }
}

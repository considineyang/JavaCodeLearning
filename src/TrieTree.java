
public class TrieTree {

    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }


    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word){
            if (word == null){
                return;
            }
            TrieNode node = root;
            char[] path = word.toCharArray();
            int position = 0;
            node.pass++;
            for (int i = 0; i < path.length; i++) {
                position = path[i] - 'a';
                if (node.nexts[position] == null){
                    node.nexts[position] = new TrieNode();
                }
                node = node.nexts[position];
                node.pass++;
            }
            node.end++;
        }


        //删除这个字符串
        public void delete(String word){
            if (search(word) != 0){
                TrieNode node = root;
                char[] path = word.toCharArray();
                int index = 0;
                node.pass--;
                for (int i = 0; i < path.length; i++) {
                    index = path[i] - 'a';
                    if (--node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        //word 这个单词之前加入过几次
        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] path = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < path.length; i++) {
                index = path[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] path = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < path.length; i++) {
                index = path[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }




    }
}

/**Given two words (start and end) and a dictionary, find all shortest transformation sequences from start to end,
 * such that:
 * 1. only one letter is changed at a time
 * 2. each intermediate word must exist in the dictionary
 */

public class Solution {
    // node class for a DAG
    public class Node {
        public String word;
        public int level;
        public List<Node> next;
        public Node(String w, int l) { 
            word = w; 
            level = l;
            next = new ArrayList<Node>();
        }
    }
    
    boolean found;
    ArrayList<ArrayList<String>> ladders;
    Node nStart, nEnd;
    Map<String, Node> hm;
    int level, N;
    Set<String> dict;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // initialize class variables
        ladders = new ArrayList<ArrayList<String>>();
        found = false;
        level = 0;
        N = start.length();
        nStart = new Node(start, -1);
        nEnd = new Node(end, level);
        hm = new HashMap<String, Node>();
        this.dict = dict;
        
        // use BFS to build a DAG
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(nEnd);
        buildGraph(queue);
        
        // use DFS to get ladders
        ArrayList<String> ladder = new ArrayList<String>();
        getLadders(nStart, ladder);
        
        return ladders;
    }
    
    void buildGraph(Queue<Node> queue) {
        level++;
        
        // stop when either queue is empty or target if found
        if (queue.isEmpty() || found) return;
        
        Queue<Node> mQueue = new LinkedList<Node>();
        
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            char[] arr = currNode.word.toCharArray();
            
            // for each entry of arr, we try all possible changes
            for (int i = 0; i < N; i++) {
                char currChar = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != currChar) {
                        arr[i] = c;
                        String currStr = String.valueOf(arr);
                        if (dict.contains(currStr)) {
                            // for new word, create a new node
                            if (!hm.containsKey(currStr) ) {
                                Node aNode = new Node(currStr, level);
                                aNode.next.add(currNode);
                                mQueue.add(aNode);
                                hm.put(currStr, aNode);
                                if (currStr.equals(nStart.word)) {
                                    nStart = aNode;
                                    found = true;
                                }
                            }
                            // for visited word, we'll use it only if it is in the same level
                            else {
                                Node temp = hm.get(currStr);
                                if (temp.level == level) {
                                    temp.next.add(currNode);
                                }
                            }
                        }
                    }
                }
                arr[i] = currChar;
            }
        }
        buildGraph(mQueue);
    }
    
    void getLadders(Node node, ArrayList<String> ladder) {
        if (node == nEnd) {
            ladder.add(nEnd.word);
            ladders.add(ladder);
        } else {
            for (Node n : node.next) {
                ArrayList<String> aLadder = new ArrayList<String>();
                aLadder.addAll(ladder);
                aLadder.add(node.word);
                getLadders(n, aLadder);
            }
        }
        return;
    }
    
}

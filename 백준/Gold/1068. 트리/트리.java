import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int count = 0;
    public static int rootNode = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> treeList = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int nextInt = Integer.parseInt(st.nextToken());
            if (nextInt == -1) {
                rootNode = i;
            }
            if (!treeList.containsKey(nextInt)) {
                treeList.put(nextInt, new ArrayList<>());
                treeList.get(nextInt).add(i);
            } else {
                treeList.get(nextInt).add(i);
            }
        }

        int targetNum = Integer.parseInt(br.readLine());

        if (targetNum == rootNode) {
            System.out.println(0);
            return;
        }

        for (Integer key : treeList.keySet()) {
            if (treeList.get(key).contains(targetNum)) {
                treeList.get(key).remove(Integer.valueOf(targetNum));
            }
        }

        if (treeList.containsKey(targetNum)) {
            Map<Integer, ArrayList<Integer>> newTreeList = deleteNode(targetNum, treeList);
        } 
        
        findLeaf(treeList);
        System.out.println(count);
    }



    public static Map<Integer,ArrayList<Integer>> deleteNode (int targetNum, Map<Integer, ArrayList<Integer>> treeList) {
        List<Integer> list = treeList.get(targetNum);
        if (list != null) {
            for (Integer i : list) {
                if (treeList.containsKey(i)) {
                    deleteNode(i, treeList);
                }
            }
        }
        treeList.remove(targetNum);
        return treeList;
    }

    public static void findLeaf(Map<Integer, ArrayList<Integer>> treeList) {
        treeList.forEach((s, list) -> {
            if (list.isEmpty()) {
                count++;
            } else {
                for (Integer i : list) {

                    if (!treeList.containsKey(i)) {
                        count++;
                    }
                }
            }
        });
    }
}

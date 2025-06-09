import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of words:");
        int n=Integer.parseInt(sc.nextLine());
        String[] words=new String[n];

        System.out.println("Enter words in alien dictionary order:");
        for (int i=0;i<n;i++) {
            words[i]=sc.nextLine();
        }

        String order=alienOrder(words);
        if (order.equals("")) {
            System.out.println("Invalid order or cycle detected.");
        } else {
            System.out.println("Alien character order: " + order);
        }
    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i=0;i<words.length-1;i++) {
            String w1=words[i], w2=words[i + 1];
            int minLen=Math.min(w1.length(), w2.length());
            boolean found=false;

            for (int j=0;j<minLen;j++) {
                char c1=w1.charAt(j), c2=w2.charAt(j);
                if (c1!=c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    found=true;
                    break;
                }
            }

            if (!found && w1.length() > w2.length()) {
                return ""; 
            }
        }

        Queue<Character> queue=new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c)==0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c=queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return sb.length() == inDegree.size() ? sb.toString() : "";
    }
}
package depthsearch;

import java.util.*;

public class wordladder2 {
    public static class Solution {
        public List<List<String>> findLadders(String start, String end,
                                              Set<String> dict) {
            List<List<String>> ladders = new ArrayList<List<String>>();
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            Map<String, Integer> distance = new HashMap<String, Integer>();

            dict.add(start);
            dict.add(end);

            bfs(map, distance, end, start, dict);

            List<String> path = new ArrayList<String>();

            dfs(ladders, path, start, end, distance, map);

            return ladders;
        }

        void dfs(List<List<String>> ladders, List<String> path, String crt,
                 String end, Map<String, Integer> distance,
                 Map<String, List<String>> map) {
            path.add(crt);
            if (crt.equals(end)) {
                ladders.add(new ArrayList<String>(path));
            } else {
                for (String next : map.get(crt)) {
                    if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
                        dfs(ladders, path, next, end, distance, map);
                    }
                }
            }
            path.remove(path.size() - 1);
        }

        void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
                 String start, String end, Set<String> dict) {
            Queue<String> q = new LinkedList<String>();
            q.offer(start);
            distance.put(start, 0);
            for (String s : dict) {
                map.put(s, new ArrayList<String>());
            }

            while (!q.isEmpty()) {
                String crt = q.poll();

                List<String> nextList = expand(crt, dict);
                for (String next : nextList) {
                    map.get(crt).add(next);
                    if (!distance.containsKey(next)) {
                        distance.put(next, distance.get(crt) + 1);
                        q.offer(next);
                    }
                }
            }
        }

        List<String> expand(String crt, Set<String> dict) {
            List<String> expansion = new ArrayList<String>();

            for (int i = 0; i < crt.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != crt.charAt(i)) {
                        String expanded = crt.substring(0, i) + ch
                                + crt.substring(i + 1);
                        if (dict.contains(expanded)) {
                            expansion.add(expanded);
                        }
                    }
                }
            }

            return expansion;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        HashSet<String> hashSet = new HashSet<>();
        //["hot","dot","dog","lot","log"]
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");
        List<List<String>> ladders = solution.findLadders("hit", "cog", new HashSet<>(hashSet));
        System.out.println(ladders);
    }
}

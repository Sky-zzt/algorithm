package depthsearch;

import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        set.add(start);

        int length = 1;
        while (!queue.isEmpty()) {            //开始bfs
            length++;
            int size = queue.size();        //当前步数的队列大小
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {    //得到新单词
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    set.add(nextWord);
                    queue.offer(nextWord);            //存入队列继续搜索
                }
            }
        }
        return 0;
    }

    private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private static ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {                    //枚举当前替换字母
            for (int i = 0; i < word.length(); i++) {        //枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {        //如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        HashSet<String> strings = new HashSet<>();
        strings.add("hot");
        strings.add("dot");
        strings.add("dog");
        strings.add("lot");
        strings.add("log");
        wordLadder.ladderLength("hit", "cog", strings);

    }

    public int ladderLength1(String start, String end, Set<String> dict) {

        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);

        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        int length = 1;
        set.add(start);
        queue.add(start);
        while (queue != null) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                ArrayList<String> list = getNextWords1(poll, dict);
                for (String s : list) {
                    if (s.equals(end)) {
                        return length;
                    }
                    if (!set.contains(s)) {
                        set.add(s);
                        queue.add(s);
                    }
                }

            }
        }
        return 0;
    }

    private static ArrayList<String> getNextWords1(String word, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c==word.charAt(i)){
                    continue;
                }
                String replace = replace1(word, i, c);
                if (dict.contains(replace)){
                    list.add(replace);
                }
            }
        }
        return list;
    }
    private static String replace1(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

}

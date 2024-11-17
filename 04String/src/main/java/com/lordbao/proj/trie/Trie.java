package com.lordbao.proj.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trie {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();

        // write your code here
        //初始话根节点
        HashMap<Character,Integer> map0= new HashMap<>();
        trie.add(map0);
        int nodeNum=1;//记录node的编号


        for(String pat : patterns){
            Map<Character,Integer> tempMap=map0;
            for(int i=0;i<pat.length();i++){
                if(!tempMap.containsKey(pat.charAt(i))){
                    tempMap.put(pat.charAt(i),nodeNum);
                    nodeNum++;
                    HashMap<Character,Integer> newMap = new HashMap<>();
                    trie.add(newMap);
                    tempMap=newMap;
                }else {
                    tempMap=trie.get(tempMap.get(pat.charAt(i)));
                }
            }
        }
        return trie;
    }

    static public void main(String[] args) throws IOException {
        new Trie().run();
    }

    public void print(List<Map<Character, Integer>> trie) {
        for (int i = 0; i < trie.size(); ++i) {
            Map<Character, Integer> node = trie.get(i);
            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
            }
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print(trie);
    }
}

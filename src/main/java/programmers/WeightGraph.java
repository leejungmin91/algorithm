package programmers;

import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightGraph {

    static List<List<Edge>> list = new ArrayList<>();
    static final int INF = 2001;
    static String path = "0";
    static Map<String,Boolean> overVisited;
    static boolean[] visited;
    static List<Integer> answerList = new ArrayList<>();
    static int K;
    static int N;
    static int sum;

    public static void main(String[] args){

        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};

        N = 6;
        K = 17;

        visited = new boolean[N];
        overVisited = new HashMap<>();

        for(int i=0; i<N; i++){
            list.add(new ArrayList<>());
        }

        for(int[] road : roads){
            list.get(road[0]).add(new Edge(road[2], road[1]));
            list.get(road[1]).add(new Edge(road[2], road[0]));
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<list.get(i).size(); j++){
                System.out.println("startNode :: "+i+" / "+list.get(i).get(j).toString());
            }
        }

        dfs(0, 0);
    }

    static void dfs(int curNode, int curDist){
        // 0->1 visited[0] true
        // 1->2 visited[1] true
        System.out.println("curNode :: "+curNode);
        System.out.println("curDist :: "+curDist);
        //System.out.println("path :: "+path);

        /*if(sum >= K){
            overVisited.put(path, true);
            if(sum == K) answerList.add(curNode);
        }*/

        visited[curNode] = true;

        for(int i=0; i<list.get(curNode).size(); i++){
            int nextNode = list.get(curNode).get(i).node;
            int weight = list.get(curNode).get(i).weight;

            if(!visited[nextNode] && curDist < 17){
                dfs(nextNode, curDist+weight);
            }
        }

        /*for(int i=0; i<list.get(curNode).size(); i++){
            // curNode 가 0 인경우 1또는 4로 갈 수 있다.
            int nextNode = list.get(curNode).get(i).node;
            int weight = list.get(curNode).get(i).weight;
            sum += weight;
            if(!overVisited.containsKey(path)) {
                path += String.valueOf(nextNode);
                dfs(nextNode);
            }
        }*/

        path = "0";
        visited[curNode] = false;
    }

}

class Edge {
    int weight;
    int node;

    Edge(int weight, int node){
        this.weight = weight;
        this.node = node;
    }

    public String toString(){
        return "weight :: "+this.weight+" / Node :: "+this.node;
    }
}

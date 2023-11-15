package programmers;

import lombok.ToString;

import java.io.IOException;
import java.util.*;

public class WeightGraph {

    static List<List<Edge>> list = new ArrayList<>();
    static String path = "0";
    static Set<String> visited;
    static List<Integer> answerList = new ArrayList<>();
    static int K;
    static int N;

    public static void main(String[] args){

        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};

        N = 6;
        K = 17;

        visited = new HashSet<>();

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

        answerList.forEach(ans-> System.out.println("answer ==> "+ans));
    }

    static String path2 = "0";

    static void dfs(int curNode, int curDist){

        for(int i=0; i<list.get(curNode).size(); i++){
            int nextNode = list.get(curNode).get(i).node;
            int weight = list.get(curNode).get(i).weight;

            if(curDist+weight >= 17){
                // 17보다 크거나 같으면 더이상 갈 필요가 없음.
                // 다음노드는 i+1로 가면 됨.
                if(curDist+weight == 17){
                    System.out.println("경로 !!!! :: "+path2);
                    answerList.add(nextNode);
                }
                System.out.println("경로 :: "+path2);
            }else{
                path2 += nextNode;
                dfs(nextNode, curDist+weight);
            }
            /*if(visited.contains(nextPath)){
                continue;
            }*/

            //path = nextPath;

            /*if(curDist+weight < 17){
                dfs(nextNode, curDist+weight);
            }else{
                if(curDist+weight == 17) answerList.add(nextNode);
                visited.add(path);
                path = "0";
                dfs(0,0);
            }*/
        }
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

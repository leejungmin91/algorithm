package programmers;

import lombok.ToString;

import java.io.IOException;
import java.util.*;

public class WeightGraph {

    static List<List<Edge>> list = new ArrayList<>();
    static Stack<Edge> stack = new Stack<>();
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

        // 처음 노드 stack에 초기화
        stack.add(new Edge(0,0));

        dfs(0);

        answerList.forEach(ans-> System.out.println("answer ==> "+ans));
    }

    static String path2 = "0";

    static void dfs(int curNode){

        System.out.println("현재 Node ==> "+curNode);
        int dist = stack.stream().mapToInt(s-> s.weight).sum();
        System.out.println("현재 현재까지 이동거리 ==> "+dist);

        for(int i=0; i<list.get(curNode).size(); i++){
            int nextNode = list.get(curNode).get(i).node;
            int weight = list.get(curNode).get(i).weight;

            if(dist >= 17){
                // 17보다 크거나 같으면 더이상 갈 필요가 없음.
                // 다음노드는 i+1로 가면 됨.
                if(dist == 17){
                    answerList.add(nextNode);
                }

                stack.pop();

                continue;
            }

            // stack 에 다음 노드를 넣음.
            stack.push(list.get(nextNode).get(i));
            // 다음노드를 호출
            dfs(nextNode);
        }

        // stack에 마지막값을 돌음..
        // stack 한번 pop
        stack.pop();

        // 현재노드와 이어진 다음 노드가 있는가? (이미 방문했으면 그 다음노드)
        Edge peekEdge = stack.peek();
        List<Edge> linkedCurEdge = list.get(peekEdge.node);

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

class Singleton{
    private Singleton(){

    }
}
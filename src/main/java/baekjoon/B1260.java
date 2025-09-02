package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class B1260 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] visited;
    // 1 ㅡ 2
    // |  \ |
    // 3 ㅡ 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V= Integer.parseInt(st.nextToken());

        visited = new int[N+2];

        for (int i = 0; i <= N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(List<Integer> nodes : graph) {
            Collections.sort(nodes);
        }
        dfs(V);
        System.out.println();
        visited = new int[N+2];
        bfs(V);
    }

    public static void dfs(int node) {
        if(visited[node] == 1) return;
        visited[node] = 1;
        System.out.print(node+" ");

        for(int v : graph.get(node)) {
            if(visited[v] == 0) dfs(v);
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
            visited[cur] = 1;
            for(int v : graph.get(cur)) {
                if(visited[v] == 0) {
                    visited[v] = 1;
                    queue.add(v);
                }
            }
        }
    }
}

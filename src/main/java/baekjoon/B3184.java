package baekjoon;

import java.io.*;
import java.util.*;

public class B3184 {

    private static char[][] chessList;
    private static char[][] tempChessList;
    private static List<char[][]> chessBoardList = new ArrayList<>();
    private static List<String[]> inputList = new ArrayList<>();
    private static int cnt;
    private static List<Integer> cntList = new ArrayList<>();
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
            8 8
            WBWBWBWB
            BWBWBWBW
            WBWBWBWB
            BWBBBWBW
            WBWBWBWB
            BWBWBWBW
            WBWBWBWB
            BWBWBWBW
         */
        // N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chessList = new char[N][M];
        tempChessList = new char[N][M];

        // 가로로 한칸씩 증가하는경우
        // 세로로 한칸씩 증가하는경우
        // 가로세로 한칸씩 증가하는경우
        // 체스판을 여러개를 다 쪼개서 가지고있어보자.

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] board = st.nextToken().split("");
            inputList.add(board);
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] board = st.nextToken().split("");
            for (int j = 0; j < board.length; j++) { //10
                // 가로로 한칸씩 늘림
                chessList[i][j] = board[j].charAt(0);
                tempChessList[i][j] = board[j].charAt(0);
            }
        }

        // 가로 세로+1씩 증가하면서 체스판 넣기
        for(int i = 0; i < M-7; i++) {
            for (int j = 0; j < N-7; j++) {
                printChess(i,j);
            }
        }

        System.out.println(cnt);

        /*System.out.println(Arrays.deepToString(chessList));
        printChess(0, 0);
        System.out.println(Arrays.deepToString(tempChessList));
        int case1 = cnt;
        System.out.println("case1 ==> "+case1);
        cnt = 0;
        tempChessList = chessList;
        tempChessList[0][0] = tempChessList[0][0] == 'B' ? 'W' : 'B';
        printChess(0, 0);
        System.out.println(Arrays.deepToString(tempChessList));
        int case2 = cnt;
        System.out.println("case2 ==> "+case2);
        System.out.println(Math.min(case1, case2));*/

    }

    private static void printChess(int x, int y) {
        // x,y 인경우 아래 오른쪽을 검사함.
        // 시작부터 바꾸면 더 줄어들 수 도 있음. 고려가 필요함.
        // 0 0 W
        if(x+1 < 8){
            // 1 < 8
            // 색상이 같으면 바꿔줘야함.
            if(tempChessList[x][y] == tempChessList[x+1][y]) {
                cnt++;
                tempChessList[x+1][y] = (tempChessList[x][y] == 'B' ? 'W' : 'B');
            }
            printChess(x+1, y);
        }
        if(y+1 < 8) {
            if(tempChessList[x][y] == tempChessList[x][y+1]) {
                cnt++;
                tempChessList[x][y+1] = (tempChessList[x][y] == 'B' ? 'W' : 'B');
            }
            printChess(x, y+1);
        }
    }

}

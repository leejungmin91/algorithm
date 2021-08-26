import java.util.*;

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String str = Integer.toBinaryString(N);

        List<Integer> rangeList = new ArrayList<Integer>();

        List<Integer> list = findIndex(str);

        if(list.size() < 2) return 0;

        for(int i=0; i<list.size(); i++){
            if(i+1 == list.size()) break;
            rangeList.add(list.get(i+1) - list.get(i) - 1);
        }

        return (int)Collections.max(rangeList);        
    }

    public List<Integer> findIndex(String str){
        List<Integer> list = new ArrayList<Integer>();
        int pos = str.indexOf("1");
        while(pos != -1){
            list.add(pos);
            pos = str.indexOf("1",pos+1);
        }
        return list;
    }
}

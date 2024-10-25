package numplay;

import java.util.ArrayList;
import java.util.List;

public class getRecords {
    private List<Integer> results = new ArrayList<>(); // n번째 게임의 시도 횟수 저장

    public void setResults( int attempts){
        results.add(attempts);
    }

    public void getResult() {
        System.out.println("< 게임 기록 보기 >");
        System.out.println(this.results.size());

        for (int i = 0; i < this.results.size(); i++){
            System.out.println( (i+1) + "번째 게임 : 시도 횟수 - "+ this.results.get(i));
        }
    }

    public void resetResults(){
        this.results.clear();
    }
}

package numplay;

import java.util.ArrayList;
import java.util.List;

public class getRecords {
    private List<Integer> results = new ArrayList<>(); // n번째 게임의 시도 횟수 저장

    //결과값을 리스트에 저장해주기 위해서 있는 세터 메소드
    public void setResults( int attempts){
        results.add(attempts);
    }

    //다른 클라스에서 리스트에 저장된 결과값들 확인 할 때 사용
    public void getResult() {
        System.out.println("< 게임 기록 보기 >");
        System.out.println(this.results.size());

        for (int i = 0; i < this.results.size(); i++){
            System.out.println( (i+1) + "번째 게임 : 시도 횟수 - "+ this.results.get(i));
        }
    }

    // 다른 클래스에서 리스트 값을 초기화 하고 싶을 때 사용
    public void resetResults(){
        this.results.clear();
    }
}

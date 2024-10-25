package numplay;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private List<Integer> answer = new ArrayList<>(); //정답 저장 리스트
    int level=3;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() { //게임 시작과 동시에 정답 생성
        System.out.println("< 게임을 시작합니다 >");
        System.out.println("숫자를 입력하세요");

        Random rand = new Random();

        while (answer.size() < 3) {
            int number = rand.nextInt(9) + 1;
            if (!answer.contains(number) ) {
                answer.add(number);
            }
        }

    }

    public void levelGame(int levelInput) { // 레벨 변경 원할시, 받은 값으로 레벨 변경
        System.out.println("< 게임을 시작합니다 >");

        Random rand = new Random();

        level=levelInput;
        while (answer.size() < levelInput) {
            int number = rand.nextInt(9) + 1;
            if(!answer.contains(number)){
                answer.add(number);
            }
        }

    }


    public int play() { //게임을 플레이
        Scanner scan = new Scanner(System.in);
        int attempts = 0;
        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요");
            String input = scan.next();
            // 2. 올바른 입력값을 받았는지 검증
            if ( validateInput(input) != true){
                System.out.println("올바르지 않은 입력값입니다");
                continue;
            }
            // 3. 게임 진행횟수 증가
            attempts++;
            // 4. 스트라이크 개수 계산
            int strikeCount = countStrike(input);
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (countStrike(input) == level) {
                System.out.println("정답입니다!");
                break;
            }
            // 6. 볼 개수 계산
            int ballCount = countBall(input);
            // 7. 힌트 출력
            BaseballGameDisplay display = new BaseballGameDisplay();
            display.displayHint(strikeCount, ballCount);
            }
        return attempts;
    }

    // 받아온 값이 올바른 값인지 확인
    private boolean validateInput(String input) {
        if (input.length() != level || !input.matches("\\d{" + level + "}")) {
            return false;
        }
        for (int i=0; i<input.length(); i++){
            for (int j=0; j<input.length(); j++){
                if (input.charAt(i) == input.charAt(j) && input.charAt(i)== '0'){
                    return false;
                }
            }
        }
        return true;

    }

    //받아온 값이 스트라이크인지 확인
    private int countStrike(String input) {
        int strike=0;
        for (int i=0; i < level; i++ ) {
            for (int j=0; j < level; j++ ) {
                if ( (input.charAt(i)) - '0'==(answer.get(j) ) && (i==j) ){
                    strike++;
                }
            }
        }
        return strike;
    }

    //받아온 값이 볼인지 확인
    private int countBall(String input) {
        int ball=0;
        for (int i=0; i < level; i++ ) {
            for (int j=0; j < level; j++ ) {
                if ( (input.charAt(i) - '0' == answer.get(j) ) && (i !=j) ){
                    ball++;
                }
            }
        }
        return ball;
    }
}

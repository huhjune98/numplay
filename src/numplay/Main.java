package numplay;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getRecords records = new getRecords();

        while ( true ){
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정하기 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            BaseballGame game = new BaseballGame();
            String input = scanner.nextLine();

            if (input.equals("1") ) { // 게임 시작하기
                records.setResults(game.play());
                continue;
            } else if (input.equals("2")) { // 게임 기록 보기
                records.getResult();
                continue;
            } else if (input.equals("3")) { // 게임 종료하기
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                System.out.println();
                records.resetResults();
                return;
            } else if (input.equals("0")) { //게임 나이도 조정 및 시작 (3,4,5 만 가능)
                System.out.println("설정 하고자 하는 자리수를 입력하세요.");
                String levelInput = scanner.nextLine();
                int levelInt = Integer.parseInt(levelInput);
                if (levelInt == 3 || levelInt == 4 || levelInt == 5) {
                    game.levelGame( levelInt);
                    records.setResults(game.play());
                } else {
                    System.out.println("잘못된 난이도 입니다. 3,4,5 중에서 고르세요");
                }
                continue;
            }
            else{
                System.out.println("올바르지 않은 입력입니다. 다시 선택해주세요");
            }
        }
    }
}
package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserGenerate {
    public List<Integer> user = new ArrayList<>();

    public UserGenerate() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (CheckInput(input)) {
            List<Integer> user = StringToList(input);
        }
        throw new IllegalArgumentException("잘못된 입력");
    }

    private static List<Integer> StringToList(String input) {
        List<Integer> user = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            user.add(input.charAt(i) - '0');
        }
        return user;
    }

    private static boolean CheckInput(String input) {
        if (isSize3(input) && isNotDuplicate(input) && isNumber(input) && isNotContain0(input)) {
            return true;
        }
        return false;
    }

    private static boolean isSize3(String input) {
        if (input.length() == 3) {
            return true;
        }
        return false;
    }

    private static boolean isNotDuplicate(String input) {
        String checkinput = "";
        for (char charinput : input.toCharArray()) {
            if (checkinput.contains(String.valueOf(charinput))) {
                return false;
            }
            checkinput += String.valueOf(charinput);
        }
        return true;
    }

    private static boolean isNumber(String input) {
        for (char charinput : input.toCharArray()) {
            if (Character.isDigit(charinput) == false) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotContain0(String input) {
        if (input.contains("0")) {
            return false;
        }
        return true;
    }


}
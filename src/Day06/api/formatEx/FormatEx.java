package Day06.api.formatEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
format(형식) 클래스는 숫자 또는 날짜를 원하는 형태로 문자열로 변환해 주는 기능
java.text 패키지에서 제공
- DecimalFormat : 숫자를 형식화된 문자열로 변환
- SimpleDateFormat : 날짜를 형식화된 문자열로 변환
 */
public class FormatEx {
    public static void main(String[] args) {
        String text = "123456";
        boolean result1 = text.matches("[0-9]+"); // 숫자로 이루어진 문자열인가?
        System.out.println(result1);

        String text2 = "power98432*-;";
        String result2 = text2.replaceAll("[^a-zA-Z0-9]","0"); // 영문자와 숫자를 제외한 문자를 모두 0으로 치환
        System.out.println(result2);

        String text3 = "power98432*-;";
        String[] texts = text3.split("[0-9]+");
        for(String data : texts) {
            System.out.println(data);
        }

        String text4 = "10 20 30";
        texts = text4.split("\s");
        for(String data : texts) {
            System.out.println(data);
        }

        //Pattern 클래스 사용
        String patternString = "^[0-9]*$";
        Pattern pattern = Pattern.compile(patternString);

        // 샘플 문자열
        String text5 = "123123";
        String text6 = "123숫자입니다.00";

        boolean result = Pattern.matches("^[0-9]*$",text5);
        System.out.println(result);
        result = Pattern.matches("^[0-9]*$",text6);
        System.out.println(result);

        // Matcher 클래스 (스터디 하면서 추가적으로 학습해 주세요)
        String thing = "hello9888*-;hi0000";
        Pattern pattern2 = Pattern.compile("[a-z]+[0-9]+");
        Matcher matcher = pattern2.matcher(thing);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

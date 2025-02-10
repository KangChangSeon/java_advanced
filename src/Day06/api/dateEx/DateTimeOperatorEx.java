package Day06.api.dateEx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//LocalDateTime 클래스는 시간을 조작할 수 있는 기능 제공
public class DateTimeOperatorEx {
    public static void main(String[] args) {

        //1. 현재 시간 받아오기
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd aHH:mm:ss");
        System.out.println("현재시간 : " + now.format(dtf));

        LocalDateTime result = now.plusYears(1);
        System.out.println("1년 후 현재시간 : " + result.format(dtf));

        //1달후
        LocalDateTime result1 = now.plusMonths(1);
        System.out.println("한달 후 현재시간 : " + result1.format(dtf));
        //일주일후
        LocalDateTime result2 = now.plusWeeks(1);
        System.out.println("일주일 후 현재시간 : " + result2.format(dtf));

        //LocalDataTime target = LocalDateTime.of(year,month,dayofMonth,hour,minute,second);
        LocalDateTime startDateTime = LocalDateTime.of(2025, 2, 10, 0, 0, 0);
        System.out.println("시작일 : " + startDateTime.format(dtf));
        LocalDateTime endDateTime = LocalDateTime.of(2025, 2, 11, 0, 0, 0);
        System.out.println("종료일 : " + endDateTime.format(dtf));
        
        if(startDateTime.isBefore(endDateTime)) {
            System.out.println("진행중");
        }else if(startDateTime.isEqual(endDateTime)) {
            System.out.println("금일 종료 예정");
        }else if(startDateTime.isAfter(endDateTime)){
            System.out.println("종료 했습니다");
        }
    }
}

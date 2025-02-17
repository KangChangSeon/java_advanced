package workshop;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//
@Data
public class BoardExample {
    private int no;
    private String writer;
    private Date date;
    private String title;
    private String formattedDate;

    static List<BoardExample> boardList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public BoardExample(int no, String writer, String title) {
        this.no = no;
        this.writer = writer;
        this.title = title;
        this.date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        this.formattedDate = sdf.format(date);
    }

    void mainMenu() {
        while (true) {
            int choice = 0;
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
            System.out.print("메뉴 선택: ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    clear();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
    void create() {
        System.out.println("*** create() 메서드 실행됨");
        System.out.println();
    }
    void read(){
        System.out.println("*** read() 메서드 실행됨");
        System.out.println();
    }
    void clear(){
        System.out.println("*** clear() 메서드 실행됨");
        System.out.println();
    }

    void list() {
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-7s %-10s %-12s %-30s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------");
        for (BoardExample board : boardList) {
            System.out.printf("%-7d %-10s %-12s %-30s\n",
                    board.no, board.writer, board.formattedDate, board.title);
        }
        System.out.println("-----------------------------------------------------------");
        mainMenu();
    }

    static void main(){
        BoardExample writer1 = new BoardExample(1, "winter", "게시판에 오신 것을 환영합니다.");
        BoardExample writer2 = new BoardExample(1, "winter", "올 겨울은 많이 춥습니다.");
        boardList.add(writer1);
        boardList.add(writer2);
        writer1.list();
    }

    public static void main(String[] args) {
        BoardExample.main();
    }
}
package workshop;

import lombok.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Data
public class Board {
    Scanner scanner = new Scanner(System.in);
    List<Board> boardList = new ArrayList<>();

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    // bdate의 타입을 Date에서 String으로 변경합니다.
    private String bdate;

    public Board() {
        this.bno = 1;
    }

    // bdate를 String 타입으로 저장
    public Board(int bno, String btitle, String bcontent, String bwriter, String bdate) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }

    void mainMenu() {
        while (true) {
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 엔터 처리
            System.out.println();
            switch (choice) {
                case 1:
                    createBoard();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    // 필요에 따라 clear 기능 구현
                    boardList.clear();
                    System.out.println("모든 게시글이 삭제되었습니다.\n");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    void createBoard(){
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();

        // 보조 메뉴: 입력 확인
        System.out.println("\n보조 메뉴: 1.OK | 2.Cancle");
        System.out.print("선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine(); // 엔터 처리

        if (subChoice == 1) {
            // 현재 날짜를 가져와 "yyyy-MM-dd" 형식으로 변환
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(date);

            Board board = new Board(this.bno, title, content, writer, formattedDate);
            boardList.add(board);
            this.bno++;
            System.out.println("게시글이 등록되었습니다.\n");
        } else {
            System.out.println("등록이 취소되었습니다.\n");
        }
    }

    void list() {
        if (boardList.isEmpty()) {
            System.out.println("등록된 게시글이 없습니다.\n");
        } else {
            System.out.println("[게시물 목록]");
            System.out.println("-----------------------------------------------------------");
            // date 열의 폭을 10으로 변경
            System.out.printf("%-7s %-10s %-10s %-30s\n", "no", "writer", "date", "title");
            System.out.println("-----------------------------------------------------------");
            for (Board board : boardList) {
                System.out.printf("%-7d %-10s %-10s %-30s\n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                        board.getBtitle());
            }
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        Board boardApp = new Board();
        boardApp.mainMenu();
    }
}

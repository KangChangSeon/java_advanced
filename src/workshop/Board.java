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
    private Date bdate;

    public Board() {
        this.bno = 1;
    }

    public Board(int bno, String btitle, String bcontent, String bwriter, Date bdate) {
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
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    createBoard();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    clearBoard();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    void createBoard() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        System.out.print("작성자: ");
        String writer = scanner.nextLine();

        System.out.println("\n보조 메뉴: 1.OK | 2.Cancle");
        System.out.print("선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        if (subChoice == 1) {
            Date date = new Date();
            Board board = new Board(this.bno, title, content, writer, date);
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
            System.out.printf("%-7s %-10s %-10s %-30s\n", "no", "writer", "date", "title");
            System.out.println("-----------------------------------------------------------");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            for (Board board : boardList) {
                System.out.printf("%-7d %-10s %-10s %-30s\n",
                        board.getBno(),
                        board.getBwriter(),
                        sdf.format(board.getBdate()),
                        board.getBtitle());
            }
            System.out.println("-----------------------------------------------------------\n");
        }
    }

    void read() {
        if (boardList.isEmpty()) {
            System.out.println("등록된 게시글이 없습니다.\n");
            return;
        }
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bnochoice = scanner.nextInt();
        scanner.nextLine();

        Board foundBoard = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        for (Board board : boardList) {
            if (board.getBno() == bnochoice) {
                foundBoard = board;
                System.out.println("###########");
                System.out.printf("번호 : %d\n", board.getBno());
                System.out.printf("제목 : %s\n", board.getBtitle());
                System.out.printf("내용 : %s\n", board.getBcontent());
                System.out.printf("작성자 : %s\n", board.getBwriter());
                System.out.printf("날짜 : %s\n", sdf.format(board.getBdate()));
                System.out.println("###########");
                break;
            }
        }
        if (foundBoard == null) {
            System.out.println("해당 게시물이 존재하지 않습니다.");
            return;
        }
        System.out.println("\n보조 메뉴: 1.Update | 2.Delete | 3.List");
        System.out.print("메뉴 선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        switch (subChoice) {
            case 1:
                update(foundBoard);
                break;
            case 2:
                delete(foundBoard);
                break;
            case 3:
                list();
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
    }

    void update(Board board) {
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        String newTitle = scanner.nextLine();
        System.out.print("내용: ");
        String newContent = scanner.nextLine();
        System.out.print("작성자: ");
        String newWriter = scanner.nextLine();
        board.setBtitle(newTitle);
        board.setBcontent(newContent);
        board.setBwriter(newWriter);
        System.out.println("게시물이 수정되었습니다.");
    }

    void delete(Board board) {
        boardList.remove(board);
        System.out.println("게시물이 삭제되었습니다.");
    }

    void clearBoard() {
        boardList.clear();
        System.out.println("모든 게시글이 삭제되었습니다.\n");
    }

    static void main(){
        Board boardMain = new Board();
        boardMain.mainMenu();
    }

    public static void main(String[] args) {
        Board.main();
    }
}

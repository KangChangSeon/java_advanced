package workshop;

import workshop.Board;
import workshop.BoardService;

import java.util.Scanner;

public class BoardControl {
    private Scanner scanner = new Scanner(System.in);
    private BoardService boardService = new BoardService();

    public void mainMenu() {
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
                    readBoard();
                    break;
                case 3:
                    clearBoards();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다 다시 선택해주세요");
            }
        }
    }

    private void createBoard() {
        System.out.println("[새 게시물 입력]");
        String title;
        while (true) {
            System.out.print("제목: ");
            title = scanner.nextLine();
            if (title.matches("[가-힣a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println("한영 숫자로 이루어진 10글자 이내로 작성하세요.");
            }
        }
        System.out.print("내용: ");
        String content = scanner.nextLine();

        String writer;
        while (true) {
            System.out.print("작성자: ");
            writer = scanner.nextLine();
            if (writer.matches("[가-힣a-zA-Z]{1,5}")) {
                break;
            } else {
                System.out.println("한영으로 이루어진 5글자 이내로 작성하세요.");
            }
        }
        System.out.println("\n보조 메뉴: 1.OK | 2.Cancel");
        System.out.print("선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        if (subChoice == 1) {
            boardService.createBoard(title, content, writer);
            System.out.println("게시글이 등록되었습니다.\n");
        } else {
            System.out.println("등록이 취소되었습니다.\n");
        }
    }

    private void readBoard() {
        boardService.listBoards();
        if (boardService.getBoardList().isEmpty()) {
            return;
        }
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = scanner.nextInt();
        scanner.nextLine();

        Board board = boardService.readBoard(bno);
        if (board == null) {
            throw new CustomException(ErrorException.INVALID_POST);
        }
        System.out.println("###########");
        System.out.printf("번호 : %d\n", board.getBno());
        System.out.printf("제목 : %s\n", board.getBtitle());
        System.out.printf("내용 : %s\n", board.getBcontent());
        System.out.printf("작성자 : %s\n", board.getBwriter());
        System.out.println("###########");

        System.out.println("\n보조 메뉴: 1.Update | 2.Delete | 3.List");
        System.out.print("메뉴 선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        switch (subChoice) {
            case 1:
                updateBoard(board);
                break;
            case 2:
                if (boardService.deleteBoard(board.getBno())) {
                    System.out.println("게시물이 삭제되었습니다.");
                }
                break;
            case 3:
                boardService.listBoards();
                break;
            default:
                System.out.println("잘못된 선택입니다 다시 선택해주세요");
        }
    }

    private void updateBoard(Board board) {
        System.out.println("[수정 내용 입력]");
        String newTitle;
        while (true) {
            System.out.print("제목: ");
            newTitle = scanner.nextLine();
            if (newTitle.matches("[가-힣a-zA-Z0-9]{1,10}")) {
                break;
            } else {
                System.out.println("한영 숫자로 이루어진 10글자 이내로 작성하세요.");
            }
        }
        System.out.print("내용: ");
        String newContent = scanner.nextLine();

        String newWriter;
        while (true) {
            System.out.print("작성자: ");
            newWriter = scanner.nextLine();
            if (newWriter.matches("[가-힣a-zA-Z]{1,5}")) {
                break;
            } else {
                System.out.println("한영으로 이루어진 5글자 이내로 작성하세요.");
            }
        }
        if (boardService.updateBoard(board.getBno(), newTitle, newContent, newWriter)) {
            System.out.println("게시물이 수정되었습니다.");
        }
    }

    private void clearBoards() {
        boardService.clearBoards();
        System.out.println("모든 게시글이 삭제되었습니다.\n");
    }

    public static void main(String[] args) {
        BoardControl control = new BoardControl();
        control.mainMenu();
    }
}
/*
1. 예외처리 enum 을 빼두기 위해서 여러가지를 빼두긴 헀는데
   프로그램이 루프를 돌게 만드는게 조금 더 좋아 보이긴 해서 다시 없앨까 고민
   // 없애고 2번 게시글 검색하는데만 넣기, 이미 bno 검색하기 전에 전체 리스트를 제공
2. DAO, Service, Control, Board로 나누기
   DAO : 데이터를 CRUD 하는 역할
   Service : DAO의 데이터들을 여기서 쓰는 느낌 받아서 추가로 작업하기(Date 포맷)
   Control : Service의 메서스들을 호출해서 사용자가 보는 쓰는 부분들
   Board : 모델 만들기
3. Scanner List 등 공통된 부분들의 인스턴스를 재사용할 것인가?
   책임 분리 되어있으니깐 굳이 재사용할 이유는 없어보임
4. BoardDao 만 싱글톤으로 만들었음, 굳이긴 해도 데이터 일관성 유지를 위한다는 생각으로
 */
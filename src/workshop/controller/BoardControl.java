package workshop.controller;

import workshop.dto.Board;
import workshop.service.BoardService;
import workshop.service.IBoardService;
import workshop.service.exception.CustomException;
import workshop.service.exception.ErrorException;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class BoardControl {
    private Scanner scanner = new Scanner(System.in);
    private IBoardService boardService = new BoardService();

    public static void main(String[] args) {
        new BoardControl().run();
    }

    public void run() {
        while (true) {
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            Optional<Runnable> menuAction = getMenuAction(choice);

            menuAction.ifPresentOrElse(Runnable::run, () -> System.out.println(ErrorException.INVALID_MENU.getMsg()));
        }
    }

    private Optional<Runnable> getMenuAction(int choice) {
        switch (choice) {
            case 1:
                return Optional.of(this::createBoard);
            case 2:
                return Optional.of(() -> {
                    try {
                        readBoard();
                    } catch (CustomException e) {
                        System.out.println(e.getErrorException().getMsg());
                    }
                });
            case 3:
                return Optional.of(this::clearBoards);
            case 4:
                System.exit(0);
                break;
            default:
                return Optional.empty();
        }
        return Optional.empty();
    }

    private void createBoard() {
        System.out.println("[새 게시물 입력]");
        String title;
        while (true) {
            try {
                System.out.print("제목: ");
                title = scanner.nextLine();
                boardService.validateTitle(title);
                break;
            } catch (CustomException e) {
                System.out.println(e.getErrorException().getMsg());
            }
        }
        System.out.print("내용: ");
        String content = scanner.nextLine();

        String writer;
        while (true) {
            try {
                System.out.print("작성자: ");
                writer = scanner.nextLine();
                boardService.validateWriter(writer);
                break;
            } catch (CustomException e) {
                System.out.println(e.getErrorException().getMsg());
            }
        }
        System.out.println("\n보조 메뉴: 1.OK | 2.Cancel");
        System.out.print("선택: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        if (subChoice == 1) {
            Board board = new Board(0, title, content, writer, new Date());
            boardService.createBoard(board);
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

        Optional<Board> optionalBoard = Optional.ofNullable(boardService.readBoard(bno));

        optionalBoard.ifPresentOrElse(
                board -> {
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
                },
                () -> System.out.println(ErrorException.INVALID_POST.getMsg())
        );
    }


    private void updateBoard(Board board) {
        System.out.println("[수정 내용 입력]");
        String newTitle;
        while (true) {
            System.out.print("제목: ");
            newTitle = scanner.nextLine();
            boardService.validateTitle(newTitle);
            break;
        }
        System.out.print("내용: ");
        String newContent = scanner.nextLine();

        String newWriter;
        while (true) {
            System.out.print("작성자: ");
            newWriter = scanner.nextLine();
            boardService.validateWriter(newWriter);
            break;
        }
        if (boardService.updateBoard(board.getBno(), newTitle, newContent, newWriter)) {
            System.out.println("게시물이 수정되었습니다.");
        }
    }

    private void clearBoards() {
        boardService.clearBoards();
        System.out.println("모든 게시글이 삭제되었습니다.\n");
    }

}

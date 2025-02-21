package workshop;

import workshop.BoardDAO;
import workshop.Board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BoardService {
    private BoardDAO boardDAO = BoardDAO.getInstance();

    public void createBoard(String title, String content, String writer) {
        Date date = new Date();
        Board board = new Board(0, title, content, writer, date);
        boardDAO.insert(board);
    }

    public List<Board> getBoardList() {
        return boardDAO.findAll();
    }

    public Board readBoard(int bno) {
        return boardDAO.findByBno(bno);
    }

    public boolean updateBoard(int bno, String newTitle, String newContent, String newWriter) {
        Board board = boardDAO.findByBno(bno);
        if (board != null) {
            board.setBtitle(newTitle);
            board.setBcontent(newContent);
            board.setBwriter(newWriter);
            return boardDAO.update(board);
        }
        return false;
    }


    public boolean deleteBoard(int bno) {
        return boardDAO.delete(bno);
    }


    public void clearBoards() {
        boardDAO.clear();
    }

    public void listBoards() {
        List<Board> boards = boardDAO.findAll();
        if (boards.isEmpty()) {
            System.out.println("등록된 게시글이 없습니다.\n");
        } else {
            System.out.println("[게시물 목록]");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-7s %-15s %-15s %-30s\n", "no", "writer", "date", "title");
            System.out.println("-----------------------------------------------------------");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            for (Board board : boards) {
                System.out.printf("%-7d %-10s %-18s %-30s\n",
                        board.getBno(),
                        board.getBwriter(),
                        sdf.format(board.getBdate()),
                        board.getBtitle());
            }
            System.out.println("-----------------------------------------------------------\n");
        }
    }
}

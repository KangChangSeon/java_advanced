package workshop.service;

import workshop.dto.Board;
import workshop.service.exception.CustomException;
import workshop.service.exception.ErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BoardService implements IBoardService{
    private IBoardDAO boardDAO = new BoardDAO();

    public void createBoard(Board board) {
        validateTitle(board.getBtitle());
        validateWriter(board.getBwriter());

        if(board.getBdate() == null){
            board.setBdate(new Date());
        }
        boardDAO.insert(board);
    }

    public List<Board> getBoardList() {
        return boardDAO.findAll();
    }

    public Board readBoard(int bno) {
        return boardDAO.findByBno(bno);
    }

    public boolean updateBoard(int bno, String newTitle, String newContent, String newWriter) {
        validateWriter(newWriter);
        validateTitle(newTitle);

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

    public Boolean validateTitle(String title){
        if (!title.matches("[가-힣a-zA-Z0-9]{1,10}")) {
            throw new CustomException(ErrorException.INVALID_TITLE);
        }
        return true;
    }
    public Boolean validateWriter(String title){
        if (!title.matches("[가-힣a-zA-Z]{1,5}")) {
            throw new CustomException(ErrorException.INVALID_WRITER);
        }
        return true;
    }
}

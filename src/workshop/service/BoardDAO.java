package workshop.service;

import workshop.dto.Board;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    private static BoardDAO instance = new BoardDAO();
    private BoardDAO(){};
    public static BoardDAO getInstance(){
        return instance;
    }
    private List<Board> boardList = new ArrayList<>();
    private int nextBno = 1;

    public Board insert(Board board) {
        board.setBno(nextBno++);
        boardList.add(board);
        return board;
    }

    public Board findByBno(int bno) {
        for (Board board : boardList) {
            if (board.getBno() == bno) {
                return board;
            }
        }
        return null;
    }

    public List<Board> findAll() {
        return new ArrayList<>(boardList);
    }

    public boolean update(Board updatedBoard) {
        for (int i = 0; i < boardList.size(); i++) {
            Board board = boardList.get(i);
            if (board.getBno() == updatedBoard.getBno()) {
                boardList.set(i, updatedBoard);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int bno) {
        return boardList.removeIf(board -> board.getBno() == bno);
    }

    public void clear() {
        boardList.clear();
    }
}

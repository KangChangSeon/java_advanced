package workshop.service;

import workshop.dto.Board;
import java.util.List;

public interface IBoardService {
    void createBoard(Board board);
    List<Board> getBoardList();
    Board readBoard(int bno);
    boolean updateBoard(int bno, String newTitle, String newContent, String newWriter);
    boolean deleteBoard(int bno);
    void clearBoards();
    void listBoards();

    Boolean validateTitle(String title);

    Boolean validateWriter(String writer);
}

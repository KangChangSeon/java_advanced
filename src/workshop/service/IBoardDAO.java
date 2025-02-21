package workshop.service;

import lombok.Data;
import workshop.dto.Board;

import java.util.List;
public interface IBoardDAO {
    Board insert(Board board);
    Board findByBno(int bno);
    List<Board> findAll();
    boolean update(Board updatedBoard);
    boolean delete(int bno);
    void clear();
}

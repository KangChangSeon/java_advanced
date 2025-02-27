package jdbc.boards.controller;

import jdbc.boards.dao.BoardDAO;

public class Main {
    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();
        dao.insert();
        dao.showAll();
    }
}

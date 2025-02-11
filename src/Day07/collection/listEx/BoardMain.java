package Day07.collection.listEx;

import java.util.ArrayList;
import java.util.List;

public class BoardMain {
    public static void main(String[] args) {
        // 글을 보관 운영하는 ArrayList 생성
        List<Board> boardList = new ArrayList<>();

        //객체(Board) 객체 추가
        boardList.add(new Board("제목1","ssg1","아 오늘 너무 힘드네..."));
        boardList.add(new Board("제목2","ssg2","진도가 너무"));
        boardList.add(new Board("제목3","ssg3","빠른거 아님?"));

        // 저장된 글 목록 수
        int size = boardList.size();
        System.out.println("총 글의 수 : " + size);

        // 특정 인덱스의 객체 가져오기
        Board board = boardList.get(1);
        System.out.printf("주제 : %s 작성자 : %s 내용 : %s\n",board.getSubject(),board.getWriter(),board.getContent());

        // 글 목록
        for(Board b : boardList){
            System.out.printf("주제 : %s 작성자 : %s 내용 : %s\n",b.getSubject(),b.getWriter(),b.getContent());
        }

        // 글 삭제
        boardList.remove(1);
        for(Board b : boardList){
            System.out.printf("주제 : %s 작성자 : %s 내용 : %s\n",b.getSubject(),b.getWriter(),b.getContent());
        }
        System.out.println("======================================================================");
        boardList.remove(1);
        for(int i = 0; i < boardList.size(); i++){
            System.out.printf("%d\n",i);
        }
        for(Board b : boardList){
            System.out.printf("주제 : %s 작성자 : %s 내용 : %s\n",b.getSubject(),b.getWriter(),b.getContent());
        }
    }
}

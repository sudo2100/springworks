package com.springboot.jpabook;

import com.springboot.jpabook.domain.Board;
import com.springboot.jpabook.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// JUnit 라이브러리를 이용한 테스트
@Slf4j
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired   // Bean(객체) 주입 - 생성자 주입 방식
    private BoardRepository repository;

    @Test
    public void insertBoard(){
        // 게시글 생성
        /*Board board = new Board();
        // id, createdAt은 자동 생성
        board.setTitle("가입 인사...");
        board.setWriter("박신입");
        board.setContent("안녕하세요~ 잘 부탁드려요." );
        // 저장
        repository.save(board);
        System.out.println("board: " + board);*/

        // 게시글 생성
        /*Board board2 = Board.builder()
                .title("겨울옷 ")
                .writer("이신입")
                .content("겨울옷을 준비하세요.")
                .build();
        repository.save(board2);

        // log 사용
        log.info("board2: " + board2);*/
    }

    // 게시글 목록
    @Test
    public void getBoardList(){
        // DB table 있는 데이터를 가져옴
        List<Board> boardList = repository.findAll();

        // 출력
       /* for(Board board : boardList){
            System.out.println(board);
        }*/
        // log.info() -" "은 문자열로 형변환하기 위해 추가함
        boardList.forEach(board -> log.info(" " + board));
    }

    // 게시글 상세보기
    @Test
    public void getBoard(){
        //2번째 게시글 보기
        Board board = repository.findById(2).get();
        log.info(board.toString());
    }

    // 게시글 수정
    @Test
    public void updateBoard(){
        log.info("*** 2번 게시글 조회 ***");
        Board board = repository.findById(2).get();

        // 제목 수정
        board.setTitle("안녕하세요~");
        board.setWriter("행복해");
        repository.save(board);
    }

    // 게시글 삭제
    @Test
    public void deleteBoard() {
        log.info("1번 게시글 삭제");
        repository.deleteById(1);
    }

}

package com.springboot.jpabook;

import com.springboot.jpabook.domain.Board;
import com.springboot.jpabook.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Slf4j
@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private BoardRepository repository;

    //테스트 할때 데이터 생성 된 후 주석 처리 필수
    /*@BeforeEach
    public void dataPrepare(){
        for(int i=1; i<=200; i++){
            Board board = new Board();
            board.setTitle("테스트 제목 " + i);
            board.setWriter("테스터");
            board.setContent("테스트 내용 " + i);

            repository.save(board);
        }
    }*/

    // 제목으로 검색
    @Test
    public void testFindByTitle(){
        List<Board> boardList = repository.findByTitle("테스트 제목 200");

        log.info("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board);
        }
    }

    // 특정 단어가 포함된 글 내용 검색
    @Test
    public void testFindByContentContaining(){
        List<Board> boardList = repository.findByContentContaining("17");

        log.info("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board);
        }
    }

    // 제목 또는 내용에 특정 단어가 포함된 목록 검색
    @Test
    public void testFindByTitleContainingOrContentContaining(){
        List<Board> boardList =
                repository.findByTitleContainingOrContentContaining("17", "18");

        log.info("검색 결과");
        for(Board board : boardList) {
            System.out.println("--->" + board);
        }
    }

    // 글 제목에 특정 단어가 포함된 글 목록을 내림차순으로 검색
    @Test
    public void testFindByTitleContaingOrderByIdDesc(){
        List<Board> boardList =
                repository.findByTitleContainingOrderByIdDesc("15");

        log.info("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board);
        }
    }

    // 제목 검색어가 포함된 게시글 목록을 페이지 처리하여 조회
    @Test
    public void testFindByTitleContaining(){

        // 정렬 - 오름차순, 내림차순
        Pageable paging =
                PageRequest.of(0, 10, Sort.Direction.DESC, "id");

        List<Board> boardList =
                repository.findByTitleContaining("제목", paging);

        log.info("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board);
        }
    }
}

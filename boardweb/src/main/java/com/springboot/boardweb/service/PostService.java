package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.AddPostRequest;
import com.springboot.boardweb.dto.UpdatePostRequest;
import com.springboot.boardweb.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor  // 생성자 주입
@Service
public class PostService {
    private PostRepository postRepository;

    // 글 등록
    public Post save(AddPostRequest request, String username){
        // 게시글이 DB에 저장
       return postRepository.save(request.toEntity(username));
    }

    // 글 목록
    public List<Post> findAll(){
        //return postRepository.findAll();  //오름 차순 정렬
        return  postRepository.findAll(Sort.by(Sort.Direction.DESC, "id")); //내림차순
    }

    // 글 목록 + 검색
    public List<Post> search(String type, String keyword){
        // keyword == null 앞 순서가 있음(DB 쪽), keyword.isBlank() : 입력폼 데이터가 없음
        if(keyword == null || keyword.isBlank()){
            return findAll();  //글 목록 함수 호출
        }
        keyword = keyword.trim();   //검색어 공백 제거

        return switch (type == null ? "title" : type){
            case "content" -> postRepository.findByContentContainingOrderByIdDesc(keyword);
            case "writer" -> postRepository.findByWriterContainingOrderByIdDesc(keyword);
            default -> postRepository.findByTitleContainingOrderByIdDesc(keyword);
        };
    }

    // 글 상세 보기
    public Post findById(Long id){
        // 에와 처리 : IllegalArgumentException
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 글 삭제
    public void delete(Long id){
        postRepository.deleteById(id);
    }

    // 글 수정
    @Transactional  //트랜잭션 종료시에 변경 내용 자동 반영
    public Post update(Long id, UpdatePostRequest request){
        // 수정할 게시글 가져오기
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        // 글 수정 (update 함수는 Post에 있음)
        post.update(request.getTitle(), request.getContent());
        return post;
    }
}

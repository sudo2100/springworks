package com.springboot.boardweb.service;

import com.springboot.boardweb.dto.WritingSuggestionRequest;
import com.springboot.boardweb.dto.WritingSuggestionResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WritingAssistantService {
    // ai 챗 클래스
    private final ChatClient chatClient;
    private final PromptTemplate template;

    // LLM의 JSON 답 -> WritingSuggestionResponse 변환기
    private final BeanOutputConverter<WritingSuggestionResponse> outputConverter
            = new BeanOutputConverter<>(WritingSuggestionResponse.class);

    // 생성자
    public WritingAssistantService(ChatClient.Builder chatClientBuilder,
           @Value("classpath:prompts/writing-assistant.st") Resource promptResource){
        this.chatClient = chatClientBuilder.build();
        this.template = new PromptTemplate(promptResource);
    }

    // 화면에 글 등록
    public WritingSuggestionResponse getWritingAssist(WritingSuggestionRequest request){
        // 템플릿에 값을 채워 최종 프롬프트 만들기
        String prompt = template.render(request.toMap(outputConverter.getFormat()));

        // Gemini 호출
        String response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        // Json 문자열 -> 자바 객체
        return outputConverter.convert(response);
    }
}

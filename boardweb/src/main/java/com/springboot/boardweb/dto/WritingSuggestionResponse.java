package com.springboot.boardweb.dto;

import java.util.List;

// AI가 돌려줄 JSON : {"suggestions": ["제안1", "제안2", "제안3"]}
public record WritingSuggestionResponse(List<String> suggestions) {
}

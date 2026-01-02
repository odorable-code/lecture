package kr.hi.boot.model.dto;

import lombok.Data;

@Data
public class PostDTO {
    String title;
    String content;
    int board;
    String id;
}

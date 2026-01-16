package kr.hi.boot.model.dto;

import kr.hi.boot.model.util.PageMaker;
import kr.hi.boot.model.vo.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentResponseDTO {
    List<Comment> list;
    PageMaker pm;
}

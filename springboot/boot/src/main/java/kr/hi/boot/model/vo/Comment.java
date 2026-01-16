package kr.hi.boot.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    int num;
    String content;
    Date date;
    int oriNum;
    String del;
    String id;
    int postNum;
}

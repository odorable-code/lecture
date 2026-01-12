package kr.hi.community.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    int co_num;
    String co_content;
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy.MM.dd. HH:mm",
        timezone = "Asia/Seoul"
    )
    Date co_date;
    int co_ori_num;
    String co_del;
    String co_me_id;
    int co_po_num;
}

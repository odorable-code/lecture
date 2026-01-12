package kr.hi.community.dao;

import kr.hi.community.model.dto.CommentDTO;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDAO {
    void insertComment(@Param("coDto") CommentDTO commentDto);

    List<CommentVO> selectCommentList(@Param("cri") Criteria cri);

    int selectCommentCount(@Param("cri") Criteria cri);
}

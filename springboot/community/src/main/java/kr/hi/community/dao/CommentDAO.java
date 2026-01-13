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
    //  update, insert, delete는 반환 값이  boolean , int로 설정할 수 있는데
    // 설정함면 boolean 일 때 해당쿼리가 몇 개
    boolean deleteComment(@Param("num") int coNum);

    CommentVO selectComment(@Param("num") int coNum);

    boolean updateComment(@Param("dto") CommentDTO dto);
}

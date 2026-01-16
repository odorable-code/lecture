package kr.hi.boot.dao;

import kr.hi.boot.model.util.Criteria;
import kr.hi.boot.model.vo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDAO {
    List<Comment> selectComments(@Param("num") int num, @Param("cri") Criteria cri);

    int selectCommentsCount(@Param("num")int num);

    boolean insertComment(@Param("comment") Comment comment);

    boolean deleteComment(@Param("coNum") int coNum);
    Comment selectComment(@Param("coNum") int coNum);
}


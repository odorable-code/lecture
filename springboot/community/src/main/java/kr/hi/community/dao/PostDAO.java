package kr.hi.community.dao;

import kr.hi.community.model.dto.PostDTO;
import kr.hi.community.model.vo.BoardVO;
import kr.hi.community.model.vo.PostVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PostDAO {
    ArrayList<PostVO> selectPostList();

    PostVO selectPost(@Param("num") int num);

    void updateView(@Param("num") int num);

    ArrayList<BoardVO> selectBoardList();

    void insertPost(@Param("post") PostDTO post);

    void insertBoard(@Param("boName") String boName);

    void deleteBoard(@Param("num") int num);

    void updateBoard(@Param("num") int num, @Param("name") String name);
}

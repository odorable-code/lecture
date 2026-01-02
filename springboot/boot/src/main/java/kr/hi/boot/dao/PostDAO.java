package kr.hi.boot.dao;

import kr.hi.boot.model.dto.PostDTO;
import kr.hi.boot.model.vo.Board;
import kr.hi.boot.model.vo.Post;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PostDAO {
    ArrayList<Board> getBoardList();

    void insertBoard(@Param("name") String name);

    void deleteBoard(@Param("num")int num);

    void updateBoard(@Param("num")int num, @Param("name")String name);

    ArrayList<Post> getPostList();

    Post getPost(@Param("num")int num);
    
    Board getBoard(@Param("num")int num);

    void insertPost(@Param("post") PostDTO post);

    void updatePostView(@Param("num")int num);

}

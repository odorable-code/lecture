package kr.hi.community.service;

import kr.hi.community.dao.PostDAO;
import kr.hi.community.model.vo.BoardVO;
import kr.hi.community.model.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    public ArrayList<PostVO> getPostList() {
        // DAO에게 게시글 목록을 가져오라고 요청
        ArrayList<PostVO> list = postDAO.selectPostList();
        // 게시글 목록을 반환
        return list;
    }

    public void updateView(int num) {
        postDAO.updateView(num);
    }

    public PostVO selectPost(int num) {
        return postDAO.selectPost(num);
    }

    public ArrayList<BoardVO> getBoardList() {
        return postDAO.selectBoardList();
    }
}

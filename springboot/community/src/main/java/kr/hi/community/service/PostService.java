package kr.hi.community.service;

import kr.hi.community.dao.PostDAO;
import kr.hi.community.model.dto.PostDTO;
import kr.hi.community.model.util.CustomUser;
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

    public boolean insertPost(PostDTO post, CustomUser currentUser) {
        // 게시판 정보 확인 => 입력 안된 값 있는지 홗인해서 ㅈ발못된 게 있으면 false를 반환
        if (post.getTitle().trim().isEmpty()) {
            return false;
        }
        if (post.getContent().trim().isEmpty()) {
            return false;
        }

        if (post.getBoard() == 0) {
            return false;
        }

        if (currentUser == null || currentUser.getUsername().isEmpty()) {
            return false;
        }

        post.setWriter(currentUser.getUsername());

        try {
            postDAO.insertPost(post);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void insertBoard(String boName) {
        try {
            postDAO.insertBoard(boName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBoard(int num) {
        try {
            postDAO.deleteBoard(num);
        } catch (Exception e) {
            // 게시글이 있는 게시판을 삭제하려고 하면 예외 발생
            // => 외래키 옵션에서 게시판 번호를 참조하는 게시글이 있는 경우
            // 해당 게시판을 삭제하지 못하도록 (restrict)로 설정되어 있기 때문에
            e.printStackTrace();
        }
    }
    public void updateBoard(int num, String name) {
        try {
            postDAO.updateBoard(num, name);
        } catch (Exception e) {
            // 수정하려는 게시판 명이 중복되면 예외 밣생
            e.printStackTrace();
        }
    }
}
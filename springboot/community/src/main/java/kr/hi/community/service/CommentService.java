package kr.hi.community.service;


import kr.hi.community.dao.CommentDAO;
import kr.hi.community.model.dto.CommentDTO;
import kr.hi.community.model.util.CommentCriteria;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.util.CustomUser;
import kr.hi.community.model.util.PageMaker;
import kr.hi.community.model.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;


    public String insertComment(CommentDTO commentDto, CustomUser customUser) {
        // 매개변수 체크
        // 로그인 여부 체크
        if (customUser == null || customUser.getUsername() == null)  {
            return "로그인이 필요한 서비스입니다.";
        }
        // 댓글 정보 체크
        if (commentDto == null
        || commentDto.getContent().trim().isEmpty()
        || commentDto.getPostNum() == 0) {
            return "댓글 정보가 없습니다.";
        }
        // 댓글 등록
        try {
            // 댓글 작성자를 르그인한 사용자 아이디로 수정
            commentDto.setId(customUser.getUsername());
            commentDAO.insertComment(commentDto);
            return "댓글을 등록했습니다.";
        } catch (Exception e) {
            return "댓글을 등록하지 못했습니다.";
        }
    }

    public List<CommentVO> getCommentList(Criteria cri) {
        System.out.println((Criteria) cri);
        return commentDAO.selectCommentList(cri);
    }

    public PageMaker getPageMaker(Criteria cri) {
        // 다오에게 페이지 정보를 주면서 전체 댓글 수를 가져오라고 수정
        int totalCount = commentDAO.selectCommentCount(cri);
        return new PageMaker(3, cri, totalCount);
    }
}

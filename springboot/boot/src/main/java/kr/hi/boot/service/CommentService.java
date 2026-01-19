package kr.hi.boot.service;

import kr.hi.boot.dao.CommentDAO;
import kr.hi.boot.model.util.Criteria;
import kr.hi.boot.model.util.CustomUser;
import kr.hi.boot.model.util.PageMaker;
import kr.hi.boot.model.vo.Comment;
import org.springframework.stereotype.Service;

import javax.swing.plaf.IconUIResource;
import java.util.List;

@Service
public class CommentService {
    private final CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }


    public List<Comment> getComments(int num, Criteria cri) {
        return commentDAO.selectComments(num, cri);
    }

    public PageMaker getPageMaker(int num, Criteria cri) {
        //한페이지네이션에서 최대 페이지수를 3개로 선언
        int pageCount = 3;
        //다오에게 게시글번호를 주면서 전체 댓글 수를 가져오라고 요청
        //전체댓글수 = 다오야.전체댓글수가져와(게시글번호);
        int count = commentDAO.selectCommentsCount(num);
        //최대 페이지수, 전체게시글수, 현재페이지 정보를 이용하여 PageMaker 객체를 생성
        PageMaker pm = new PageMaker(pageCount, cri, count);
        //생성된 객체를 반환
        return pm;
    }

    public String insertComment(Comment comment, CustomUser user) {
        if (user == null || user.getUsername() == null) {
            return "로그인이 필요한 서비스입니다.";
        }

        if (comment.getContent() == null
         || comment.getContent().isBlank()) {
            return "댓글을 입력하세요";
        }
        comment.setId(user.getUsername());
        boolean result = commentDAO.insertComment(comment);
        if (result) {
            return "댓글을 등록했습니다.";
        } else {
            return "댓글을 등록할 수 없습니다.";
        }
    }

    public String deleteComment(int coNum, CustomUser user) {
        if (user == null || user.getUsername() == null) {
            return "로그인이 필요한 서비스입니다.";
        }
        String id = user.getUsername();
        if (!isWriter(coNum, id)) {
            return "작성자가 아닙니다.";
        }
        boolean res = commentDAO.deleteComment(coNum);
        if (res) {
            return "댓글을 삭제했습니다.";
        }
        return "댓글을 삭제하지 못했습니다.";
    }

    private boolean isWriter(int coNum, String id) {
        Comment comment = commentDAO.selectComment(coNum);
        if (comment == null) {
            return false;
        }
        String writer = comment.getId();
        return writer.equals(id);
    }

    public String updateComment(int coNum, Comment comment, CustomUser user) {
        if (user == null || user.getUsername() == null) {
            return "로그인이 필요한 서비스입니다.";
        }
        if (comment == null || comment.getContent().isBlank()) {
            return "댓글을 입력하세요.";
        }
        String id = user.getUsername();
        if (!isWriter(coNum, id)) {
            return "작성자가 아닙니다.";
        }
        boolean res = commentDAO.updateComment(coNum, comment.getContent());
        if (res) {
            return "댓글을 수정했습니다.";
        }
        return "댓글을 수정하지 못했습니다.";
    }
}

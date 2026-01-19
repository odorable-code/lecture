package kr.hi.boot.service;

import kr.hi.boot.dao.LikeDAO;
import kr.hi.boot.model.util.CustomUser;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeDAO likeDAO;

    public LikeService(LikeDAO likeDAO) {
        this.likeDAO = likeDAO;
    }

    public String postLike(int postNum, CustomUser user) {
        if (user == null || user.getUsername() == null) {
            return "로그인이 필요한 서비스입니다.";
        }
        String id = user.getUsername();
        // 다오에게 게시글번호와 아이디를 주면서 삭제하고  결과를 가져오라고 요청
        if (likeDAO.deleteLike(postNum, id)) {
            return "추천을 취소했습니다.";
        }
        // 삭제했으면 추천을 취소했습니다라고 반환
        // 못했으면 (추천정보가 없어서)
        // 다오에게 게시글 번호와 아이디를 주면서 추천하고 결과를 가져오라고 요청
        // 추천했으면 추천을 했습니다를 반환
        // 못했으면 추천을 하지 못했습니다를 반환

        if (likeDAO.insertLike(postNum, id)) {
            return "추천했습니다.";
        }

        return "추천하지 못했습니다.";
    }
}

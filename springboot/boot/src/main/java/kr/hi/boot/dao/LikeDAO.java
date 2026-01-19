package kr.hi.boot.dao;

import org.apache.ibatis.annotations.Param;

public interface LikeDAO {
    boolean insertLike(@Param("postNum") int postNum, @Param("id") String id);

    boolean deleteLike(@Param("postNum") int postNum, @Param("id") String id);
}

package kr.hi.community.dao;

import kr.hi.community.model.dto.MemberDTO;
import kr.hi.community.model.vo.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
    MemberVO selectMember(@Param("id") String id);

    boolean insertMember(@Param("obj") MemberDTO member);
}

package kr.hi.boot.dao;

import kr.hi.boot.model.dto.SignupDTO;
import kr.hi.boot.model.vo.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
    //    @param("멤버에서 사용할 이름");
    Member getMember(@Param("id") String id);
    void insertMember(@Param("dto") SignupDTO signupDto);
}

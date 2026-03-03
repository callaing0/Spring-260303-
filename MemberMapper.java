package com.book.mappers;
(파일 경로 : src/main/java/com.book/mappers)

import com.book.Entity.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDTO dto); // 회원 저장
    List<MemberDTO> selectAllMembers(); // 목록 출력
}

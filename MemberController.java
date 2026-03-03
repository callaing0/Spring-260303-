package com.book.controvl;
(파일 경로 : src/main/java/com.book/control)

import com.book.Entity.MemberDTO;
import com.book.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberMapper mapper;

    // 입력폼 + 목록 출력 화면 보여주기
    @GetMapping("/member/form")
    public String memberForm(Model model) {
        List<MemberDTO> list = mapper.selectAllMembers();
        model.addAttribute("list", list);
        return "member/form"; // templates/member/form.html 호출
    }

    // 등록 버튼 클릭 시 DB 저장 처리
    @GetMapping("/member/add")
    public String addMember(MemberDTO dto) {
        mapper.insertMember(dto);
        return "redirect:/member/form"; // 저장 후 다시 목록 화면으로 이동
    }
}

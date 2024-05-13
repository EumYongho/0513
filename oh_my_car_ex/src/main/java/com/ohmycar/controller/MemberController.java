package com.ohmycar.controller;

import java.security.Provider.Service;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;


import lombok.extern.log4j.Log4j;



@Controller
@Log4j
public class MemberController {
	@PostMapping("login")
	public String login(Model model, String userId, String password) {
		log.info("id ; " + userId + ", pw : " + password);
		Member loginMember = Service.login(userId, password);
		if (loginMember != null) {
			model.addAttribute("msg", "로그인이 완료 되었습니다.");
			model.addAttribute("location", "/main.do");
			model.addAttribute("loginMember", loginMember);
			return "common/msg";
		} else {
			model.addAttribute("msg", "아이디나 패스워드가 잘못되었습니다.");
			model.addAttribute("location", "/mypage/signIn");
			return "common/msg";
		}
	}

	@RequestMapping("/logout")
	public String logout(Model model, @SessionAttribute(name = "loginMember", required = false) Member loginMember,
			SessionStatus sessionStatus) {
		// @SessionAttribute name= "loginMember",는
		// null값이 회원인 경우 null을 주고 사용자 상태를 변경한다
		if (loginMember != null) { // loginmember값이 null일 경우
			model.addAttribute("loginMember", null);
			sessionStatus.setComplete();
			return "redirect:/main.do"; // 메인화면으로 넘어감
		}
		return null;
	}
	@GetMapping("/member/update")
	public String update(Model model, @ModelAttribute Member member,@SessionAttribute(name= "loginMember", required = false) Member loginMember) {
	System.out.println(loginMember);
	System.out.println(member);
	if(loginMember == null || loginMember.getUserId().equals(member.getUserId()) == false) {
		// 수정창에 들어갈때 정보가 없을때(로그인이 안되어 있을때)
		model.addAttribute("msg", "잘못된 접근입니다.");
		model.addAttribute("location", "/main.do"); 
			return "common/msg";
	}
	//로그인이 안되어 있을때 수정을 시도하면 "잘못된 접근입니다"라는 글과 함께 메인페이지로 돌아간다
			
	member.setUser_no(loginMember.getUserNo());
	int result = service.save(member);
	//MemberService의 save로 member의 값을 가지고 간다
		
	if(result > 0 ) {
	model.addAttribute("loginMember", service.findById(member.getUserId()));
	//MemberService => 유저의 id를 가지고 memberService의 findbyid로 간다

	//result값이 0이 아닐경우(회원일 경우) findbyid로 db에서 수정된 아이디를 가지고와서 member/view에서 보여준다
		model.addAttribute("msg", "회원정보를 수정하였습니다.");
		model.addAttribute("location", "/member/view");
		}else {
		model.addAttribute("msg", "회원정보 수정을 실패하였습니다.");
		model.addAttribute("location", "/member/view");
		}
		return "common/msg";
		}
}

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
			model.addAttribute("msg", "�α����� �Ϸ� �Ǿ����ϴ�.");
			model.addAttribute("location", "/main.do");
			model.addAttribute("loginMember", loginMember);
			return "common/msg";
		} else {
			model.addAttribute("msg", "���̵� �н����尡 �߸��Ǿ����ϴ�.");
			model.addAttribute("location", "/mypage/signIn");
			return "common/msg";
		}
	}

	@RequestMapping("/logout")
	public String logout(Model model, @SessionAttribute(name = "loginMember", required = false) Member loginMember,
			SessionStatus sessionStatus) {
		// @SessionAttribute name= "loginMember",��
		// null���� ȸ���� ��� null�� �ְ� ����� ���¸� �����Ѵ�
		if (loginMember != null) { // loginmember���� null�� ���
			model.addAttribute("loginMember", null);
			sessionStatus.setComplete();
			return "redirect:/main.do"; // ����ȭ������ �Ѿ
		}
		return null;
	}
	@GetMapping("/member/update")
	public String update(Model model, @ModelAttribute Member member,@SessionAttribute(name= "loginMember", required = false) Member loginMember) {
	System.out.println(loginMember);
	System.out.println(member);
	if(loginMember == null || loginMember.getUserId().equals(member.getUserId()) == false) {
		// ����â�� ���� ������ ������(�α����� �ȵǾ� ������)
		model.addAttribute("msg", "�߸��� �����Դϴ�.");
		model.addAttribute("location", "/main.do"); 
			return "common/msg";
	}
	//�α����� �ȵǾ� ������ ������ �õ��ϸ� "�߸��� �����Դϴ�"��� �۰� �Բ� ������������ ���ư���
			
	member.setUser_no(loginMember.getUserNo());
	int result = service.save(member);
	//MemberService�� save�� member�� ���� ������ ����
		
	if(result > 0 ) {
	model.addAttribute("loginMember", service.findById(member.getUserId()));
	//MemberService => ������ id�� ������ memberService�� findbyid�� ����

	//result���� 0�� �ƴҰ��(ȸ���� ���) findbyid�� db���� ������ ���̵� ������ͼ� member/view���� �����ش�
		model.addAttribute("msg", "ȸ�������� �����Ͽ����ϴ�.");
		model.addAttribute("location", "/member/view");
		}else {
		model.addAttribute("msg", "ȸ������ ������ �����Ͽ����ϴ�.");
		model.addAttribute("location", "/member/view");
		}
		return "common/msg";
		}
}

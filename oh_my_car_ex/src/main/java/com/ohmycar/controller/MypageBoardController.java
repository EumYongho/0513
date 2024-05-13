package com.ohmycar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ohmycar.vo.Board;
import com.ezen.realfinal.board.model.vo.Reply;
import com.ezen.realfinal.common.util.PageInfo;
import com.ezen.realfinal.member.model.vo.Member;
import com.ezen.realfinal.mypageBoard.model.service.MypageBoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/MypageBoard")
@Controller
public class MypageBoardController {

	@Autowired
	private MypageBoardService service;

	// ���������� - ���۸�� ����
	@GetMapping("/myBoard")
	public String goMyBoard() {
		log.info("���������� �� �۸�� ����!");
		return "mypage/mypageBoardList";
	}

	// ���������� - ���� �� �� ���
	@GetMapping("/mylist")
	public String myBoardList(Model model, @RequestParam Map<String, String> param,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {

		int page = 1;
		if (param.containsKey("page") == true) {
			try {
				page = Integer.parseInt(param.get("page"));
			} catch (Exception e) {
			}
		}
		if (param.get("sort") == null || "".equals(param.get("sort").toString())) {
			param.put("sort", "DESC");
		}

		param.put("user_no", String.valueOf(loginMember.getUser_no()));
		System.out.println(param.toString());
		PageInfo pageInfo = new PageInfo(page, 10, service.getBoardCount(param), 10);
		List<Board> list = service.getBoardList(pageInfo, param);

//		for (Board board : list) {
//			System.out.println("boardList : "+board.toString());
//		}
//		
//		System.out.println("�� ���� : " + loginMember);
		System.out.println("�� ���ε� �˻� �̰ž� : " + param.toString());
		model.addAttribute("list", list);
		model.addAttribute("board_list_no", param.get("type"));
		model.addAttribute("param", param);
		model.addAttribute("pageInfo", pageInfo);
		return "/mypage/mypageBoardList";
	}

	// ���������� - �� ��۸��
	@GetMapping("/myReply")
	public String goMyReply(Model model, @RequestParam Map<String, String> param,
			@SessionAttribute(name = "loginMember", required = false) Member loginMember) {

		int page = 1;
		if (param.containsKey("page") == true) {
			try {
				page = Integer.parseInt(param.get("page"));
			} catch (Exception e) {
			}
		}

		param.put("user_no", String.valueOf(loginMember.getUser_no()));
		PageInfo pageInfo = new PageInfo(page, 10, service.getReplyCount(param), 10);
		List<Reply> list = service.getReplyList(pageInfo, param);

//		for (Board board : list) {
//			System.out.println("boardList : "+board.toString());
//		}
//		
//		System.out.println("�� ���� : " + loginMember);

		model.addAttribute("list", list);
		model.addAttribute("board_list_no", param.get("type"));
		model.addAttribute("param", param);
		model.addAttribute("pageInfo", pageInfo);
		log.info("���������� �� ��۸�� ����!");
		return "mypage/mypageReply";
	}

	// ���������� - ���� �� ��� ���

}
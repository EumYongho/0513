package com.ohmycar.service;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohmycar.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {
//interface = MemberService => MemberServiceimpl을 상속받음

	@Override
	public MemberVO login(String userId, String password) {

		MemberVO member = this.findById(userId);
		if (member == null) { // id로 찾았는데 member가 없을 때
			return null;
		}
		System.out.println(member.getPassword()); // Hash 코드로 암호화된 비밀번호가 저장되어있음
		System.out.println(passwordEncoder.encode(password));
		// encode를 통해 평문에서 암호문으로 변경
		System.out.println(passwordEncoder.matches(password, member.getPassword()));
//passwordEncoder.matches = 일치화 여부 검증(사용자의 패스워드와 암호화된 패스워드 일치 여부 판단)
		System.out.println("in service Impl userId : " + userId + " / password : " + password);

		if (member != null && passwordEncoder.matches(password, member.getPassword()) == true) {
			// 인증 성공
			return member;
		} else {
			// 인증 실패
			return null;
		}
		@Transactional(rollbackFor = Exception.class)
		public int save(MemberVO member) {
		MemberVO result = 0;
			
		if(member.getUserNo() != 0) { 
			String encodePwd = passwordEncoder.encode(member.getPassword());
			member.setPassword(encodePwd);
			result = mapper.updateMember(member);
			}
		else { 
		String encodePwd = passwordEncoder.encode(member.getPassword());
			member.setPassword(encodePwd);
			result = mapper.insertMember(member);
			} 
			return result;	
			}
	}
}
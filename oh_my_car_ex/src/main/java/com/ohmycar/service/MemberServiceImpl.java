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
//interface = MemberService => MemberServiceimpl�� ��ӹ���

	@Override
	public MemberVO login(String userId, String password) {

		MemberVO member = this.findById(userId);
		if (member == null) { // id�� ã�Ҵµ� member�� ���� ��
			return null;
		}
		System.out.println(member.getPassword()); // Hash �ڵ�� ��ȣȭ�� ��й�ȣ�� ����Ǿ�����
		System.out.println(passwordEncoder.encode(password));
		// encode�� ���� �򹮿��� ��ȣ������ ����
		System.out.println(passwordEncoder.matches(password, member.getPassword()));
//passwordEncoder.matches = ��ġȭ ���� ����(������� �н������ ��ȣȭ�� �н����� ��ġ ���� �Ǵ�)
		System.out.println("in service Impl userId : " + userId + " / password : " + password);

		if (member != null && passwordEncoder.matches(password, member.getPassword()) == true) {
			// ���� ����
			return member;
		} else {
			// ���� ����
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
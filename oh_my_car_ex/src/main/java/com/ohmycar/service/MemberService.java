package com.ohmycar.service;

import com.ohmycar.domain.MemberVO;

public interface MemberService { //interface ���
MemberVO login(String userId, String password);
int save(MemberVO member);   //Member(DTO)�� ����
boolean validate(String userId);	
MemberVO findById(String userId);
int delete(int userNo, String userId ,String password);
int updatePwd(MemberVO loginMember, String password);
}

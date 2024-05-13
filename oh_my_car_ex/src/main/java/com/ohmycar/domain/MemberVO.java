package com.ohmycar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private int    userNo;	
	private String userId;	
	private String username;
	private String password;
	private String email;	
	private String nickname;
	private String enabled;
	
}
package com.itwillbs.project_fundizzy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.project_fundizzy.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;

	public int insertMember(Map<String, String> member) {
		return mapper.insertMember(member);
	}

	public void registMailAuthInfo(Map<String, String> mailAuthInfo) {
		
		// 기존 인증 정보 존재 여부 확인
		Map<String, String> dbMailAuthInfo = mapper.selectMailAuthInfo(mailAuthInfo);
		
		// 인증정보 조회 결과 판별
		if(dbMailAuthInfo == null) { // 기존 인증정보 없음(인증메일 발송 이력 없음)
			// 새 인증정보 등록을 위해 insertMailAuthInfo() 메서드 호출하여 등록 작업 요청(INSERT)
			mapper.insertMailAuthInfo(mailAuthInfo);
		} else { // 기존 인증정보 있음(인증메일 발송 이력 있음)
			// 기존 인증정보 갱신 위해 updateMailAuthInfo() 메서드 호출하여 수정 작업 요청(UPDATE)
			mapper.updateMailAuthInfo(mailAuthInfo);
		}
		
	}

	public String getAuthCode(Map<String, String> authInfo) {
		return mapper.selectAuthCode(authInfo);
	}

	//-----------------------------------------------------------------------------------
	// 사용자 이메일 조회
	public Map<String, String> getMember(String email) {
		return mapper.selectEmail(email);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

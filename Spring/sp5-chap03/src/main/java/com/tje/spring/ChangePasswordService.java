package com.tje.spring;

public class ChangePasswordService {
	private MemberDao memberDao;
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		// 일치하지 않으면 익셉션이 일어나 13번 줄은 실행되지 않는다.
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
}	

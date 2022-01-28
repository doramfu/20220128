package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> memberSelectList();
	
	public MemberVO memberSelect(MemberVO vo);
	
	public int memberInsert(MemberVO vo);
	
	public int memberDelete(MemberVO vo);
	
	public int memberUpdate(MemberVO vo);
	
	public boolean isIdCheck(String id); // 아이디 중복 체크
	
}

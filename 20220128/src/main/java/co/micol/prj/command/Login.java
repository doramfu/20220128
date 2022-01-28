package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); //세션객체를 가져온다.
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDAO.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getId()); //id저장
			session.setAttribute("author", vo.getAuthor()); //권한을 저장
			session.setAttribute("name", vo.getName()); //이름을 저장
			request.setAttribute("message", vo.getName() + "환영합니다");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다");
		}
		
		return "member/memberLoginResult";
	}

}

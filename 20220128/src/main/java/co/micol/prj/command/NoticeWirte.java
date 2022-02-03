package co.micol.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeWirte implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 글 등록
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeWriter(request.getParameter("noticeWriter"));
		if(request.getParameter("noticeDate") != null) {
			vo.setNoticeDate(Date.valueOf(request.getParameter("noticeDate")));
		}
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeSubject(request.getParameter("noticeSubject"));
		
		String viewPage = null; //돌려줄 페이지 변수
		
		int n = noticeDAO.noticeInsert(vo);
		if(n != 0) {
			viewPage = "noticeList.do";
		}else {
			request.setAttribute("message", "등록이 실패하였습니다");
			viewPage = "notice/noticeError";
		}
		return viewPage;
	}

}

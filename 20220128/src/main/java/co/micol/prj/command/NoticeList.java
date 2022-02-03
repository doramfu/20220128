package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 목록
		NoticeService noticeDAO = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDAO.noticeSelectList());
		return "notice/noticeList";
	}

}

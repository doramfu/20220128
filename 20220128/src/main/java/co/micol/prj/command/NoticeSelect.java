package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 내용보기
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = noticeDAO.noticeSelect(vo);
		//request.setAttribute("notice", noticeDAO.noticeSelect(vo));
		if(vo != null) {
			noticeDAO.noticeHitUpdate(vo.getNoticeId());
			request.setAttribute("notice", vo);
		}else {
			request.setAttribute("message", "조회된 데이터가 없습니다");
			return "notice/noticeError";
		}
		return "notice/noticeSelect";
	}

}

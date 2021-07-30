package kr.or.pets.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;

import kr.or.pets.notice.dao.NoticeDAO;
import kr.or.pets.notice.vo.NoticeVO;

@Service("noticeService")
@Transactional(propagation = Propagation.REQUIRED)
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public Map listNotices(Map<String, Integer> pagingMap) throws Exception {
		
		List<NoticeVO> noticesList = noticeDAO.selectAllNoticesList(pagingMap);
		int totNotices = noticeDAO.selectTotNotices();
		
		Map noticesMap = new HashMap();
		noticesMap.put("noticesList", noticesList);
		noticesMap.put("totNotices", totNotices);
		
		return noticesMap;
	}
	
	
	

	/*
	 * //01. 공지사항 전체 목록 조회
	 * 
	 * @Override public List listNotices() throws DataAccessException { List
	 * noticesList = noticeDAO.selectAllNoticeList(); return noticesList; }
	 * 
	 * 
	 * //02. 공지사항 작성
	 * 
	 * @Override public int addNotice(NoticeVO noticeVO) throws DataAccessException
	 * {
	 * 
	 * return noticeDAO.insertNotice(noticeVO); }
	 * 
	 * //03. 공지사항 상세보기
	 * 
	 * @Override public NoticeVO readNotice(int no_number) throws
	 * DataAccessException { return noticeDAO.readNotice(no_number); }
	 * 
	 * 
	 * //04. 공지사항 조회수 증가
	 * 
	 * @Override public void increaseViewCnt(int no_number, HttpSession session)
	 * throws DataAccessException { long update_time = 0; // 세션에 저장된 조회시간 검색 // 최초로
	 * 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행 x
	 * if(session.getAttribute("update_time"+no_number) != null) {
	 * 
	 * update_time = (Long) session.getAttribute("update_time"+no_number);
	 * 
	 * } // 시스템의 현재시간을 current_time에 저장 long current_time =
	 * System.currentTimeMillis(); // 일정시간이 경과 후 조회수 증가 처리 24*60*60*1000(24시간) //
	 * 시스템현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간) if(current_time - update_time >
	 * 5*1000) { noticeDAO.increaceViewCnt(no_number); //세션에 시간을 저장 : "update_time"
	 * + no_number는 다른변수와 중복되지 않게 명명한것.
	 * session.setAttribute("update_time"+no_number, current_time); }
	 * 
	 * }
	 */

}

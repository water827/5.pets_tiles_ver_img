package kr.or.pets.notice.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;

import kr.or.pets.notice.vo.NoticeVO;

public interface NoticeService {
	  //01. 공지사항 전체 목록 조회 
	 	public Map listNotices(Map<String, Integer> pagingMap) throws Exception;
	 
	
	  
		/*
		 * //02. 공지사항 작성 public int addNotice(NoticeVO noticeVO) throws
		 * DataAccessException;
		 * 
		 * //03. 공지사항 상세보기 public NoticeVO readNotice(int no_number) throws
		 * DataAccessException;
		 * 
		 * //04. 공지사항 조회수 public void increaseViewCnt(int no_number, HttpSession
		 * session) throws DataAccessException;
		 */
	 
	

}

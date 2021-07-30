package kr.or.pets.notice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.or.pets.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	
	  //01. 공지사항 전체 목록 조회 
	public List<NoticeVO> selectAllNoticesList(Map<String, Integer> pagingMap) throws DataAccessException; 
	public int selectTotNotices() throws DataAccessException;
	
	/*
	 * //02. 공지사항 작성 public int insertNotice(NoticeVO noticeVO) throws
	 * DataAccessException;
	 * 
	 * //03. 공지사항 상세보기 public NoticeVO readNotice(int no_number) throws
	 * DataAccessException;
	 * 
	 * //04. 공지사항 조회 증가 public void increaceViewCnt(int no_number) throws
	 * DataAccessException;
	 */
}

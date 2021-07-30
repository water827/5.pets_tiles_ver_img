package kr.or.pets.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.or.pets.notice.vo.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<NoticeVO> selectAllNoticesList(Map<String, Integer> pagingMap) throws DataAccessException {
		
		List<NoticeVO> noticesList = sqlSession.selectList("mapper.notice.selectAllNoticesList", pagingMap);
		
		
		return noticesList;
	}

	@Override
	public int selectTotNotices() throws DataAccessException {
		int totNotices = sqlSession.selectOne("mapper.notice.selectTotNotices");
		return totNotices;
	}
	
	
	
	
	
	
	
	
	
	

	/*
	 * //01. 공지사항 전체 목록 조회
	 * 
	 * @Override public List selectAllNoticeList() throws DataAccessException {
	 * List<NoticeVO> noticesList =
	 * sqlSession.selectList("mapper.notice.selectAllNoticeList"); return
	 * noticesList; }
	 */

	
	  //01. 공지사항 전체 목록 조회
	  
		/*
		 * @Override public List<NoticeVO> selectAllNoticeList(Map<String, Integer>
		 * pagingMap) throws DataAccessException {
		 * 
		 * List<NoticeVO> noticesList =
		 * sqlSession.selectList("mapper.notice.selectAllNoticeList",pagingMap); return
		 * noticesList; }
		 * 
		 * @Override public int selectTotNotices() throws DataAccessException { int
		 * totNotices = sqlSession.selectOne("mapper.notice.selectTotNotices"); return
		 * totNotices; }
		 */
	 
	
	
	/*
	 * @Override public List<NoticeVO> selectAllNoticeList() throws
	 * DataAccessException { List<NoticeVO> noticesList =
	 * sqlSession.selectList("mapper.notice.selectAllNoticeList"); return
	 * noticesList; }
	 */
	/*
	 * //02. 공지사항 작성
	 * 
	 * @Override public int insertNotice(NoticeVO noticeVO) throws
	 * DataAccessException { int result =
	 * sqlSession.insert("mapper.notice.insertNotice", noticeVO); return result; }
	 * 
	 * //03. 공지사항 상세보기
	 * 
	 * @Override public NoticeVO readNotice(int no_number) throws
	 * DataAccessException { //return 값을 noticeVO 이므로 NoticeVO로 설정 NoticeVO noticeVO
	 * = sqlSession.selectOne("mapper.notice.readNotice", no_number); return
	 * noticeVO; }
	 * 
	 * //04. 공지사항 조회수
	 * 
	 * @Override public void increaceViewCnt(int no_number) throws
	 * DataAccessException { sqlSession.update("notice.increaseViewCnt",no_number);
	 * 
	 * }
	 */

}

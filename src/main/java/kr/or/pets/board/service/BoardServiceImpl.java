package kr.or.pets.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.pets.board.dao.BoardDAO;
import kr.or.pets.board.vo.BoardVO;


@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService{
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired
	private BoardDAO boardDAO;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	@Override
	public Map listBoards(Map<String, Integer> pagingMap) throws DataAccessException {
		List<BoardVO> boardsList = boardDAO.selectAllBoardList(pagingMap);		/* 전달된 pagingMap을 사용해 글 목록을 조회함*/
		int totBoards = boardDAO.selectTotBoards();								/* 테이블에 존재하는 글 수를 조회함 */
		
		Map boardsMap = new HashMap();
		boardsMap.put("boardsList", boardsList);
		boardsMap.put("totBoards", totBoards);
		
		return boardsMap;
	}


	@Override
	public int removeBoard(int qa_No) throws DataAccessException {
		
		return boardDAO.deleteBoard(qa_No);
	}


	@Override
	public int addBoard(BoardVO boardVO) throws DataAccessException {
		
		return boardDAO.insertBoard(boardVO);
	}


	@Override
	public BoardVO viewBoard(int qa_No) throws DataAccessException {
		
		return boardDAO.viewBoard(qa_No);
		
	
		
	}


	@Override
	public Map updateBoard(Map updateMap) throws DataAccessException {
		
		boardDAO.updateBoard(updateMap);
		return updateMap;
	}


	@Override
	public Object updateForm(int qa_No) {
		// TODO Auto-generated method stub
		return null;
	}





	
}

package biz.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.board.dao.BoardDAO;
import biz.board.vo.BoardVO;

@Service("boardservice")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;
	
	public int addBoard(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		return dao.addBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		 return dao.getBoardList();
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int boardno) {
		// TODO Auto-generated method stub
		return dao.removeBoard(boardno);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		// TODO Auto-generated method stub
		return dao.searchBoard(condition, keyword);
	}

	@Override
	public BoardVO getBoard(int boardno) {
		return dao.getBoard(boardno);
	}

}

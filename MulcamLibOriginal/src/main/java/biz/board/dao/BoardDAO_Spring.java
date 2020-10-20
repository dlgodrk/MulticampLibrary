package biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import biz.board.vo.BoardVO;

@Component("boardspring")
public class BoardDAO_Spring implements BoardDAO{

	@Autowired
	JdbcTemplate template ;
	
	@Override
	public int addBoard(BoardVO board) throws Exception {
		String sql = 
				"insert into board (boardno, title, content, writer, viewcount) "+
						" values ((select nvl(max(boardno),0)+1 from board),?, ?, ?, 0)";
				
				return template.update(sql,
						               board.getTitle(),
						               board.getContent(),
						               board.getWriter()
						               );
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("Spring DAO ...");
		 String sql = "select * from board order by boardno desc";
		return template.query(sql, new BoardRowMapper());
	}

	@Override
	public int updateBoard(BoardVO board) {
		String sql = "update board set title=?,content=?"
		 		+ " where  boardno  = ? ";

		 return template.update(sql,
				                board.getTitle(),
				                board.getContent(),
				                board.getBoardno()
	               );	
	}

	@Override
	public int removeBoard(int boardno) {
		String sql = "delete from board where  boardno  = ? ";
		return template.update(sql,boardno);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "select * from board where upper("+ condition+") like  '%'||?||'%'";
		
		List<BoardVO> list =template.query(sql,
	              new Object[]{keyword.toUpperCase()},
	              new BoardRowMapper());
		
		System.out.println("----- "+list);
		return list;
	}

	@Override
	public BoardVO getBoard(int boardno) {
		String sql2 = "update board set viewcount=(select viewcount+1 from board where boardno="+boardno
			 		+ ") where boardno="+boardno;
		template.update(sql2);
		String sql = "select * from board where boardno = ?";
		BoardVO vo = null;
		 vo = template.queryForObject(sql, 
                                     new Object[] {boardno} ,
                                     new BoardRowMapper());
		 return vo;
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setBoardno(rs.getInt("boardno"));
		vo.setContent(rs.getString("content"));
		vo.setBoarddate(rs.getDate("boarddate").toString());
		vo.setTitle(rs.getString("title"));
		vo.setViewcount(rs.getInt("viewcount"));
		vo.setWriter(rs.getString("writer"));
		return vo;
	}
}

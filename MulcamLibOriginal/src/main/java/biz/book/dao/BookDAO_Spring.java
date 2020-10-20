package biz.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import biz.book.vo.BookVO;

@Component("bookspring")
public class BookDAO_Spring implements BookDAO{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public BookVO getBook(int bookKey) {
		String sql2 = "update book set viewcount=(select viewcount+1 from book where bookkey="+bookKey
		 		+ ") where bookKey="+bookKey;
		template.update(sql2);
		
		String sql = "select * from book where bookkey = ?";
		BookVO vo = null;
		 vo = template.queryForObject(sql, 
                                     new Object[] {bookKey} ,
                                     new BookRawMapper());
		
		 return vo;
	}

	@Override
	public List<BookVO> getBookList(String library, String option, String target) {
		System.out.println("SpringDAO...");
		String sql = "select * from book where upper("+option+") like '%'||?||'%' and libname = ?";
		System.out.println("북리스트1");
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			list = template.query(sql, new Object[] {target.toUpperCase(),library}, new BookRawMapper());
		} catch (Exception e) {
			
		}
		return list;
	}


	
	

	@Override
	public List<BookVO> bookViewList() {
		System.out.println("SpringDAO...");
		String sql = "select * from (select * from book order by viewcount desc) where rownum <= 3";
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			list = template.query(sql, new BookRawMapper());
		} catch (Exception e) {
		}
		
		return list;
		
		
	}
	
}



class BookRawMapper implements RowMapper<BookVO>{
	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookVO vo = new BookVO();
		vo.setBookKey(rs.getInt("bookKey"));
		vo.setLibName(rs.getString("libName"));
		vo.setManageCode(rs.getString("manageCode"));
		vo.setTitle(rs.getString("title"));
		vo.setAuthor(rs.getString("author"));
		vo.setPublisher(rs.getString("publisher"));
		vo.setPubYear(rs.getString("pubYear"));
		vo.setViewcount(rs.getInt("viewcount"));
		return vo;
	}
}
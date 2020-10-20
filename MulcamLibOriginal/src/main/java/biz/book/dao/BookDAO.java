  
package biz.book.dao;

import java.util.List;

import biz.book.vo.BookVO;

public interface BookDAO {
	BookVO getBook (int bookKey);
	List<BookVO> getBookList(String library,String option, String target);
	List<BookVO> bookViewList();
}
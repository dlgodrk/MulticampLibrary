  
package biz.book.service;

import java.util.List;

import biz.book.vo.BookVO;

public interface BookService {
	BookVO getBook(int bookKey);

	List<BookVO> getBookList(String library, String option, String target);

	List<BookVO> bookViewList();
}
package biz.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.book.dao.BookDAO;
import biz.book.vo.BookVO;

@Service("bookservice")
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO dao;

	@Override
	public BookVO getBook(int bookKey) {
		return dao.getBook(bookKey);
	}

	@Override
	public List<BookVO> getBookList(String library, String option, String target) {
		return dao.getBookList(library,option, target);
	}

	@Override
	public List<BookVO> bookViewList() {
		return dao.bookViewList();
	}
	
	
	
}
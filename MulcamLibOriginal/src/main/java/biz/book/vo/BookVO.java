package biz.book.vo;

public class BookVO {
	private int bookKey;
	private String libName;
	private String manageCode;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private int viewcount;
	
	public BookVO() {
	}

	public BookVO(int bookKey, String libName, String manageCode, String title, String author, String publisher,
			String pubYear, int viewcount) {
		super();
		this.bookKey = bookKey;
		this.libName = libName;
		this.manageCode = manageCode;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.viewcount = viewcount;
	}

	public int getBookKey() {
		return bookKey;
	}

	public void setBookKey(int bookKey) {
		this.bookKey = bookKey;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public String getManageCode() {
		return manageCode;
	}

	public void setManageCode(String manageCode) {
		this.manageCode = manageCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubYear() {
		return pubYear;
	}

	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	@Override
	public String toString() {
		return "BookVO [bookKey=" + bookKey + ", libName=" + libName + ", manageCode=" + manageCode + ", title=" + title
				+ ", author=" + author + ", publisher=" + publisher + ", pubYear=" + pubYear + ", viewcount="
				+ viewcount + "]";
	}
	
	 
	
	
	

}
package cn.key.entity;

import java.util.Date;


public class BookInfo {
	private int bookId;
	private String bookName;
	private int booktypeId;
	private String pbName;
	private String author;
	private String context;
	private String smallImg;
	private String bigImg;
	private float price;
	private Date pbdate;
	private int bookStates;
	private float ygcprice;
	public BookInfo() {
		super();
	}
	public BookInfo(String bookName, int booktypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			float price, Date pbdate, int bookStates, float ygcprice) {
		super();
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.bookStates = bookStates;
		this.ygcprice = ygcprice;
	}
	public BookInfo(String bookName, int booktypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			float price, Date pbdate, float ygcprice) {
		super();
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.ygcprice = ygcprice;
	}
	public BookInfo(int bookId, String bookName, int booktypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			float price, Date pbdate, int bookStates, float ygcprice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.bookStates = bookStates;
		this.ygcprice = ygcprice;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBooktypeId() {
		return booktypeId;
	}
	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}
	public String getPbName() {
		return pbName;
	}
	public void setPbName(String pbName) {
		this.pbName = pbName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPbdate() {
		return pbdate;
	}
	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}
	public int getBookStates() {
		return bookStates;
	}
	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}
	public float getYgcprice() {
		return ygcprice;
	}
	public void setYgcprice(float ygcprice) {
		this.ygcprice = ygcprice;
	}
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName
				+ ", booktypeId=" + booktypeId + ", pbName=" + pbName
				+ ", author=" + author + ", context=" + context + ", smallImg="
				+ smallImg + ", bigImg=" + bigImg + ", price=" + price
				+ ", pbdate=" + pbdate + ", bookStates=" + bookStates
				+ ", ygcprice=" + ygcprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + booktypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((pbName == null) ? 0 : pbName.hashCode());
		result = prime * result + ((pbdate == null) ? 0 : pbdate.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
		result = prime * result + Float.floatToIntBits(ygcprice);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (booktypeId != other.booktypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (pbdate == null) {
			if (other.pbdate != null)
				return false;
		} else if (!pbdate.equals(other.pbdate))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		if (Float.floatToIntBits(ygcprice) != Float
				.floatToIntBits(other.ygcprice))
			return false;
		return true;
	}
}

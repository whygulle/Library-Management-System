package Com.BeanPackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class BookIssue {

//	@Id
//	@Column(name="book_id")
	private int bookId;
	private String useremail;
	private String bookName;
	private String issueDate;
	private String returnDate;

	
	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
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

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	

	@Override
	public String toString() {
		return "BookIssue [bookId=" + bookId + ", userId=" + useremail + ", bookName=" + bookName + ", issueDate="
				+ issueDate + ", returnDate=" + returnDate + "]";
	}

	public BookIssue() {
		super();
		// TODO Auto-generated constructor stub
	}

}

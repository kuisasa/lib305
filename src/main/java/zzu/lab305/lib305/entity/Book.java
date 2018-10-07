package zzu.lab305.lib305.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer bookId;

    private String bookName;

    private String bookCategory;

    private Boolean bookStatus;

    private String bookUser;

    private String bookCodeimg;

    private String bookAuthor;

    private Date bookOutTime;

    private Date bookReTime;

    private static final long serialVersionUID = 1L;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory == null ? null : bookCategory.trim();
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookUser() {
        return bookUser;
    }

    public void setBookUser(String bookUser) {
        this.bookUser = bookUser == null ? null : bookUser.trim();
    }

    public String getBookCodeimg() {
        return bookCodeimg;
    }

    public void setBookCodeimg(String bookCodeimg) {
        this.bookCodeimg = bookCodeimg == null ? null : bookCodeimg.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Date getBookOutTime() {
        return bookOutTime;
    }

    public void setBookOutTime(Date bookOutTime) {
        this.bookOutTime = bookOutTime;
    }

    public Date getBookReTime() {
        return bookReTime;
    }

    public void setBookReTime(Date bookReTime) {
        this.bookReTime = bookReTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getBookCategory() == null ? other.getBookCategory() == null : this.getBookCategory().equals(other.getBookCategory()))
            && (this.getBookStatus() == null ? other.getBookStatus() == null : this.getBookStatus().equals(other.getBookStatus()))
            && (this.getBookUser() == null ? other.getBookUser() == null : this.getBookUser().equals(other.getBookUser()))
            && (this.getBookCodeimg() == null ? other.getBookCodeimg() == null : this.getBookCodeimg().equals(other.getBookCodeimg()))
            && (this.getBookAuthor() == null ? other.getBookAuthor() == null : this.getBookAuthor().equals(other.getBookAuthor()))
            && (this.getBookOutTime() == null ? other.getBookOutTime() == null : this.getBookOutTime().equals(other.getBookOutTime()))
            && (this.getBookReTime() == null ? other.getBookReTime() == null : this.getBookReTime().equals(other.getBookReTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getBookCategory() == null) ? 0 : getBookCategory().hashCode());
        result = prime * result + ((getBookStatus() == null) ? 0 : getBookStatus().hashCode());
        result = prime * result + ((getBookUser() == null) ? 0 : getBookUser().hashCode());
        result = prime * result + ((getBookCodeimg() == null) ? 0 : getBookCodeimg().hashCode());
        result = prime * result + ((getBookAuthor() == null) ? 0 : getBookAuthor().hashCode());
        result = prime * result + ((getBookOutTime() == null) ? 0 : getBookOutTime().hashCode());
        result = prime * result + ((getBookReTime() == null) ? 0 : getBookReTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookCategory=").append(bookCategory);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", bookUser=").append(bookUser);
        sb.append(", bookCodeimg=").append(bookCodeimg);
        sb.append(", bookAuthor=").append(bookAuthor);
        sb.append(", bookOutTime=").append(bookOutTime);
        sb.append(", bookReTime=").append(bookReTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package by.htp.entity;

import java.math.BigDecimal;
import java.util.Date;
import by.htp.entity.*;

public class Exhibition extends Event{
	
	private String Author;
	private String theme;
	
	public Exhibition() {
		super();
	}

	public Exhibition(String author, String theme,String place, BigDecimal price, Date date, String time, String title) {
		super();
		Author = author;
		this.theme = theme;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Author == null) ? 0 : Author.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exhibition other = (Exhibition) obj;
		if (Author == null) {
			if (other.Author != null)
				return false;
		} else if (!Author.equals(other.Author))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exhabition [Author=" + Author + ", theme=" + theme + "]";
	}
	
	

}


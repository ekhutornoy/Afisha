package by.htp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Opera extends Event {
	
	private Singer singer;
	
	public Opera() {
		super();
	}
		

	public Opera(Singer singer, String place, BigDecimal price, Date date, String time, String Title) {
		super(place, price, date, time, Title);
		this.singer = singer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
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
		Opera other = (Opera) obj;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		return true;
	}


	public Singer getSinger() {
		return singer;
	}


	public void setSinger(Singer singer) {
		this.singer = singer;
	}


	@Override
	public String toString() {
		return super.toString() + "Opera [singer=" + singer + "]";
	}

	
}

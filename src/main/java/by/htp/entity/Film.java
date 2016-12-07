package by.htp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Film extends Event {

	private Janre janre;
	private double rating;
	
	public Film() {
		super();
	}

	public Film(Janre janre, double rating, String place, BigDecimal price,  Date date, String time, String Title) {
		super(place, price, date, time, Title);
		this.janre = janre;
		this.rating = rating;
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((janre == null) ? 0 : janre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Film other = (Film) obj;
		if (janre != other.janre)
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}

	public Janre getJanre() {
		return janre;
	}

	public void setJanre(Janre janre) {
		this.janre = janre;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return super.toString() + "Film [janre=" + janre + ", rating=" + rating +  "]";
	}

	
	
	
}

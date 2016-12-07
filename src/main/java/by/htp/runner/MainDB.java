package by.htp.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MainDB {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");

			Statement st = connection.createStatement();
			/*
			 int add = st.executeUpdate("INSERT INTO event (title, place,
			 price, date, time, singer, jenre, rating) VALUES ('Film4',
			 'Salut', '12', '2016-11-27', '19:00:00', '---', 'drama',
			 '4.5');");
			  */

			int del = st.executeUpdate("DELETE FROM event WHERE rating<3;");

			ResultSet rs = st.executeQuery("SELECT * FROM event WHERE place='Salut';");

			while (rs.next()) {

				String title = rs.getString("title");
				System.out.print("Title: " + title + "; ");
				String place = rs.getString("place");
				System.out.print("Place: " + place + "; ");
				Date date = rs.getDate("date");
				System.out.print("Date: " + date + "; ");
				String singer = rs.getString("singer");
				System.out.print("Singer: " + singer + "; ");
				String jenre = rs.getString("jenre");
				System.out.println("Jenre: " + jenre + "; ");
				Double rating = rs.getDouble("rating");
				System.out.println("Rating: " + rating + ". ");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// вынести в try с ресурсами
				e.printStackTrace();
			}
		}

	}

}

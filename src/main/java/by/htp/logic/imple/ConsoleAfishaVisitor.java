package by.htp.logic.imple;

import java.io.*;

import java.util.Date;

import by.htp.entity.Afisha;
import by.htp.entity.Event;
import by.htp.logic.AfishaVisitor;

public class ConsoleAfishaVisitor implements AfishaVisitor {

	public void loadAfisha(Afisha afisha) {

		for (Event event : afisha.getEvents()) {
			System.out.println(event);
		}
	}

	@Override
	public Afisha loadAfisha() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void write(String fileName, String text) {
		File file = new File(fileName);

		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {

				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}


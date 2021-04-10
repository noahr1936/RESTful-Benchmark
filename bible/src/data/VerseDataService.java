package data;

import beans.Verse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class VerseDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class VerseDataService implements DataAccessInterface {

	public VerseDataService() {
		// TODO Auto-generated constructor stub
	}

	Database d = new Database();

	public Verse findVerse(String book, int chapter, int verse) {
		Verse returnedVerse = new Verse();

		String newChapter = Integer.toString(chapter);

		String sql = "SELECT * FROM bible.bibletable WHERE book = ? AND chapter = ? AND verse = ? LIMIT 1";

		try {
			Connection conn = d.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book);
			pstmt.setString(2, newChapter);
			pstmt.setInt(3, verse);

			ResultSet rs = pstmt.executeQuery();

//			System.out.println("In data service");
			
			while (rs.next()) {
				returnedVerse = new Verse(rs.getString("BOOK"), rs.getInt("CHAPTER"), rs.getInt("VERSE"),
						rs.getString("TEXT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnedVerse;
	}
	
	public Verse testVerse() {
		Verse returnedVerse = null;


		String sql = "SELECT * FROM bible.bibletable WHERE book = 'John' AND chapter = '3' AND verse = 16 LIMIT 1";

		try {
			Connection conn = d.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				returnedVerse = new Verse(rs.getString("BOOK"), rs.getInt("CHAPTER"), rs.getInt("VERSE"),
						rs.getString("TEXT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnedVerse;
	}
	

}

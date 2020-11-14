package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) throws SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"INSERT INTO seller "
			+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
			+ "VALUES " 
			+ "(?, ?, ?, ?, ?)");

			st.setString(1, "Sam Winchester");
			st.setString(2, "sam.caca@fantasmas.com");
			st.setDate(3, new java.sql.Date(sdf.parse("12/12/1980").getTime()));
			st.setDouble(4, 4500.0);
			st.setInt(5, 1);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {

			DB.closeConnection();
		}
	}
}

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

	
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller "
			+ "SET BaseSalary = BaseSalary + ? "
			+ "WHERE " 
			+ "(DepartmentId = ?)");

			st.setDouble(1, 700);
			st.setInt(2, 1);
			
			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			DB.closeConnection();
		}
	}
}

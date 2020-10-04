package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertData {
	public static void main(final String[] args) throws SQLException {
		final String URL = "jdbc:mysql://localhost:3306/dbsiswa";
		final String USER = "root";
		final String PWD = "root";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);

			final String sql = "insert into tsiswa(nama, nim) values(?,?)";
			final PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, "Joko");
			pst.setString(2, "234242342");
			final int affectedRow = pst.executeUpdate();

			System.out.println(affectedRow + " records inserted");

		} catch (final Exception ex) {
			ex.printStackTrace();
		}finally {
			conn.close();
		}
	}
}

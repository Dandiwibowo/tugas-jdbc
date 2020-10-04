package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	public static void main(final String[] args) throws SQLException {
		final String URL = "jdbc:mysql://localhost:3306/mapblitar";
		final String USER = "root";
		final String PWD = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);

			final Statement st = conn.createStatement();
			final String sql = "select * from lokasi";
			final ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Nama: " + rs.getString("nama"));
				System.out.println("NIM: " + rs.getString("deskripsi"));
				System.out.println("----------------------");
			}

		} catch (final Exception ex) {
			ex.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
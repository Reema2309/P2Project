

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

		private Connection conn;
		
		public DBConnection(String dbUrl, String user, String pwd) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(dbUrl,user,pwd);
		}
		
		public Connection getConnection() {
			return this.conn;
		}
		
		public void closeConnection() throws SQLException{
			if (this.conn!=null)
				this.conn.close();
		}
}



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class filterStudentByClass
 */
@WebServlet("/filterStudentByClass")
public class filterStudentByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterStudentByClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String filterStudentByClass = request.getParameter("filterStudentByClass");
			out.println("<html><body>");
			out.println("<style> body {background-image: url('background4.jpg'); background-repeat: no-repeat; background-attachment: fixed;background-size: cover;color: white;}</style>");
			
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);
			
			DBConnection conn = new DBConnection(props.getProperty("url"),props.getProperty("userid") ,props.getProperty("password"));	
			
			Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int rowCount = 0 ;
			ResultSet rst = stmt.executeQuery("select class.classID,student.studentName,student.subjectID from class inner join student on class.classID=student.studentClass where studentClass="+filterStudentByClass+"");
			
				out.println("<TABLE BORDER=1>");
				ResultSetMetaData rmd = (ResultSetMetaData) rst.getMetaData();
				int columnCount = rmd.getColumnCount();
				out.println("Printing tables <br>");
				out.println("=======================================================================================");
				out.println("<br>");
				out.println("<TR>");
				for (int i = 1; i <= columnCount; i++) {
					out.println("<TH>" + rmd.getColumnName(i) + "</TH>");
					
				}
				out.println("</TR>");
				out.println("<br>");
				
				while (rst.next()) {
					rowCount++;
					out.println("<TR>");
					for (int i = 0; i < columnCount; i++) {
						out.println("<TD>" + rst.getString(i + 1) + "</TD>");
				    }
						out.println("</TR>");
					}
					out.println("</TABLE>");
			
			stmt.close();
			
			out.println("</body></html>");
			conn.closeConnection();
		}catch(Exception e) {
			out.print("Invalid student class entered, please enter valid student class!!!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

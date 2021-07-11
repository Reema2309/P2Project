

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginValidate
 */
@WebServlet("/loginValidate")
public class loginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(user.equalsIgnoreCase("admin")) {
			if(password.equals("1234")){
				response.sendRedirect("options.html");
			}
			else {
				out.println("Invalid password for admin!!!");
			}
		}else {
			out.println("Access denied as user is not admin!!!");
		}
	}

}

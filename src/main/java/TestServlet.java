import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pilyak.testmavenproject.dao.UserDao;
import com.pilyak.testmavenproject.dao.impl.DefaultUserDao;
import com.pilyak.testmavenproject.models.UserData;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance(); 
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpSession session = req.getSession(false);
		UserData user = userDao.getUserByID(Integer.valueOf(req.getParameter("id")));
		//List<UserData> user = userDao.getAllUsers();
		//resp.getWriter().println(user);
		req.setAttribute("logUser", user);
		req.getRequestDispatcher("WEB-INF/request/registerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

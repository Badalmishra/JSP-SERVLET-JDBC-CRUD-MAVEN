

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.Todo;
import com.todo.TodoDao;

/**
 * Servlet implementation class AddTodo
 */
public class AddTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int id = Integer.parseInt(request.getParameter("body"));
//		TodoDao dao = null;
//		Todo todo = null;
//		try {
//			dao = new TodoDao();
//			todo = (Todo) dao.showTodo(id);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}-
		String Body = request.getParameter("body");
		Todo todo = null;
		TodoDao dao =null;
		try {
			dao = new TodoDao();
			todo = (Todo) dao.addTodo(Body);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("todo", todo);
		RequestDispatcher rd = request.getRequestDispatcher("/showAllTodos");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

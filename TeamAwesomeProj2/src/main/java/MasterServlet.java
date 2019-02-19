import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj2.exception.UserNotFoundException;

public class MasterServlet extends HttpServlet{

private static final long serialVersionUID = 1L;

	
	// This is the object responsible for marshalling/unmarshalling POJOS to JSON
	private final ObjectMapper mapper = new ObjectMapper();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BasicConfigurator.configure();

		System.out.println("doGet works");
		resp.setContentType("application/json");
		try {
			resp.getWriter().append(mapper.writeValueAsString(MasterDispatcher.doget(req, resp)));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost works");
		resp.setContentType("application/json");
		try {
			resp.getWriter().append(mapper.writeValueAsString(MasterDispatcher.dopost(req, resp)));
		} catch (SQLException | UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut works");
		resp.setContentType("application/json");
		try {
			resp.getWriter().append(mapper.writeValueAsString(MasterDispatcher.doput(req, resp)));
		} catch (SQLException | UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doDelete works.");
		resp.setContentType("application/json");
		try {
			resp.getWriter().append(mapper.writeValueAsString(MasterDispatcher.dodelete(req, resp)));
		} catch (SQLException | UserNotFoundException e) {
			e.printStackTrace();
		}
	}
}


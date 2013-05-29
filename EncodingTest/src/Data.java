import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("데이터 처리 " + getClass().getName());
		
		JSONObject resData = new JSONObject();
		resData.put("text", "한글 오케이?");
		resData.put("Eng", "This is in English!!!");
		
		System.out.println("Before setCharacterEncoding ==> " + resData.toString());
		System.out.println("Before set CharacterEncoding ==> " + response.getCharacterEncoding());
		
		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
//		response.setContentType("application/x-json;  charset=UTF-8");
		
//		response.setLocale(Locale.ENGLISH);

		System.out.println("After setCharacterEncoding ==> " + resData.toString());
		System.out.println("After set CharacterEncoding ==> " + response.getCharacterEncoding());
		System.out.println("Content Type ==> " + response.getContentType());
		System.out.println("servelt info ==> " + response.encodeURL(getServletInfo()));
		System.out.println(response.getHeaderNames().toString());
		System.out.println(response.getLocale());
		System.out.println(response.getStatus());
		
		PrintWriter out = response.getWriter();
        
		if (resData != null) {
			out.print(resData);
		}
		
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

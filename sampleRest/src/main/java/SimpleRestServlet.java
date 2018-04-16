import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleRestServlet extends HttpServlet {
    private List<String> kolekcja;

    public SimpleRestServlet()
    {
        kolekcja = new ArrayList<String>();

    }
    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,
            IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
            for (String s:kolekcja) {
            response.getWriter().println("<h1>"+s+"</h1>");

        }

    }


    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response )
            throws ServletException,  IOException
    {

        kolekcja.add(request.getReader().readLine());
    }
}

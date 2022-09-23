package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hsp28
 */
public class AgeCalculatorServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
//        When the user hits the submit buttton in the web page

        String age = request.getParameter("age");
        
        if (age == null || age == "") 
        {
            request.setAttribute("ageEmpty", "You must give your current age");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
            return;
        }
        
//        Parsing the value of age to integer and then increasing it by 1
        int ageIntVal = Integer. parseInt(age);
        ageIntVal += 1;
        
//        Passing the age value to the jsp
        request.setAttribute("ageIntVal", "Your next birthday will be: " +ageIntVal);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
        .forward(request, response);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hsp28
 */
public class ArithmeticCalculatorServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
        .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String calc = request.getParameter("calc");
        
        if (first == null || first.equals("") || last == null || last.equals(""))
        {
            request.setAttribute("result", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
            .forward(request, response);
            return;
        }
        
        int fInt = Integer.parseInt(first);
        int lInt = Integer.parseInt(last);
        
        int finalResult = 0;
        
        if (calc.equals("+"))
            finalResult = fInt + lInt;
        else if (calc.equals("-"))
            finalResult = fInt - lInt; 
        else if (calc.equals("*"))
            finalResult = fInt * lInt; 
        else if (calc.equals("%"))
            finalResult = fInt / lInt;
        
        request.setAttribute("result", finalResult);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
        .forward(request, response);
    }
}

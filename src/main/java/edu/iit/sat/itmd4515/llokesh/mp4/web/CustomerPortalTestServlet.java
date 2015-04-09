/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.web;

import edu.iit.sat.itmd4515.llokesh.mp4.service.CustomerService;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Category;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Customer;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Manufacturer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spyrisos
 */
@WebServlet(name = "CustomerPortalTestServlet", urlPatterns = {"/customerPortal","/customerPortal/"})
public class CustomerPortalTestServlet extends HttpServlet {

    @EJB
    private CustomerService customerService;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductPortalTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"");
            out.println("<div class=\"row\">\n" +
"                        <div class=\"col-md-4\">");
            out.println("<h1>customer details are " + request.getContextPath() + "</h1>");

            out.println("<h2>" + request.getRemoteUser() + "</h2>");

            String test = request.getRemoteUser();
            String test1 = request.toString();
            if (request.isUserInRole("fan")) 
            {
                Customer customer = customerService.findByUsername(request.getRemoteUser());
                out.println("<style>\n" +
"  body {background-color:lightgray}\n" +
"  h1   {color:blue}\n" +
"  p    {color:green}\n" +
"</style>");
                out.println("<ul>");
                out.println("<li>Customer name is: " + customer.getCust_name() + "</li> ");
                out.println("<li>Customer has the following address : " + customer.getCust_address() + "</li>");
                        out.println("</ul></li>");
                    } else {
                        out.println("</li>");
                    }
                
                out.println("</ul></li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</div>");
            

            out.println("<a href=\"" + request.getContextPath() + "/logout\">Logout</a>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e){
            log(e.getMessage());
        }
    }
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


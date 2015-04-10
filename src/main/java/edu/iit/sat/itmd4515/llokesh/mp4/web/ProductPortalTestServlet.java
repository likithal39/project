/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.llokesh.mp4.web;

import edu.iit.sat.itmd4515.llokesh.mp4.service.ManufacturerService;
import edu.iit.sat.itmd4515.llokesh.mp4.service.ProductService;
import edu.iit.sat.itmd4515.llokesh.mp4.domain.Category;
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
@WebServlet(name = "ProductPortalTestServlet", urlPatterns = {"/productPortal", "/productPortal/"})
public class ProductPortalTestServlet extends HttpServlet {

    @EJB
    private ManufacturerService manufacturerService;

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
            out.println("<h1>Manufacturer details are " + request.getContextPath() + "</h1>");

            out.println("<h2>" + request.getRemoteUser() + "</h2>");

            String test = request.getRemoteUser();
            String test1 = request.toString();
            if (request.isUserInRole("manufacturer")) 
            {
                Manufacturer manufacturer = manufacturerService.findByUsername(request.getRemoteUser());
                out.println("<style>\n" +
"  body {background-color:lightgray}\n" +
"  h1   {color:blue}\n" +
"  p    {color:green}\n" +
"</style>");
                out.println("<ul>");
                out.println("<li>Manufacturer name is: " + manufacturer.getMan_name() + "</li> ");
                out.println("<li>Manufacturer belongs to the following company : " + manufacturer.getMan_title() + "</li>");
                out.println("<li>Consists of products of names: " + manufacturer.getProduct().getProd_name() + "</li>");
                out.println("<li>Products have further following categories:<ul>");
                for (Category s : manufacturer.getCategories()) {
                    out.println("<li>" + s.getCategory_name() + " on " + s.getProduct().getProd_name());
                    // if more than one dj
                    if (s.getManufacturers().size() > 1) {
                        out.println("with <ul>");
                        for (Manufacturer d : s.getManufacturers()) {
                            // if not logged in user
                            if (d.getMan_id() != manufacturer.getMan_id()) {
                                out.println("<li>Manufacturer " + d.getMan_name()+ "</li>");
                            }
                        }
                        out.println("</ul></li>");
                    } else {
                        out.println("</li>");
                    }
                }
                out.println("</ul></li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</div>");
            }

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


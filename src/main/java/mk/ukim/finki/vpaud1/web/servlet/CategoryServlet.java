package mk.ukim.finki.vpaud1.web.servlet;

import mk.ukim.finki.vpaud1.model.Category;
import mk.ukim.finki.vpaud1.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static mk.ukim.finki.vpaud1.bootstrap.DataHolder.categories;

@WebServlet(name = "category", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");

        PrintWriter out = resp.getWriter();
        out.println("<html><head></head><body><h2>Category List</h2><ul>");
        categories.forEach( r ->
                out.format("<li> %s %s</li>", r.getName(), r.getDescription())
        );

        out.format("</ul> " +
                "<h2>USER INFO: ipAddres: %s </br> clientAgent: %s</h2>" +
                "</body></html>", ipAddress, clientAgent);

        out.println("Add a new category: ");
        out.println("<form method='POST' action='/servlet/category'>" +
                "<label for='name'>Name:</label><input id='name' type='text' name='name'/> " +
                "<label for='desc'>Description:</label><input id='desc' type='text' name='desc'/>" +
                "<input type='submit' value='Submit'/>" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDesc = req.getParameter("desc");

        categoryService.create(categoryName, categoryDesc);
        resp.sendRedirect("/servlet/category");
    }

    /*public void addCategory(String name) {
        if (name != null && !name.isEmpty()) {
            this.categoryList.add(new Category(name));
        }
    }*/
}



import edu.miu.cs.cs472.finalexam.srmwebapp.model.Product;
import edu.miu.cs.cs472.finalexam.srmwebapp.model.Supplier;
import edu.miu.cs.cs472.finalexam.srmwebapp.service.ProductService;
import edu.miu.cs.cs472.finalexam.srmwebapp.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "ProductController", urlPatterns = {"/product/list", "/product/new"})
public class ProductController extends HttpServlet {

    private ProductService productService;
    private SupplierService supplierService;

    public ProductController() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Request.getRequestURI: " + request.getRequestURI());
        System.out.println("Request.getContextPath: " + request.getContextPath());
        System.out.println("Request.getPathInfo: " + request.getPathInfo());
        System.out.println("Request.getPathTranslated: " + request.getPathTranslated());
        System.out.println("Request.getServletPath: " + request.getServletPath());
        System.out.println("Request.getRequestURL_StringBuffer: " + request.getRequestURL().toString());
        String[] pathParts = request.getServletPath().split("/");
        Arrays.stream(pathParts).forEach(System.out::println);
        if(pathParts[2].equals("list")) {
            request.setAttribute("pagename", "products");
            List<Product> productsList = this.productService.getAllProductsSorted();
            request.setAttribute("numProductsInList", productsList.size());
            request.setAttribute("productsList", productsList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/products-list.jsp");
            requestDispatcher.forward(request, response);
        } else if (pathParts[2].equals("new")) {
            // TODO
        }
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        if(servletContext.getAttribute("suppliers") != null &&
                servletContext.getAttribute("products") != null) {
            this.supplierService = new SupplierService((ConcurrentHashMap<String, Supplier>)servletContext.getAttribute("suppliers"),
                    (ConcurrentHashMap<String, Product>)servletContext.getAttribute("products"));
            this.productService = new ProductService((ConcurrentHashMap<String, Supplier>)servletContext.getAttribute("suppliers"),
                    (ConcurrentHashMap<String, Product>)servletContext.getAttribute("products"));
        }
    }
}

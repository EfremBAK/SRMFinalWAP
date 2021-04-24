package edu.miu.cs.cs472.finalexam.srmwebapp.config;

import edu.miu.cs.cs472.finalexam.srmwebapp.model.Product;
import edu.miu.cs.cs472.finalexam.srmwebapp.model.Supplier;
import edu.miu.cs.cs472.finalexam.srmwebapp.repository.SRMDataRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener()
public class SRMWebApplicationListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public SRMWebApplicationListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ServletContext servletContext = sce.getServletContext();
        Map<String, Supplier> suppliers = new ConcurrentHashMap<>();
        suppliers.putIfAbsent("S10001", new Supplier("S10001", "El Segundo Agro Products, Inc"));
        suppliers.putIfAbsent("S10002", new Supplier("S10002", "Organic Farms of Des Moines"));
        suppliers.putIfAbsent("S10003", new Supplier("S10003", "United WholeFoods Corporation"));
        Map<String, Product> products = new ConcurrentHashMap<>();
        products.putIfAbsent("P1000001", new Product("P1000001", "Apples", 1.49, 156, LocalDate.of(2020,4,29), suppliers.get("S10001")));
        products.putIfAbsent("P1000002", new Product("P1000002", "Bananas", 2.25, 48, LocalDate.of(2020, 5,13), suppliers.get("S10003")));
        products.putIfAbsent("P1000003", new Product("P1000003", "Pears", 5.55, 127, LocalDate.of(2019,4,27), suppliers.get("S10002")));
        products.putIfAbsent("P1000004", new Product("P1000004", "Avocados", 4.65, 125, LocalDate.of(2020,5,11), suppliers.get("S10003")));
//        SRMDataRepository srmDataRepository = new SRMDataRepository(suppliers, products);
        servletContext.setAttribute("suppliers", suppliers);
        servletContext.setAttribute("products", products);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}

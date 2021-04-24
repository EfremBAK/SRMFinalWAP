<%--
  Created by IntelliJ IDEA.
  User: obi
  Date: 5/14/2020
  Time: 02:23 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CS472-WAP - WallyMarty - Supplier Relationship Management (SRM) system - Products</title>
    <%@include file="../fragments/header.jsp"%>

    <div class="container" style="margin-top: 1em;">
<%--        <div>--%>
<%--            <span style="font-size: 1.5em">List of Products in stock</span>--%>
<%--            <span style="float:right;">--%>
<%--                <a class="btn btn-outline-primary btn-lg" href="/SRMWebApp/product/new">Add a New Product</a>--%>
<%--            </span>--%>
<%--        </div>--%>
        <h3>List of Products in stock</h3>
        <div>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Product ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Unit Price</th>
                    <th scope="col">Qty in Stock</th>
                    <th scope="col">Supplier</th>
                    <th scope="col">Date Supplied</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${numProductsInList gt 0}">
                        <c:forEach var="product" items="${productsList}" varStatus="iteration">
                        <tr>
                            <th scope="row"><c:out value="${iteration.index+1}"></c:out>.</th>
                            <td><c:out value="${product.productId}"></c:out></td>
                            <td><c:out value="${product.name}"></c:out></td>
                            <td><c:out value="${product.unitPrice}"></c:out></td>
                            <td><c:out value="${product.quantityInStock}"></c:out></td>
                            <td><c:out value="${product.supplier.name}"></c:out></td>
                            <td><c:out value="${product.dateSupplied}"></c:out></td>
                        </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="7" style="text-align: center;">No Products available in stock</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>

    <%@include file="../fragments/footer.jsp"%>

</body>
</html>

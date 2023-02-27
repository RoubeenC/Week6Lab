<%-- 
    Document   : shoppingList
    Created on : Feb 14, 2023, 8:25:17 AM
    Author     : Roubeen Chaudhry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    
    
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
            <a href="ShoppingList?action=logout">Logout</a>
        
        <form action="" method="post">
            <h2>List</h2>
            Add item: <input type="text" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
         
        </form>
        
         <form action="" method="post">
            <c:forEach var="item" items="${items}">
                <br> 
                    <input type="radio" name="${item}" value="${item}">${item}
                </br>
            </c:forEach>
            <button type="submit">Delete</button>
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>

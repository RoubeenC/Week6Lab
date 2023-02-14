<%-- 
    Document   : shoppingList
    Created on : Feb 14, 2023, 8:25:17 AM
    Author     : Roubeen Chaudhry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${sessionusername.username}</p>
        
        <form>
            <h2>List</h2>
            Add Item: <input type="text" name="shoppingInput">
        </form>
    </body>
</html>

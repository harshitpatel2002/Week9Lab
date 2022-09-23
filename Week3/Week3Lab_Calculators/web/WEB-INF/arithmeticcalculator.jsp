<%-- 
    Document   : arithmeticcalculator
    Created on : 22-Sep-2022, 8:59:53 AM
    Author     : hsp28
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" value="" name="first"><br>
            Second: <input type="text" value="" name="last"><br>
            <input type="submit" value="+" name="calc">
            <input type="submit" value="-" name="calc">
            <input type="submit" value="*" name="calc">
            <input type="submit" value="%" name="calc">
        </form>
        <p>Result: ${result}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>

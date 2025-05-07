<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Management System</title>
    <style>
        /* Basic styles to verify template loading */
        body { margin: 0; padding: 20px; font-family: Arial, sans-serif; }
        .container { max-width: 1200px; margin: 0 auto; }
        .header { background: #333; color: white; padding: 20px; margin-bottom: 20px; }
        .nav { background: #f4f4f4; padding: 10px; margin-bottom: 20px; }
        .nav a { margin-right: 15px; color: #333; text-decoration: none; }
        .nav a:hover { color: #666; }
        .page-title { color: #333; margin-bottom: 20px; }
        .welcome-content { margin: 20px 0; }
        .actions { margin-top: 20px; }
        .btn { display: inline-block; padding: 10px 20px; background: #333; color: white; text-decoration: none; margin-right: 10px; }
        .btn:hover { background: #444; }
    </style>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
    <div class="container">
        <header class="header">
            <h1>Book Management System</h1>
        </header>
        
        <nav class="nav">
            <div class="nav-brand">
                <a href="/" class="nav-link">Home</a>
            </div>
            <div class="nav-menu">
                <a href="/authors" class="nav-link">Authors</a>
                <a href="/books" class="nav-link">Books</a>
            </div>
        </nav>

        <main>
            <c:if test="${not empty content}">
                <jsp:include page="/WEB-INF/jsp/${content}.jsp" />
            </c:if>
        </main>
    </div>
</body>
</html> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="page-title">Welcome to Book Management System</h2>

<div class="welcome-content">
    <p>This system allows you to manage authors and their books. You can:</p>
    <ul>
        <li>Add, edit, and delete authors</li>
        <li>Add, edit, and delete books</li>
        <li>Associate books with authors</li>
    </ul>
    
    <div class="actions">
        <a href="/authors" class="btn btn-primary">Manage Authors</a>
        <a href="/books" class="btn btn-primary">Manage Books</a>
    </div>
</div> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="page-title">Authors</h2>

<a href="/authors/new" class="btn btn-primary">Add New Author</a>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.name}</td>
                <td>${author.email}</td>
                <td class="actions">
                    <a href="/authors/edit/${author.id}" class="btn btn-primary">Edit</a>
                    <form action="/authors/delete/${author.id}" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this author?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table> 
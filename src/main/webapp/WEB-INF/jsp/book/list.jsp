<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="page-title">Books</h2>

<a href="/books/new" class="btn btn-primary">Add New Book</a>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Publication Date</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.author.name}</td>
                <td>${book.isbn}</td>
                <td>${book.publicationDate}</td>
                <td class="actions">
                    <a href="/books/edit/${book.id}" class="btn btn-primary">Edit</a>
                    <form action="/books/delete/${book.id}" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this book?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table> 
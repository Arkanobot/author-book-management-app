<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="page-title">${book.id == null ? 'Add New Book' : 'Edit Book'}</h2>

<form action="${book.id == null ? '/books' : '/books/update/'.concat(book.id)}" method="post">
    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${book.title}" required>
    </div>
    
    <div class="form-group">
        <label for="author">Author:</label>
        <select id="author" name="author.id" required>
            <option value="">Select an author</option>
            <c:forEach items="${authors}" var="author">
                <option value="${author.id}" ${book.author != null && book.author.id == author.id ? 'selected' : ''}>
                    ${author.name}
                </option>
            </c:forEach>
        </select>
    </div>
    
    <div class="form-group">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${book.isbn}" required>
    </div>
    
    <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${book.price}" step="0.01" min="0" required>
    </div>
    
    <div class="form-group">
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4">${book.description}</textarea>
    </div>
    
    <div class="form-group">
        <label for="publicationDate">Publication Date:</label>
        <input type="date" id="publicationDate" name="publicationDate" value="${book.publicationDate}" required>
    </div>
    
    <div class="actions">
        <button type="submit" class="btn btn-primary">${book.id == null ? 'Add Book' : 'Update Book'}</button>
        <a href="/books" class="btn btn-danger">Cancel</a>
    </div>
</form> 
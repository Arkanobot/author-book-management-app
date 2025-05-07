<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="page-title">${author.id == null ? 'Add New Author' : 'Edit Author'}</h2>

<form action="${author.id == null ? '/authors' : '/authors/update/'.concat(author.id)}" method="post">
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${author.name}" required>
    </div>
    
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${author.email}" required>
    </div>
    
    <div class="form-group">
        <label for="biography">Biography:</label>
        <textarea id="biography" name="biography" rows="4">${author.biography}</textarea>
    </div>
    
    <div class="actions">
        <button type="submit" class="btn btn-primary">${author.id == null ? 'Add Author' : 'Update Author'}</button>
        <a href="/authors" class="btn btn-danger">Cancel</a>
    </div>
</form> 
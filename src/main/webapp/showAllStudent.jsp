<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Etudiant</title>
    <style>
        <%@ include file="/css/font.css" %>
        <%@ include file="/css/bootstrap.min.css" %>
        <%@ include file="/css/material.css" %>
        <%@ include file="/css/font-awesome.min.css" %>
        <%@ include file="/css/style.css" %>
    </style>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <%@include file="Header.jsp" %>
            <br>
            <div>
                <a href="add.s" class="btn btn-info">Ajouter</a>
            </div>
            <br>
            <c:if test="${studentSize < 1}">
                <p>Aucun étudiant disponible</p>
            </c:if>
            <c:if test="${studentSize > 0}">
                <table class="table table-bordered table-hover" id="tableStudent">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th>Immatricule</th>
                        <th>Nom</th>
                        <th>Ages</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td scope="row">${student.id}</td>
                            <td>${student.registered }</td>
                            <td>${student.name }</td>
                            <td style="text-align: right;">${student.age }</td>
                            <td>
                                <a class="edit" href="edit.s?id=${student.id}">
                                    <i class="material-icons" title="Modifier">&#xE254;</i>
                                </a>
                                <a class="delete" href="confirm.s?id=${student.id}">
                                    <i class="material-icons" title="Modifier">&#xE872;</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
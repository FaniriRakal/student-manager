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
            <div>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="update.s" method="post">
                            <div class="modal-header">
                                <h4 class="modal-title">Modification</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" ><a href="index.s" >&times;</a>
                                </button>
                            </div>
                            <div class="modal-body">
                                <input class="form-control" name="id" placeholder="Entrer immatricule ..."
                                       value="${student.id}" hidden>
                                    <div class="form-group">
                                        <label class="label-control">Immatricule :</label>
                                        <input class="form-control" name="registered"
                                               placeholder="Entrer immatricule ..."
                                               value="${student.registered}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="label-control">Nom :</label>
                                        <input class="form-control" name="name" placeholder="Entrer nom ..."
                                               value="${student.name}" required="true">
                                    </div>
                                    <div class="form-group">
                                        <label class="label-control">Age :</label>
                                        <input class="form-control" name="age" placeholder="Entrer age"
                                               value="${student.age}" required="true" type="number">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <a href="index.s" class="btn btn-default">Retour</a>
                                    <input type="submit" class="btn btn-info" value="Valider">
                                </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>

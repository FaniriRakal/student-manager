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
                        <div class="modal-header">
                            <h4 class="modal-title">Suppression</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" ><a href="index.s">&times;</a></button>
                        </div>
                        <div class="modal-body">
                            <p>Voulez-vous vraiment supprimer l'etudiant ${student.registered}?</p>

                            <div class="form-group">
                                <label class="label-control"><b>Immatricule :</b></label>
                                <label class="label-control">${student.registered }</label>
                            </div>
                            <div class="form-group">
                                <label class="label-control"><b>Nom :</b></label>
                                <label class="label-control">${student.name }</label>
                            </div>
                            <div class="form-group">
                                <label class="label-control"><b>Age :</b></label>
                                <label class="label-control">${student.age }</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="index.s" class="btn btn-default">Annuler</a>
                            <form action="delete.s" method="post">
                                <input name="_csrf"
                                       value="dea86ae8-58ea-4310-bde1-59805352dec7_${student.id}" hidden/>
                                <input type="text" id="id" name="id" value="${student.id}" hidden>
                                <input type="submit" class="btn btn-info" value="Valider"
                                       onclick="return confirm('Voulez-vous vraiment supprimer?')">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>

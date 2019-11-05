<%-- 
    Document   : IndexDep
    Created on : 1 nov. 2019, 17:58:00
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="Models.Departement"%>
<%@page import="Models.Departement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        
        <title>Gestion Département</title>
        
        <style>
            body {
            background-image: url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            color :  White;
            }
            .form-control {
                background-color: transparent;
                color : white;
            }
            input[type="text"][disabled] {
            background-color: transparent;
            color : white;
            }
        </style>
    </head>
    <body>
        
        <!--------------------- NavBar --------------------->
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="Accueil.jsp">Accueil</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="Controleur1?action=ShowDepartement">Gestion Départements</a></li>
            <li><a href="Controleur1?action=ShowEmploye">Gestion Employes</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Salut Mr <b><c:out value='${User.nom}'/> <c:out value='${User.prenom}'/></b></p></li>
            <li><a href="Controleur1?action=LogoutUser"><span class="glyphicon glyphicon-log-out"></span>    Se Déconnecter</a></li>
        </ul>
    </div>
    </nav>
        
        <!--------------------- Ajout/Modification --------------------->
        <div class="container">
        
        <c:if test="${DeptModif != null}">
            <h1>Modifier Déparetement</h1>
            <form action="Controleur1?action=SaveDepartement&iddsave=<c:out value='${DeptModif.idDep}'/>" method="post">
            <div class="form-group">
                <label>ID Département :</label>
                <input type="text" class="form-control" name="IDD" value="<c:out value='${DeptModif.idDep}'/>" disabled > 
            </div>
        </c:if>
        <c:if test="${DeptModif == null}">
            <h1>Ajouter Déparetement</h1>
            <form action="Controleur1?action=AddDepartement" method="POST">
            <div class="form-group">
                <label>ID Département :</label>
                <input type="text" class="form-control" name="IDD" required > 
            </div>
        </c:if>
        <div class="form-group">
            <label>Nom Département :</label>
                <input type="text" class="form-control" name="NomD" value="<c:out value='${DeptModif.nom}' />"> 
        </div>
        <c:if test="${DeptModif != null}">
            <button type="submit" class="btn btn-warning" onclick="return confirm('Voulez-vous vraiment valider la modification ?')">Modifier</button>
        </c:if>
        <c:if test="${DeptModif == null}">
            <button type="submit" class="btn btn-success">Ajouter</button>
        </c:if>
            
        </form>
        
        <!--------------------- Affichage --------------------->
        
        <h1>Liste des Départements </h1>
        
        <input class="form-control" id="myInput" type="text" placeholder="Search..">
        <br>
         
         <table class="table table-condensed">
             <thead>
                 <tr>
                     <th></th>
                     <th>ID Département </th>
                     <th>Nom Département </th>
                     <th>Nombre D'employés </th>
                     <th colspan="3" style="padding-left : 20%">Actions </th>
                 </tr>
            </thead>
            <tbody id="myTable"> 
            <c:forEach var="Dept" items="${ListDept}" >
              <tr>
                     <td> </td>
                     <td><c:out value="${Dept.idDep}" /> </td>
                     <td><c:out value="${Dept.nom}" /></td>
                     <td><c:out value="${Dept.nombreEmp}" /></td>
                     <td> <form action="Controleur1?action=ShowEmploye&Myidd=<c:out value="${Dept.idDep}" />" method="POST"> <button type="submit" class="btn btn-info">Ajouter/Afficher Employe</button> </form></td>
                     <td> <form action="Controleur1?action=UpdateDepartement&iddmodif=<c:out value="${Dept.idDep}" />" method="POST"> <button type="submit" class="btn btn-warning">Modifier</button> </form></td>
                     <td> <form action="Controleur1?action=DeleteDepartement&iddsupp=<c:out value="${Dept.idDep}" />" method="POST"> <button type="submit" class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment supprimer ce département ?')">Supprimer</button> </form></td>
              </tr>
             </c:forEach>
             <c:forEach var="Dept" items="${ListCount}" >
              <tr>
                  <td><c:out value="${Dept}"/> </td>
              </tr>
             </c:forEach>
            </tbody>
         </table>
         </div>
             <br><br>
             
             <script>
            $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
            </script>
    </body>
</html>

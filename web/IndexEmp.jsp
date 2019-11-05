<%-- 
    Document   : IndexEmp
    Created on : 1 nov. 2019, 17:58:13
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Employé</title>
        <style>
            body {
            background-image: url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            color :  White;
            }
            input[type="text"][disabled] {
            color: white;
            background-color: transparent;
            }
            input[type="text"] {
            color: white;
            background-color: transparent;
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
            <li ><a href="Controleur1?action=ShowDepartement">Gestion Départements</a></li>
            <li class="active"><a href="Controleur1?action=ShowEmploye">Gestion Employes</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><p class="navbar-text">Salut Mr <b><c:out value='${User.nom}'/> <c:out value='${User.prenom}'/></b></p></li>
            <li><a href="Controleur1?action=LogoutUser"><span class="glyphicon glyphicon-log-out"></span>    Se Déconnecter</a></li>
        </ul>
    </div>
    </nav>
        
      <!--------------------- Ajout/Modification --------------------->
        <div class="container">
        <c:if test="${EmpModif != null}">
            <h1>Modifier Employé</h1>
            <form action="Controleur1?action=SaveEmploye&idesave=<c:out value='${EmpModif.cne}'/>" method="post">
            <div class="form-group">
                <label>CNE :</label>
                <input type="text" class="form-control" name="IDE" value="<c:out value='${EmpModif.cne}'/>" disabled > 
            </div>
        </c:if>
        <c:if test="${EmpModif == null}">
            <h1>Ajouter Employé</h1>
            <form action="Controleur1?action=AddEmploye" method="POST">
            <div class="form-group">
                <label>CNE :</label>
                <input type="text" class="form-control" name="IDE" required > 
            </div>
        </c:if>
            <div class="form-group">
            <label>Nom  :</label>
                <input type="text" class="form-control" name="NomE" value="<c:out value='${EmpModif.nom}'/>"> 
            </div>
            <div class="form-group">
            <label>Prenom  :</label>
                <input type="text" class="form-control" name="PrenomE" value="<c:out value='${EmpModif.prenom}'/>"> 
            </div>
            <div class="form-group">
            <label>Salaire  :</label>
                <input type="text" class="form-control" name="SalaireE" value="<c:out value='${EmpModif.salaire}'/>"> 
            </div>
            <div class="form-group">
        <label for="sel1">Département :</label>
        <select name="DepartementE" class="form-control" id="sel1">
        <c:if test="${D == null}">
            <c:if test="${EmpModif == null}"> 
                <option>N'affecte a aucun departement</option>  
                <c:forEach var="Deps" items="${Deps}" >
                    <option><c:out value="${Deps.idDep}" /> : <c:out value="${Deps.nom}" /></option>
                </c:forEach>
            </c:if>
            <c:if test="${EmpModif != null}"> 
                <c:if test="${EmpModif.departement != null}"> 
                    <option><c:out value="${EmpModif.departement.idDep}" /> : <c:out value="${EmpModif.departement.nom}" /></option>
                </c:if>
                <option>N'affecte a aucun departement</option>  
                <c:forEach var="Deps" items="${Deps}" >
                    <c:if test="${EmpModif.departement.idDep != Deps.idDep}"> 
                        <option><c:out value="${Deps.idDep}" /> : <c:out value="${Deps.nom}" /></option>
                    </c:if>
                </c:forEach>
            </c:if>
        </c:if>
        <c:if test="${D != null}">  
            <option><c:out value="${D.idDep}" /> : <c:out value="${D.nom}" /></option>
            <option>N'affecte a aucun departement</option>  
            <c:forEach var="Deps" items="${Deps}" >
                <c:if test="${D.idDep != Deps.idDep}"> 
                    <option><c:out value="${Deps.idDep}" /> : <c:out value="${Deps.nom}" /></option>
                </c:if>
            </c:forEach>
        </c:if>           
      </select>
            </div>
        <c:if test="${EmpModif != null}">
            <button type="submit" class="btn btn-warning" onclick="return confirm('Voulez-vous vraiment valider la modification ?')">Modifier</button>
        </c:if>
        <c:if test="${EmpModif == null}">
            <button type="submit" class="btn btn-success">Ajouter</button>
        </c:if>
        </form>
        
        <!--------------------- Affichage --------------------->
      <c:if test="${D == null}">  
      <h1>Liste des Employes </h1>
      </c:if> 
      <c:if test="${D != null}"> 
          <h1>Liste des Employes du Departement <c:out value="${D.nom}" /> </h1>
      </c:if> 
      <input class="form-control" id="myInput" type="text" placeholder="Search..">
      <br>
         
         <table class="table table-condensed">
             <thead>
                 <tr>
                     <th></th>
                     <th>CNE </th>
                     <th>Nom </th>
                     <th>Prenom</th>
                     <th>Salaire</th>
                     <th>Département</th>
                     <th colspan="2" style="padding-left : 10%">Actions </th>
                 </tr>
            </thead>
            <tbody id="myTable"> 
            <c:if test="${D == null}"> 
              <c:forEach var="Emps" items="${Emps}" >
              <tr> 
                <td></td>
                <td><c:out value="${Emps.cne}" /> </td>
                <td><c:out value="${Emps.nom}" />  </td>
                <td><c:out value="${Emps.prenom}" />  </td>
                <td><c:out value="${Emps.salaire}" />  </td>
                <td><c:out value="${Emps.departement.nom}" /> </td>
                <td> <form action="Controleur1?action=UpdateEmploye&idemodif=<c:out value="${Emps.cne}"/>" method="POST"> <button type="submit" class="btn btn-warning">Modifier</button> </form></td>                     
                <td> <form action="Controleur1?action=DeleteEmploye&idesupp=<c:out value="${Emps.cne}"/>" method="POST"> <button type="submit" class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment supprimer cet employe ?')" >Supprimer</button> </form></td>
              </tr>
              </c:forEach>
            </c:if>
            <c:if test="${D != null}"> 
                <c:forEach var="Emps" items="${D.employes}" >
              <tr> 
                <td></td>
                <td><c:out value="${Emps.cne}" /> </td>
                <td><c:out value="${Emps.nom}" />  </td>
                <td><c:out value="${Emps.prenom}" />  </td>
                <td><c:out value="${Emps.salaire}" />  </td>
                <td><c:out value="${Emps.departement.nom}" /> </td>
                <td> <form action="Controleur1?action=UpdateEmploye&idemodif=<c:out value="${Emps.cne}"/>" method="POST"> <button type="submit" class="btn btn-warning">Modifier</button> </form></td>                     
                <td> <form action="Controleur1?action=DeleteEmploye&idesupp=<c:out value="${Emps.cne}"/>" method="POST"> <button type="submit" class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment supprimer cet employe ?')" >Supprimer</button> </form></td>
              </tr>
              </c:forEach>
            </c:if>
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

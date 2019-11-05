<%-- 
    Document   : Accueil
    Created on : 24 oct. 2019, 01:18:08
    Author     : Mehdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <style>
            body {
            font-family: Arial;
            background-image: url(https://i.ytimg.com/vi/F2Uu_3cLr8w/maxresdefault.jpg);
            background-repeat: no-repeat;
            background-size: 1400px 700px;
            }

            .split {
            height: 100%;
            width: 50%;
            position: fixed;
            z-index: 1;
            top: 0;
            overflow-x: hidden;
            padding-top: 20px;
            }

            .left {
            left: 0;
            color :  #56393a;
            }

            .right {
            right: 0;
            color : #0e675b;
            }

            .centered {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            }

            .centered img {
            width: 150px;
            border-radius: 50%;
            }
        </style>
        
    </head>
    <body>
    <div class="split left">
        <div class="centered">
            <a href="Controleur1?action=ShowDepartement"><img src="https://cdn2.iconfinder.com/data/icons/business-world-flat/64/outsourcing-company-business-department-workload-512.png" alt="Département"></a>
            <h2>Gestion Départements</h2>
        </div>
    </div>

    <div class="split right">
        <div class="centered">
            <a href="Controleur1?action=ShowEmploye"><img src="https://image.flaticon.com/icons/png/512/1323/1323223.png" alt="Employe"></a>
            <h2>Gestion Employe</h2>
        </div>
    </div>
        
    </body>
</html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="keywords"
          content="unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form">
    <meta name="author" content="leamug">
    <title>Login</title>
    <link href="css/style.css" rel="stylesheet" id="style">
    <!-- Bootstrap core Library -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
    <!-- Font Awesome-->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        body {
        background-image:url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');
        background-position:center;
        background-size:cover;
  
        -webkit-font-smoothing: antialiased;
        font: normal 14px Roboto,arial,sans-serif;
        font-family: 'Dancing Script', cursive!important;
        }

        .container {
            padding: 110px;
        }
        ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
            color: #ffffff!important;
            opacity: 1; /* Firefox */
            font-size:18px!important;
        }
        .form-login {
            background-color: rgba(0,0,0,0.55);
            padding-top: 10px;
            padding-bottom: 20px;
            padding-left: 20px;
            padding-right: 20px;
            border-radius: 15px;
            border-color:#d2d2d2;
            border-width: 5px;
            color:white;
            box-shadow:0 1px 0 #cfcfcf;
        }
        .form-control{
            background:transparent!important;
            color:white!important;
            font-size: 18px!important;
        }
        h1{
            color:white!important;
        }
        h4 { 
        border:0 solid #fff; 
        border-bottom-width:1px;
        padding-bottom:10px;
        text-align: center;
        }

        .form-control {
            border-radius: 10px;
        }
        .text-white{
            color: white!important;
        }
        .wrapper {
            text-align: center;
        }
        .footer p{
            font-size: 18px;
        }
    </style>
</head>
<body>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-4 text-center">
            <div class="form-login"></br>
                <h4>Login</h4>
                </br>
                <form action="Controleur1?action=LoginUser" method="post">
                    <input type="text" id="userName" name="login" class="form-control input-sm chat-input" placeholder="username" required />
                    </br></br>
                    <input type="password" id="userPassword" name="password" class="form-control input-sm chat-input" placeholder="password" required/>
                    </br></br>
                    <div class="wrapper">
                        <span class="group-btn">
                            <button type="submit" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></button>
                        </span>
                    </div> 
                </form>
                    <h4 style="color : red"><c:out value='${Erreur}'/></h4>
            </div>
        </div>
    </div>
    </br></br></br>
</div>
</body>
</html>

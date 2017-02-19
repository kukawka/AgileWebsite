<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="styles_index.css"/>
    </head>


    <body>


        <nav class="navbar navbar-default" style="border-bottom-left-radius: 0; border-bottom-right-radius: 0;">
            <div class="container-fluid">
                <a class="navbar-brand" href="#" style="padding:0%; "><img src='quizlogo.png'  height="60" width="80"></a>
            </div>
        </nav>

        <%
            if ((Boolean) request.getAttribute("check") != null) {
        %>
        <style>
            .alert {
                padding: 20px;
                background-color: #ff9800;
                width: 25%;
                float: right;
                border-radius: .25rem;
                margin-right: 2%;
                color: white;
            }

            .close {
                margin-left: 15px;
                color: white;
                font-weight: bold;
                float: right;
                font-size: 22px;
                line-height: 20px;
                cursor: pointer;
                transition: 0.3s;
            }

            .close:hover {
                color: black;
            }

        </style>


        <div class="alert">
            <span class="close" onclick="this.parentElement.style.display = 'none';">&times;</span>
            <strong>Incorrect</strong> username/password. Check if you're on the right login page!

        </div>

        <%
            }
        %>

        <div class="login-page">
            <div class="form">
                <h3>QuizUp</h3>
                <form method="POST"  action="Login">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <button type="submit" class="btn btn-default">Login</button>
                </form>
            </div>
        </div>



    </body>
</html>

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
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">QuizUp</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="student_index.jsp">Student Login</a></li>
                </ul>
            </div>
        </nav>

        <!--<article>-->
        <div class="col-md-4"></div> 
        <div class="col-sm-12 col-md-4" style="padding-top: 15% ;">
            <div class="thumbnail">
                <center>
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
                        <input type="hidden" name="type" value="staff">
                        <button type="submit" class="btn btn-default">Login</button>
                    </form>

                </center>
            </div>
        </div>
        <div class="col-md-4"></div> 
        <!--</article> -->

    </body>
</html>

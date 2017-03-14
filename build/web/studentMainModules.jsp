<%-- 
    Document   : studentModules
    Created on : 06-Mar-2017, 15:46:22
    Author     : Javier
--%>
<%@page import="Beans.ModuleChoices"%>
<%@page import="Beans.Module"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.LoggedIn"%>
<%@page import="Beans.ProgrammeOfStudy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modules</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>     
    <body>
        <jsp:include page="/navBar.jsp" />

        <div class="main">
            <div class="page-header" style="margin-left: 2%;">

                <h1>Your Module Choices <button type="button" class="btn btn-lg btn-primary" style=" color: white; margin-left: 20px; text-decoration: none;"><a href="EditModules" style="color:white;">Add/Delete Modules &nbsp;<span class="glyphicon glyphicon-pencil"</span></a></button></h1>

            </div> 

            <%
                ArrayList<Module> mod = (ArrayList<Module>) request.getAttribute("choice");

                if (mod != null) {
                    for (int i = 0; i < mod.size(); i++) {
            %>


            <div class="Outer">
                <form method="Post" action="MainPage" style="height: 100%;">

                    <input type="hidden" name="id" value="<%=mod.get(i).getID()%>"/>
                    <input type="hidden" name="type" value="quiz"/>
                    <input class="Inner1" type="submit" name="info" value="<%=mod.get(i).getName()%>"/>
                </form>
            </div>

            <%
                    }
                }

            %>

    </body>
</html>

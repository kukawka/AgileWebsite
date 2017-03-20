<%-- 
    Document   : studentModules
    Created on : 06-Mar-2017, 15:46:22
    Author     : Javier
--%>
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

                <h1>Programmes Of Study</h1>

                <form method="Post" action="GetModules">
                    <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/> <!-- this value sends you to that pos after submitting choices -->   
                    <input type='hidden' id= 'hiddenField' name="moduleChoice" value='' />
                    <input type="submit" class="btn2 btn-lg btn-primary" id='button' style=" color: white; float: right; position: relative; bottom: 55px; margin-right: 20px; display: none;" value="Submit Choices"/>
                </form>


            </div> 
            <%
                ArrayList<ProgrammeOfStudy> pos = (ArrayList<ProgrammeOfStudy>) request.getAttribute("pos");
                for (int i = 0; i < pos.size(); i++) {
            %>
            <div class="Outer">

                <form method="Post" action="GetModules" style="height: 100%;">

                    <input type="hidden" name="id" value="<%=pos.get(i).getID()%>"/>
                    <input type="hidden" name="type" value="module"/>
                    <input id="submit1" type="submit" name="info" value="<%=pos.get(i).getName()%>"/>
                </form>

            </div>
            <%
                }

                ArrayList<Module> mod = (ArrayList<Module>) request.getAttribute("modules");

                if (mod != null) {
            %>
            <div class="page-header" style="margin-left: 2%;">
                <h2>Modules </h2>

            </div> 
            <%
                for (int i = 0; i < mod.size(); i++) {
            %>



            <div class="Outer">
                <input type="hidden" name="id" value="<%=mod.get(i).getID()%>"/>
                <div class="modulebutton" style="text-align: center; vertical-align: middle; line-height: 80px;">
                    <%=mod.get(i).getName()%>
                    <% if(mod.get(i).getChoice() == 0){ %>
                    <button class="bttonTrue" id="<%=mod.get(i).getID()%>" onClick="reply_click(this.id)">ADD</button>
                    <% } else { %>

                    <form method="Post" action="GetModules">
                        <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/> <!-- this value sends you to that pos after submitting choices -->   
                        <input type='hidden' name="deleteModule" value="<%=mod.get(i).getID()%>" />
                        <input type="submit" class="bttonFalse" value="&#10007;"/>
                    </form>

                    <!--<button class="bttonFalse" id="<%=mod.get(i).getID()%>">&#10007;</button>-->
                    <% } %>
                </div>

            </div>
            <%
                    }
                }
            %>

        </div>
        <style>

            .bttonTrue, .bttonFalse{
                
                
                height: 100%;
                border: none;
                border-radius:0px 0px 0px 0px;
                background-color:inherit;
                float: right;
                cursor: pointer;
            }
            .bttonTrue{
                color:green;
            }

            .bttonFalse{
                color:red;
                margin-top: -80px;
                height: 75px;
            }

            .bttonTrue:hover {
                background: rgba(101, 217, 80, 0.3);
                color:black;

            }

            .bttonFalse:hover {
                background: red;
                color: white;
            }
        </style>
        <script>
            var IDs = "";

            function reply_click(clicked_id)
            {
                document.getElementById(clicked_id).style.background = "rgba(101, 217, 80, 0.4)";
                document.getElementById('button').style.display = "block";
                IDs = IDs + "," + clicked_id;
                document.getElementById('hiddenField').value = IDs;
            }
        </script>
    </body>
</html>

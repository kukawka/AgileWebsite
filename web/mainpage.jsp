<%@page import="Beans.LoggedIn"%>
<%@page import="Beans.Quiz"%>
<%@page import="Beans.Module"%>
<%@page import="Beans.ProgrammeOfStudy"%>
<%@page import="java.util.ArrayList"%>
<HTML>
    <HEAD>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mainpage_style.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <TITLE>Main Page</TITLE>
    </HEAD>
    <BODY>
        <jsp:include page="/navBar.jsp" />
        <div class="main">
                <%
                String heading= "";
                if (request.getAttribute("heading") != null) { // Displays the corresponding previous title that the grid is part of.
                    heading = String.valueOf(request.getAttribute("heading"));
                }
                else if(request.getAttribute("type") != null)
                {
                    heading = "Programme of Study";
                }
                
                %>
                <div class="page-header">
                <h1><%=heading%></h1>
            </div><br><div class="grid">

                <%      if (request.getAttribute("type") != null) { //checks if you have chosen a grid button
                        if (request.getAttribute("type").equals("pos")) { // Shows all the program of studies
                            ArrayList<ProgrammeOfStudy> pos = (ArrayList<ProgrammeOfStudy>) request.getAttribute("items");
                            for (int i = 0; i < pos.size(); i++) {
                %>

                <div class="grid-item">
                    <form method="Post" action="MainPage">
                        <input type="hidden" name="id" value="<%=pos.get(i).getID()%>"/>
                        <input type="hidden" name="type" value="module"/>
                        <input type="submit" name="info" id="submit1" value="<%=pos.get(i).getName()%>"/>
                    </form>
                </div>
                <%
                    }
                } else if (request.getAttribute("type").equals("module")) { // shows all the modules to the chosen program of study
                    ArrayList<Module> mod = (ArrayList<Module>) request.getAttribute("items");
                    for (int i = 0; i < mod.size(); i++) {
                %>

                <div class="grid-item">
                    <form method="Post" action="MainPage">
                        <input type="hidden" name="id" value="<%=mod.get(i).getID()%>"/>
                        <input type="hidden" name="type" value="quiz"/>
                        <input type="submit" name="info" id="submit1" value="<%=mod.get(i).getName()%>"/>
                    </form>
                </div>
                <%
                    }

                }
            }
                %>
            </div>
        </div>
        
    </BODY>
</HTML>

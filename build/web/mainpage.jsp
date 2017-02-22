<%@page import="Beans.ProgrammeOfStudy"%>
<%@page import="java.util.ArrayList"%>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(function() {
    //----- OPEN
    $('[data-popup-open]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
 
        e.preventDefault();
    });
 
    //----- CLOSE
    $('[data-popup-close]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-close');
		
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);
		
        e.preventDefault();
		
		
		
    });

});
</script>
<script>
// external js: isotope.pkgd.js

$('.grid').isotope({
  itemSelector: '.grid-item',
  masonry: {
    columnWidth: 100
  }
});</script>
<TITLE>Your Title Here</TITLE>
</HEAD>
<BODY BGCOLOR="c0d13e">

<br><br>
<div class="headerhandler">
<h1>FirstName<br>LastName<br> Welcome!</h1>
</div>
<br>

<nav>
    <div class="panel-group" id="accordion" >
	<div class="panel panel-default" >

	  <%
          ArrayList<ProgrammeOfStudy> pos = (ArrayList<ProgrammeOfStudy>) request.getAttribute("POS");
          for(int i=0;i<pos.size();i++)
         {
      %>
  
      <div class="panel-heading" id="navheader">
        <h4 class="panel-title" >
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><%=pos.get(i).getName()%></a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in" id="navheader">
        <div class="panel-body"><ul class="list-group">
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">ModuleID1</a></li>
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">ModuleID2</a></li>
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">ModuleID3</a></li>
      </ul></div>
      </div>
      
      <%
          //if(pos.next().getString("Name")==null) break;
      }
      %>

   
    <div class="panel panel-default">
      <div class="panel-heading" id="navheader">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2" >View all programmes</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body"><div class="panel-body"><ul class="list-group">
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">Programme</a></li>
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">Programme</a></li>
        <li class="list-group-item"><a class="btn" data-popup-open="popup-1" href="dxd">Programme</a></li>
      </ul>
	  </div>
	  </div>
      </div>
    </div>
    
  </div></div>
</nav>
<div class="popup" data-popup="popup-1">
 <div class="popup-inner">
 <center><h2>ModuleID1</h2></center>
 
  <p>Below are displayed quizzes for the certain module.</p>
  <br><br>
  <div class="grid">
  <div class="grid-item"></div>
  <div class="grid-item"></div>
  <div class="grid-item"></div>
  <div class="grid-item"></div>
  <div class="grid-item"></div>
  <div class="grid-item"></div>
  <div class="grid-item"></div><div class="grid-item"></div><div class="grid-item"></div>
  <div class="grid-item"></div>

 
  
  
</div>
  
  <br><br>
   <a class="popup-close" data-popup-close="popup-1" href="#">x</a>

   </div>
</div>



<div class="footer"><p>This website was crated by Team 3.</p></div>
</BODY>
</HTML>

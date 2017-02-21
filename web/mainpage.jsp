<%-- 
    Document   : mainpage
    Created on : Feb 21, 2017, 2:26:17 PM
    Author     : Krasi
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
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
		if (e.target !== this) return;
    });
});
</script>

<TITLE>Your Title Here</TITLE>
</HEAD>

<BODY BGCOLOR="c0d13e">
    
    <%
            // =  request.getAttribute("");
        %> 
<HR>
<br><br>
<div class="headerhandler">
<h1>FirstName<br>LastName<br> Welcome!</h1>
</div>
<br>
<div class="popup" data-popup="popup-1">
 <div class="popup-inner">
 <center><h2>ModuleID1</h2></center>
 
  <p>Below are displayed quizzes for the certain module.</p>
  <br><br>
  <div class="handle">
  <a href="#" class="myButton">Quiz1</a>
  <a href="#" class="myButton">Quiz2</a>
  <a href="#" class="myButton">Quiz3</a>
  <a href="#" class="myButton">Quiz4</a>
  <a href="#" class="myButton">Quiz5</a>
  <a href="#" class="myButton">Quiz6</a>
  <a href="#" class="myButton">Quiz7</a>
  <a href="#" class="myButton">Quiz8</a>
  <a href="#" class="myButton">Quiz9</a>
    
  </div>
  
  
  <br><br>
   <p><a data-popup-close="popup-1" href="#">Close</a></p>
   <a class="popup-close" data-popup-close="popup-1" href="#">x</a>
   <a class="popup-close" data-popup-close="popup-1" href="#">x</a>
   </div>
</div>
<nav>
   <div class="menu-item alpha">
      <h4><a href="#">Home</a></h4>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam finibus tristique viverra. Donec pulvinar aliquam felis, quis hendrerit diam interdum ornare. </p>
    </div>
      
   
      <%
          ResultSet pos = (ResultSet) request.getAttribute("POS");
          //for (int i = 0; i<pos.g){
      %>
    <div class="menu-item">
      <h4><a href="#">Programme of study</a></h4>
      <ul>
        <li><a class="btn" data-popup-open="popup-1" href="dxd">ModuleID1</a></li>
        <li><a href="#">ModuleID2</a></li>
        <li><a href="#">ModuleID3</a></li>
      </ul>
	  <h4><a href="#">All Modules</a></h4>
    </div>
      
   
</nav>


<div class="footer"><p>This website was crated by Team 3.</p></div>
</BODY>
</HTML>
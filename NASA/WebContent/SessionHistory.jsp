<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="NASA_Images.Response, NASA_Images.CompressedResponse, java.util.ArrayList" %>

<!DOCTYPE html>
<%
	@SuppressWarnings("unchecked")
	//get Search History stored in session
	ArrayList<String> history = new ArrayList<String>();
	if (session.getAttribute("history") != null) {
		history = (ArrayList<String>)session.getAttribute("history");
	}
   
%>
<html>
	<head>
		<title>Session History</title>
		<link rel="stylesheet" type="text/css" href="font.css">
		<link rel="stylesheet" type="text/css" href="SessionHistory.css">
		
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbRvuhkDnGfwsMGJLdlRPpGWjHArgo5Yg&callback=initMap" async defer></script>
		<script src="googlemaps.js"></script>
		<script src="change.js"></script>
		
	</head>
	<body>
		<!-- for background image -->
		<div id="background-img" onclick="javascript:changeVisibility('main_wrapper', 'map')"></div> <!-- for background-image -->
      		<div class="top">
	        	<a href="home.jsp"><h2 class="title">NASA Image Gallery</h2></a>
	        	<form action="ImageSearch" method="GET" id = "SearchBar">
		       		<div class="search_fields">
		        		<div class="search-wrapper">
		        			<div id= "search_term"><input Type="search" name= "term" placeholder="Search..." /></div>
			        		<div id= "search_year">
			     				<input Type="search" name= "year_start" id="year_start" placeholder="Starting Year"/>
		         				<input Type="search" name= "year_end" id="year_end" placeholder="Ending Year"/> 
		         			</div>
		         			<div id= "search_location"><input Type="search" name= "location" placeholder="Location" /></div>
		         			<img onclick="javascript:changeVisibility('map', 'main_wrapper')" src="Assignment2Images/MapIcon.png" name= "mapicon" id="mapicon" />
		         			<input type="image" src="Assignment2Images/magnifying_glass.jpeg" name= "Search" id="Search" alt="Submit">
		        		</div>
		   				
		   				<!-- For toggling of search bars through radio buttons -->
						<script>changeScope('search_term', 'search_year'); changeScope('search_term', 'search_location');</script>
					
					    <div class = "radio">
		         			<input type="radio" name="searchselection" id="search_term" value="term" onclick="changeScope('search_term', 'search_year'); changeScope('search_term', 'search_location');" checked>Term
			         		<input type="radio" name="searchselection" id="search_year" value="year" onclick="changeScope('search_year', 'search_term'); changeScope('search_year', 'search_location');">Years
			         		<input type="radio" name="searchselection" id="search_location" value="location" onclick="changeScope('search_location', 'search_term'); changeScope('search_location', 'search_year');">Location
		         		</div>
		        	</div> <!-- end of search fields -->
				</form>
	 		</div> <!-- end of top -->
	 		
		 	<div class="foreground">
			
				<!--this shows the google map -->
				<div id="map"></div>
				<div id="main_wrapper">
					<script>changeVisibility('main_wrapper', 'map');</script>
					<h3>Session History</h3>
					<table id="citytable">
				  		<tr>
				    		<th>Term, Starting Year, Ending Year, Location</th> 
				  		</tr>
				  		<% for (int i = 0; i < history.size(); i++) { %>
				  		<tr>
				    		<td><%=history.get(i) %></td> 
				    	</tr>
				    	<% } %>
					</table>
				<br />
				</div>	<!-- end of main_wrapper -->
			</div> <!-- end of foreground -->
	</body>
</html>
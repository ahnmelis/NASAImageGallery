<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% %>
<!DOCTYPE html>
	
<html>

	<head>
		<script src="googlemaps.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbRvuhkDnGfwsMGJLdlRPpGWjHArgo5Yg&callback=initMap" async defer></script>
		<script src="change.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="servletfunctions.js"></script>
	
		<title>Home</title>
		<meta name="viewport" content="initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="font.css">
		<link rel="stylesheet" type="text/css" href="home.css">
	</head>
	<body>
		<div id="background-img" onclick="javascript:changeVisibility('main_wrapper', 'map')"></div> <!-- for background-image -->
     		<div class="top">
     				<div id="title">
	        			<h2>NASA Image Gallery</h2>
	        		</div>
	        		<div id="LandR">
	 					<a href="SessionHistory.jsp">Session History</a>
		        	</div>
	 		</div>
	 		
	 		<div class="foreground">	
		 		<!-- This shows the google map -->
		 		<div id="map"></div>
		 		<div id = "main_wrapper">
			 		<div id = "logo"><img src="Assignment2Images/NASA_logo.png"><br></div>
		     		
		     		<script>changeVisibility('main_wrapper', 'map');</script> <!-- For Google map -->
		     		
				     <form action="ImageSearch" method="GET">
			       		 <div class="search_fields">
			        		<div class="search-wrapper">
			        			<div id= "search_term">
				        			<input Type="search" name= "term" placeholder="Search..." />
				        		</div>
				        		<div id= "search_year"> 
				     				<input Type="search" name= "year_start" id= "year_start" placeholder="Starting Year"/>
			         				<input Type="search" name= "year_end" id= "year_end" placeholder="Ending Year"/> 
			         			</div>
			         			<div id= "search_location">
				        			<input Type="search" name= "location" placeholder="Location" />
				        		</div>
			         			<input type="image" src="Assignment2Images/magnifying_glass.jpeg" name= "Search" id="Search" alt="Submit">
			        		</div> <br />
			   				
			   				<!-- For toggling of search bars through radio buttons -->
							<script>changeScope('search_term', 'search_year'); changeScope('search_term', 'search_location');</script>
						
						    <div class = "radio">
				         		<input type="radio" name="searchselection" id="search_term" value="term" onclick="changeScope('search_term', 'search_year'); changeScope('search_term', 'search_location');" checked>Term
				         		<input type="radio" name="searchselection" id="search_year" value="year" onclick="changeScope('search_year', 'search_term'); changeScope('search_year', 'search_location');">Years
				         		<input type="radio" name="searchselection" id="search_location" value="location" onclick="changeScope('search_location', 'search_term'); changeScope('search_location', 'search_year');">Location<br />
			         			<img onclick="javascript:changeVisibility('map', 'main_wrapper')" src="Assignment2Images/MapIcon.png" name= "mapicon" id="mapicon" />
			         		</div>
			         		
			        	</div> <!-- end div for search fields -->
					</form>
				</div> <!-- end of main wrapper div -->
		
			</div> <!--  for foreground -->		
	</body>
			
</html>
/**
 * Google Maps API
 */

    	var map;
      	function initMap() {
	    	var la = {lat: 34.0522, lng: -118.2437};
	        map = new google.maps.Map(document.getElementById('map'), {
	        	center: la,
	        	zoom: 4
	   		});
        
	        var infowindow = new google.maps.InfoWindow({
  	          	content: "Click to the left, right, or below map to exit"
  	        });
	        var temp = new google.maps.Marker({
	        	position: {lat: 35.395765439666604, lng: -123.72807178134917},
	        	map: map
	        })
	        infowindow.open(map, temp);
	        
   	  	//when clicked on map
      	google.maps.event.addListener(map, 'click', function(event) {
    	  	// add a marker and infowindow
    	  	var marker = new google.maps.Marker({
  	        	position: event.latLng, 
  	        	map: map
  	    	});
  	   		//now generate infowindow 
  	   		var infowindow = new google.maps.InfoWindow({
  	          	content: event.latLng.toString()
  	        });
  	   		//by default, window opens
  	   		infowindow.open(map, marker);
  	   		map.panTo(event.latLng);
  	   		
  	   		//when marker is clicked again
       		marker.addListener('click', function() {
            	infowindow.open(map, marker);
             	map.panTo(event.latLng);
           	});		
    	   
    	});

      }
      
      
      

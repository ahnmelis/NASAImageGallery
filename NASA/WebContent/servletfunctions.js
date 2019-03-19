/** Servlet functions: have to include <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 * 
 */


		 	function ProfileFunction() {
		 		$.ajax({
		 			url: "ProfileServlet",
		 			data: {
		 				// In servlet, call request.getParameter("someKey") to retrieve "someValue"
		 				//someKey: "someValue",
		 				//someKey2: "Miller"
		 			},
		 			success: function(result) {
		 				// result is the string response from the servlet
		 				// The servlet responds by calling: response.getWriter().write or print
		 			}
		 		})
		 	}
		 	
		 	function LogoutFunction() {
		 		$.ajax({
		 			url: "LogoutServlet",
		 			data: {
		 				// In servlet, call request.getParameter("someKey") to retrieve "someValue"
		 				//someKey: "someValue",
		 				//someKey2: "Miller"
		 			},
		 			success: function(result) {
		 				// result is the string response from the servlet
		 				// The servlet responds by calling: response.getWriter().write or print
		 			}
		 		})
		 	}
		 	
		 	function CityListParseFunction() {
		 		$.ajax({
		 			url: "CityListParse",
		 			data: {
		 				// In servlet, call request.getParameter("someKey") to retrieve "someValue"
		 				//someKey: "someValue",
		 				//someKey2: "Miller"
		 			},
		 			success: function(result) {
		 				// result is the string response from the servlet
		 				// The servlet responds by calling: response.getWriter().write or print
		 			}
		 		})
		 	}
		 	
		 	
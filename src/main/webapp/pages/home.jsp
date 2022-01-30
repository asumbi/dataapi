<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w13.org/TR/html4.loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Data API user input</title>
    </head>
    <body>
        <form  class="form-inline"action="addCustomer">
            <label for="aid">Id:</label>
        	<input type ="text" name="aid"><br>
        	<label for="aname">Name:</label>
        	<input type ="text" name="aname"><br>
        	<label for="tech">Technology:</label>
        	<input type ="text" name="tech"><br>
        	<input type ="submit"><br>
        	<label>
            <input type="checkbox" name="remember"> Remember me
            </label>
            <button type="submit">Submit</button>
        </form>
<!--
        <form class="form-inline" action="/action_page.php">
          <label for="aid">Id:</label>
          <input type="text" id="email" placeholder="Enter email" name="email">
          <label for="pwd">Password:</label>
          <input type="password" id="pwd" placeholder="Enter password" name="pswd">
          <label>
            <input type="checkbox" name="remember"> Remember me
          </label>
          <button type="submit">Submit</button>
        </form>
-->
        <!-- fetch Customer data by id -->
        <form class="form-inline" action="getCustomer">
            <label for="aid">Search Id:</label>
            <input type ="text" name="aid"><br>
            <input type ="submit"><br>
        </form>
    </body>
</html>

<!-- localhost:8080/home -->
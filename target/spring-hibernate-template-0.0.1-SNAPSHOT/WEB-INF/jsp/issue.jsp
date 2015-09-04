<!doctype html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
  <meta charset="utf-8">
  <title>Spring MVC and Hibernate Template</title>

  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

  </head>

<body >


<form:form method="post" action="track">
  <div class="form-group">
    <label for="url">Repositary URL</label>
    <input type="text" class="form-control" id="url" name="url" placeholder="url">
  </div>
  
  <input type="submit" value="Add issue" class="btn"/>
</form:form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </head>

<body>



<div class="panel panel-default">
  <div class="panel-heading">URL</div>
  <div class="panel-body">
    ${url}
  </div>
</div>      

<div class="panel panel-default">
  <div class="panel-heading">Total number of open issues</div>
  <div class="panel-body">
    ${total}
  </div>
</div>
<div class="panel panel-default">
  <div class="panel-heading"> Number of open issues that were opened in the last 24 hours</div>
  <div class="panel-body">
    ${first }
  </div>
</div>
<div class="panel panel-default">
  <div class="panel-heading"> Number of open issues that were opened more than 24 hours ago but less than 7 days ago</div>
  <div class="panel-body">
    ${second }
  </div>
</div>
<div class="panel panel-default">
  <div class="panel-heading">  Number of open issues that were opened more than 7 days ago </div>
  <div class="panel-body">
    ${third }
  </div>
</div>


         
</body>
</html>

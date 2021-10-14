<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Colourful Flower Popup Menu</title>
  <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.8.1/css/all.css'><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<nav class="menu">
   <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" />
   <label class="menu-open-button" for="menu-open">
    <span class="lines line-1"></span>
    <span class="lines line-2"></span>
    <span class="lines line-3"></span>
  </label>

   <a href="Controller?opcion=mostrar" class="menu-item blue"> <i class="fas fa-eye"></i> </a>
   <a href="Controller?opcion=mostrar " class="menu-item green"> <i class="fas fa-edit"></i> </a>
   <a href="Controller?opcion=salario" class="menu-item red"> <i class="fa fa-heart"></i> </a>
   <a href="Controller?opcion=buscaDni" class="menu-item purple"> <i class="fa fa-microphone"></i> </a>
   <a href="#" class="menu-item orange"> <i class="fa fa-star"></i> </a>
   <a href="#" class="menu-item lightblue"> <i class="fa fa-diamond"></i> </a>
</nav>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
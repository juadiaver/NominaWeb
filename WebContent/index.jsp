<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Colourful Flower Popup Menu</title>
  <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.8.1/css/all.css'><link rel="stylesheet" href="css/style.css">

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
   <a href="Controller?opcion=buscaEmpleado " class="menu-item green"> <i class="fas fa-edit"></i> </a>
   <a href="Controller?opcion=creaEmpleado" class="menu-item red"> <i class="fas fa-plus"></i> </a>
   <a href="Controller?opcion=buscaSalario" class="menu-item purple"> <i class="far fa-money-bill-alt"></i> </a>
   <a href="vista/Error.jsp" class="menu-item orange"> <i class="fas fa-exclamation-triangle"></i> </a>
   <a href="vista/Error.jsp" class="menu-item lightblue"> <i class="fas fa-exclamation-triangle"></i></i> </a>
</nav>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
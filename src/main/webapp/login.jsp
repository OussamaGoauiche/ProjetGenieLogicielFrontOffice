<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Sign in & Sign up Form</title>
    <meta charset="UTF-8" />
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--Link css-->
    <link rel="stylesheet" href="./css/logincss.css"/>
    <!--Font-->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@300;400;700&#038;display=swap" rel="stylesheet" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
      
    <div class="container1">
      <div class="forms-container1">
        <div class="signin-signup">
         
          <form action="<%=request.getContextPath()%>/signin" class="sign-in-form" method="POST">
            <h2 class="title">Sign in</h2>
               <p style="color:red;font-size:20px">${message2}</p>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="CIN"  name="cin"  required/>
            </div>
             <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Email"  name="email"  required/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name="passwd" required/><br><br>
            </div>
            <input type="submit" value="Login" class="btn solid" />
            
          
           
          </form>

          <form action="<%=request.getContextPath()%>/signup" class="sign-up-form" method="POST">
          <h2 class="title">Sign up</h2>
            <p style="color:red;font-size:20px">${message}</p>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="CIN" name="cin"required/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Nom" name="nom"required/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Prenom" name="prenom"required/>
            </div>
            
            <div class="input-field">
               <i class="fas fa-envelope"></i>
              <input type="text" placeholder="email" name="email"required/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="adresse" name="adresse"required/>
            </div>
            
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="text" placeholder="Numero Telephone" name="phone"required/>
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" name="passwd"required />
            </div>
            <input type="submit" class="btn" value="Sign up" />
          
          
          </form>
        </div>
      </div>

      <div class="panels-container1">
        <div class="panel left-panel">
          <div class="content">
            <h3>New here ?</h3>
            <p>
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis,
              ex ratione. Aliquid!
            </p>
            <button class="btn transparent" id="sign-up-btn">
              Sign up
            </button>
          </div>
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>One of us ?</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
              laboriosam ad deleniti.
            </p>
            <button class="btn transparent" id="sign-in-btn">
              Sign in
            </button>
          </div>
        </div>
      </div>
    </div>


    <script src="./javascript/app2.js"></script>
  </body>
</html>
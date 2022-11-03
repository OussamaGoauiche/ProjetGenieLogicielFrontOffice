<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier une demande</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./css/style.css" />
    <link rel="stylesheet" href="./css/forme.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
</head>
<body>

    <header>
        <nav>
            <div class="logo">
                ENSA KHOURIBGA
            </div>
            <div class="toggle">
                <i class="fas fa-bars ouvrir"></i>
                <i class="fas fa-times fermer"></i>
            </div>
            <ul class="menu">
                <li><a href="Acceuil.jsp">Home</a></li>
                <li><a href="Deposer.jsp">D&eacute;poser</a></li>
                <li><a href="Modifier.jsp">Modifier</a></li>
                <li><a href="#">Suivre</a></li>
                <li><a class="butn" href="#">${nom}</a></li>
            </ul>
        </nav>
    </header>
  <div class="container">
    <div class="row">
        <div class="col-lg-12 col-md-9">
            <h1 class="title">Modifier une demande</h1>
        </div>
    </div>

   

    <form class="form-horizontal" role="form" action="traiter-formulaire.php" method="POST" enctype="multipart/form-data">
        <div class='container'>

         
            <div class='row'>

                
                    <!--<form class="form-horizontal" role="form">-->
                      <div class="form-group">
                        <label for="jeton" class="col-sm-2 control-label">JETON :</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="jeton" id="jeton" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cin" class="col-sm-2 control-label">CIN :</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="cin" id="cin" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">DESCRIPTION :</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="description" id="description" required>
                        </div>
                    </div>
                   <div class="form-group">
                            <label for="origine" class="col-sm-2 control-label">PROCEDURE :</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="choix2">
                                  <option>Double diplomation</option>
                                    <option>Echange</option>
                                    <option>PFE</option>
                                    <option>suivi de semestres enseignement</option>
                                </select>
                            </div>
                        </div>
                    

                </div>
            
            <div class="row">
               

                <div class="col-lg-6">     
                    <div class="form-group">
                        <label for="nam" class="col-sm-2 control-label">DOSSIER DESCRIPTIVE :</label>
                        <div class="col-sm-8">
                            <input type="file" class="form-control" name="dossier" id="nam" required>
                        </div>
                    </div>
                    <br>
                

            </div>
            <div class="col-xs-12">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
        </div>
    </form>
     <script src="./javascript/app.js"></script>
</body>
</html>
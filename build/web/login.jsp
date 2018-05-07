<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmácia APPP</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.2.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/extras.js"></script>
    </head>
    <body>
        <div class="d-flex justify-content-center align-items-center full">
            <div class="form-box">
              <div class="brand" style="width:100px; height:40px; background-color:#ddd;"></div>
              <div class="box">
                <h5>entre na sua conta</h5>
                <form>
                <div class="form-group">
                  <label for="email">email</label>
                  <input type="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                  <label for="password">senha</label>
                  <input type="password" class="form-control" id="password">
                  <a href="#"><p class="text-right"><small>esqueceu a senha?</small></p></a>
                </div>

                <button type="submit" class="btn btn-primary btn-block btn-lg">entrar</button>
                </form>
              </div>
              <p class="text-muted"><small>não tem uma conta? <a href="#">se cadastre aqui</a></small></p>
            </div>
          </div>
    </body>
</html>

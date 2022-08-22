<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>

<body>
	
        <h3 class="text-center text-white pt-5">Đăng nhập</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                
              <c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">
							Username or Password is incorrect !
					</div>
				</c:if>
				
				 <c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">
							Not Authorize !
					</div>
				</c:if>
				
                    <div id="login-box" class="col-md-12">
                        <form action="j_spring_security_check" id="formLogin" method="POST">
                            <h3 class="text-center text-info">Đăng nhập</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Tên đăng nhập :</label><br>
                                <input type="text" name="j_username" id="userName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Mật khẩu:</label><br>
                                <input type="text" name="j_password" id="password" class="form-control">
                            </div>
                             <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Lưu mật khẩu</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="#" class="text-info">Đăng kí</a>
                            </div>
 
                        </form>
                    </div>
                </div>
            </div>
        </div>
   
</body>
</html>
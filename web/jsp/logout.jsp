<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <fmt:setLocale value="${locale}" scope="session"/>
        <fmt:bundle basename="title" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="header.title"/></title>
        <link rel="stylesheet" href="..\css\style.css" type="text/css">
    </head>
    <body>
        <div class="page-wrapper"> 
            <div class="page-buffer">    
                <div class="header"> 
                    <c:import url='\common\header.jsp' charEncoding="utf-8"/> 
                </div>
                    <div id="menu">     
                        <c:import url="\common\menu.jsp" charEncoding="utf-8"/> 
                    </div>
              <div id="page-content">   <h2><fmt:message key="goodbye"/>, ${userName} </h2>
                  <div id="login">
                    <form name ="LogOutForm" method="POST" action="carrent">
                            <input type="hidden" name="command" value="LOGOUT" />
                            <input name= "logout" type="submit" value="<fmt:message key="logout.confirm" />"/>
                    </form>
                  </div>
              </div>
            </div> 
        </div>
        <div class="footer">  <c:import url="\common\footer.jsp" charEncoding="utf-8"/> </div>
    </body>
</html>
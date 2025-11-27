<%-- 
    Document   : logout
    Created on : 27 de nov. de 2025, 14:24:14
    Author     : leons
--%>

<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>

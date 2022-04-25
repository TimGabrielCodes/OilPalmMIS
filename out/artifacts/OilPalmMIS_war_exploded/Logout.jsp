<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/04/2022
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>


<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
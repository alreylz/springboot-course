<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>JSP in SpringBoot example</title>
</head>
<body>
<h1><%= (String) request.getAttribute("name") %>
</h1>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: obi
  Date: 5/13/2020
  Time: 11:30 PM
--%>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.2/cerulean/bootstrap.min.css" rel="stylesheet" integrity="sha384-EmRcsPP774S9MOi4ywB+JXUWjYnBdyInMzG2XsC5siZEUpexqxOMJW358dCYEjPu" crossorigin="anonymous">
    <link rel="stylesheet" href="/SRMWebApp/css/style.css">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="/SRMWebApp/home">CS472-WAP : : : WallyMarty - Supplier Relationship Management (SRM) system</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <%-- check here if showing homepage then set active; else not active --%>
                    <c:choose>
                        <c:when test="${pagename eq 'home'}">
                            <li class="nav-item active" style="padding-right: 2em;">
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item" style="padding-right: 2em;">
                        </c:otherwise>
                    </c:choose>
                               <a class="nav-link" href="/SRMWebApp/home">Home <span class="sr-only">(current)</span></a>
                            </li>
                    <c:choose>
                        <c:when test="${pagename eq 'products'}">
                            <li class="nav-item active" style="border-left: white 1px solid; padding-left: 2em; padding-right: 2em;">
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item" style="border-left: white 1px solid; padding-left: 2em; padding-right: 2em;">
                        </c:otherwise>
                    </c:choose>
                                <a class="nav-link" href="/SRMWebApp/product/list">Browse Products</a>
                            </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <span style="color: white;">Welcome, Guest</span>
                </form>
            </div>
        </nav>
    </header>
<%--    <p>&nbsp;</p>--%>
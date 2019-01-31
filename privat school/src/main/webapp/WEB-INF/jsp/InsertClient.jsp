<%-- 
    Document   : InsertClient
    Created on : Nov 25, 2017, 7:42:28 PM
    Author     : m-alwan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>


            /* TABLES */

            table {
                border-top: 1px solid #DFDFDF;
                border-collapse: collapse;
                width: 100%;
                margin-bottom: 1em;
            }

            tr {
                border: 0;
            }

            tr>td:first-child, tr>th:first-child {
                padding-left: 1.25em;
            }

            tr>td:last-child, tr>th:last-child {
                padding-right: 1.25em;
            }

            td, th {
                line-height: 1.5em;
                padding: 0.5em 0.6em;
                text-align: left;
                vertical-align: top;
            }

            th {
                background-color: #efefef;
                background-image: -moz-linear-gradient(top, #ffffff, #eaeaea);
                background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ffffff), color-stop(1, #eaeaea));
                filter: progid:DXImageTransform.Microsoft.gradient(startColorStr = '#ffffff', EndColorStr = '#eaeaea');
                -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorStr='#ffffff', EndColorStr='#eaeaea')";
                color: #666666;
                font-weight: bold;
                line-height: 1.7em;
                padding: 0.2em 0.6em;
            }

            thead th {
                white-space: nowrap;
            }

            th a {
                display: block;
                text-decoration: none;
            }

            th a:link, th a:visited {
                color: #666666;
            }

            th a:hover, th a:focus {
                color: #333333;
            }

            body,
            input, select, textarea {
                font-family: "HelveticaNeue-Light", "Helvetica Neue Light", "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif;
            }

            h1, h2, h3, h4, h5, h6 {
                line-height: 1.1;
            }

            /* BASE LAYOUT */

            html {
                border-radius: 10px;
                background-color: #ddd;
                background-image: -moz-linear-gradient(center top, #aaa, #ddd);
                background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #aaa), color-stop(1, #ddd));
                background-image: linear-gradient(top, #aaa, #ddd);
                filter: progid:DXImageTransform.Microsoft.gradient(startColorStr = '#aaaaaa', EndColorStr = '#dddddd');
                background-repeat: no-repeat;
                height: 100%;
                /* change the box model to exclude the padding from the calculation of 100% height (IE8+) */
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            html.no-cssgradients {
                background-color: #aaa;
            }

            .ie6 html {
                height: 100%;
            }

            html * {
                margin: 0;
            }

            body {
                background: #ffffff;
                color: #333333;
                margin: 0 auto;
                max-width: 960px;
                overflow-x: hidden; /* prevents box-shadow causing a horizontal scrollbar in firefox when viewport < 960px wide */
                -moz-box-shadow: 0 0 0.3em #255b17;
                -webkit-box-shadow: 0 0 0.3em #255b17;
                box-shadow: 0 0 0.3em #255b17;
                box-shadow: 0 0 0.3em #255b17;
                border-radius: 10px;
                border: 0px;
            }
            a:link, a:visited, a:hover {
                color: #48802c;
            }

            a:hover, a:active {
                outline: none; /* prevents outline in webkit on active links but retains it for tab focus */
            }

            h1 {
                color: #48802c;
                font-weight: normal;
                font-size: 1.25em;
                margin: 0.8em 0 0.3em 0;
            }

            .content {
                border-radius: 10px;
            }

            .content h1 {
                border-bottom: 1px solid #CCCCCC;
                margin: 0.8em 1em 0.3em;
                padding: 0 0.25em;
            }

            .scaffold-list h1 {
                border: none;
            }
            .header {
                background: #abbf78;
                color: #000;
                clear: both;
                font-size: 0.8em;
                margin-top: 1.5em;
                padding: 1em;
                min-height: 1em;
                text-align: center;
                border: 3px solid #abbf78;
                border-radius: 10px;
            }
            .header h1 {
                color: #255b17;
                text-align: center;
                font-size: larger
            }

            .footer {
                background: #abbf78;
                color: #000;
                clear: both;
                font-size: 0.8em;
                margin-top: 1.5em;
                padding: 1em;
                min-height: 1em;
                border: 3px solid #abbf78;
                border-radius: 10px;
                text-align: center;
            }

            .footer a {
                color: #255b17;
            }

            .spinner {
                background: url(../images/spinner.gif) 50% 50% no-repeat transparent;
                height: 16px;
                width: 16px;
                padding: 0.5em;
                position: absolute;
                right: 0;
                top: 0;
                text-indent: -9999px;
            }
            .nav {
                background-color: #efefef;
                padding: 0.5em 0.75em;
                -moz-box-shadow: 0 0 3px 1px #aaaaaa;
                -webkit-box-shadow: 0 0 3px 1px #aaaaaa;
                box-shadow: 0 0 3px 1px #aaaaaa;
                zoom: 1;
            }

            .nav ul {
                overflow: hidden;
                padding-left: 0;
                zoom: 1;
            }

            .nav li {
                display: block;
                float: left;
                list-style-type: none;
                margin-right: 0.5em;
                padding: 0;
            }

            .nav a {
                color: #666666;
                display: block;
                padding: 0.25em 0.7em;
                text-decoration: none;
                -moz-border-radius: 0.3em;
                -webkit-border-radius: 0.3em;
                border-radius: 0.3em;
            }

            .nav a:active, .nav a:visited {
                color: #666666;
            }

            .nav a:focus, .nav a:hover {
                background-color: #999999;
                color: #ffffff;
                outline: none;
                text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.8);
            }

            .no-borderradius .nav a:focus, .no-borderradius .nav a:hover {
                background-color: transparent;
                color: #444444;
                text-decoration: underline;
            }

            .nav a.home, .nav a.list, .nav a.create {
                background-position: 0.7em center;
                background-repeat: no-repeat;
                text-indent: 25px;
            }

            .nav a.home {
                background-image: url(../images/skin/house.png);
            }

            .nav a.list {
                background-image: url(../images/skin/database_table.png);
            }

            .nav a.create {
                background-image: url(../images/skin/database_add.png);
            }
            input, select, textarea {
                background-color: #fcfcfc;
                border: 1px solid #cccccc;
                font-size: 1em;
                padding: 0.2em 0.4em;
                border-radius:5px;
            }

            input, select {
                width: 160px;
                -ms-box-sizing:border-box;
                -moz-box-sizing:border-box;
                box-sizing:border-box;
                -webkit-box-sizing:border-box;
            }

            select {
                padding: 0.2em 0.2em 0.2em 0;
            }

            select[multiple] {
                vertical-align: top;
            }
            input:focus, select:focus, textarea:focus {
                background-color: #ffffff;
                border: 1px solid #eeeeee;
                outline: 0;
                -moz-box-shadow: 0 0 0.5em #ffffff;
                -webkit-box-shadow: 0 0 0.5em #ffffff;
                box-shadow: 0 0 0.5em #ffffff;
            }

            .required-indicator {
                color: #48802C;
                display: inline-block;
                font-weight: bold;
                margin-left: 0.3em;
                position: relative;
                top: 0.1em;
            }
            /* same effects for browsers that support HTML5 client-side validation (these have to be specified separately or IE will ignore the entire rule) */

            input:invalid, select:invalid, textarea:invalid {
                background: #fff3f3;
                border-color: #ffaaaa;
                color: #cc0000;
                border-radius:5px;
            }

            input:invalid:focus, select:invalid:focus, textarea:invalid:focus {
                -moz-box-shadow: 0 0 0.5em #ffaaaa;
                -webkit-box-shadow: 0 0 0.5em #ffaaaa;
                box-shadow: 0 0 0.5em #ffaaaa;
            }


            /* ACTION BUTTONS */

            .buttons {
                background-color: #efefef;
                overflow: hidden;
                padding: 0.3em;
                -moz-box-shadow: 0 0 3px 1px #aaaaaa;
                -webkit-box-shadow: 0 0 3px 1px #aaaaaa;
                box-shadow: 0 0 3px 1px #aaaaaa;
                margin: 0.1em 0 0 0;
                border: none;
                border-radius:5px;
            }

            .buttons input,
            .buttons a {
                background-color: transparent;
                border: 0;
                color: #666666;
                cursor: pointer;
                display: inline-block;
                margin: 0 0.25em 0;
                overflow: visible;
                padding: 0.25em 0.7em;
                text-decoration: none;

                -moz-border-radius: 0.3em;
                -webkit-border-radius: 0.3em;
                border-radius: 0.3em;
            }

            .buttons input:hover, .buttons input:focus,
            .buttons a:hover, .buttons a:focus {
                background-color: #999999;
                color: #ffffff;
                outline: none;
                text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.8);
                -moz-box-shadow: none;
                -webkit-box-shadow: none;
                box-shadow: none;
            }

            .no-borderradius .buttons input:hover, .no-borderradius .buttons input:focus,
            .no-borderradius .buttons a:hover, .no-borderradius .buttons a:focus {
                background-color: transparent;
                color: #444444;
                text-decoration: underline;
            }




        </style>
    </head>
    <body>
        <div class="header" role="contentinfo">
            <h1>Project LO54 Formation d'une Ecole Privée <br/>Marwan ALWAN </h1>
        </div>
        <div class="content">
            <form action="InsertClient" method="post">
                <table >
                    <tr>
                        <td>First Name:</td> <td><input type="text" name="firstName" placeholder="First Name"/></td>
                    </tr> 
                    <tr>
                        <td>last Name:</td><td><input type="text" name="lastName" placeholder="Last Name" /></td>
                    </tr> 
                    <tr>
                        <td>Address:</td><td><input type="text" name="address" placeholder="Address" /></td>
                    </tr> 
                    <tr>
                        <td>Phone:</td><td><input type="text" name="phoneNumber" placeholder="Phone"/></td>
                    </tr> 
                    <tr>
                        <td>Email:</td><td><input type="text" name="email" placeholder="example@host.com" /></td>
                    </tr> 
                    <tr>
                        <td>Save</td><td><input type="submit" value="Save" name="btnSave" class="buttons" /></td>
                    </tr> 
                </table>
                <input type="text" name="CourseSessionId1" hidden="true" value="<%=request.getParameter("CourseSessionId")%>"  />
            </form>
        </div>
        <div class="footer" role="contentinfo">
            <h1>info@eample.com</h1>
            <a href="controller">Go Bach</a>
        </div>
    </body>
</html>

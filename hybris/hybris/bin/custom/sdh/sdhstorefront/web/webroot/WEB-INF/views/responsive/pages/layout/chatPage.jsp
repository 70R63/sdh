<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="${commonResourcePath}/js/websocket.js" type="text/javascript" ></script>

<style type="text/css" media="screen">
.chat
{
    list-style: none;
    margin: 0;
    padding: 0;
}

.chat li
{
    margin-bottom: 10px;
    padding-bottom: 5px;
    border-bottom: 1px dotted #B3A9A9;
}

.chat li.left .chat-body
{
    margin-left: 60px;
}

.chat li.right .chat-body
{
    margin-right: 60px;
}


.chat li .chat-body p
{
    margin: 0;
    color: #777777;
}

.panel .slidedown .glyphicon, .chat .glyphicon
{
    margin-right: 5px;
}

.panel-body
{
    overflow-y: scroll;
    height: 400px;
}

::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

    #outer{
      position:static;
      top:0;
      left:0;
      width:100%;
      height:100%;
      background:aliceblue;
    }
    #inner{
      width: 99%;
      height: auto;
      top: 1%;
      margin: 0 auto;
      position: relative;
      background-color:white;
      border-radius: 30px;
    }

</style>


<html>
    <head>
        <title>Chat</title>
    </head>
<c:set var = "userType" scope = "session" value = "${param.userType}"/>
<body style="background-color: aliceblue; ">
    <div class="container"  id="outer" >
        </br>
        <div class="row align-center" id="inner">
        <h3 class="text-center">Inicio</h3>
        </br>
            <form class="form-horizontal col-lg-11" id="chatForm">
                <div class="form-group">
                    <div class="input-group col-lg-9 col-lg-offset-2">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input class="form-control" id="email" type="email" placeholder="email@email.com" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group  col-lg-9 col-lg-offset-2">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" id="userName" type="text" placeholder="Nombre">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group  col-lg-9 col-lg-offset-2">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select class="form-control" id="tipoAsunto">
                            <option>- Seleccionar -</option>
                            <option>Opcion 1</option>
                            <option>Opcion 2</option>
                            <option>Opcion 3</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-9 col-lg-offset-2">
                        <textarea class="form-control" rows="11" id="comentario" placeholder="&iquest;En que podemos ayudarte?"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-9 col-lg-offset-2 text-right">
                        <button type="button" class="btn btn-info" onclick="sendForm()">Aceptar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div >
        <div id="chatMode" >
            <input type="hidden" id="receiverUser" value="">
            <div class="panel panel-info"  style="border-top: 0px solid white; border-bottom: white; border-right: white; border-left: white; ">
                <div class="panel-heading" style="height: 41px">
                    <span class="glyphicon glyphicon-comment"></span> Chat
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </button>
                        <ul class="dropdown-menu slidedown">
                            <!--<li><a href="#" onclick="connect('CUSTOMER');"><span class="glyphicon glyphicon-ok-sign"></span>
                                Available</a></li>-->
                            <li><a href="#" onclick="closeSession();"><span class="glyphicon glyphicon-off"></span>
                                Cerrar Session</a></li>
                        </ul>
                    </div>
                </div>
                <div class="panel-body" style="height: 80%">
                    <ul id="chatMessages" class="chat">
                    </ul>
                </div>
                <div class="panel-footer" style="height: 8%">
                    <div class="input-group">
                        <input id="msg" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat" onclick="send();">
                                Send
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script>
        function sendForm() {
            $("#chatMode").show();
            $("#outer").hide();
            connect();
        }

        $(document).ready(function(){
            var usrType = '${userType}';
            if(usrType == "AGENT"){
                $("#chatMode").show();
                $("#outer").hide();
            }else{
                $("#chatMode").hide();
            }
        });

        function refreshPage(){
            location.reload();
        }
    </script>
</body>
</html>


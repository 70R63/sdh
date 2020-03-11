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

</style>

<html>
    <head>
        <title>Chat</title>
    </head>

    <!-- <body>
        <table>
            <tr>
                <td colspan="2">
                    <input type="text" id="username" placeholder="Username"/>
                    <button type="button" onclick="connect();" >Connect</button>
                </td>
            </tr>
            <tr>
                <td>
                    <textarea readonly="true" rows="10" cols="52" id="log"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" size="51" id="msg" placeholder="Message"/>
                    <button type="button" onclick="send();" >Send</button>
                </td>
            </tr>
        </table>
    </body> -->
                <input type="hidden" id="username" value="jair.r04@gmail.com">
                <div class="panel panel-primary"
                    style="border-top: 2px solid white; border-bottom: white; border-right: white; border-left: white; ">
                    <div class="panel-heading" style="height: 7%">
                        <span class="glyphicon glyphicon-comment"></span> Chat
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-chevron-down"></span>
                            </button>
                            <ul class="dropdown-menu slidedown">
                                <li><a href="#" onclick="connect();"><span class="glyphicon glyphicon-ok-sign"></span>
                                    Available</a></li>
                                <li><a href="http://www.jquery2dotnet.com"><span class="glyphicon glyphicon-off"></span>
                                    Sign Out</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel-body" style="height: 80%">
                        <ul id="chatMessages" class="chat">
                            <li class="right clearfix"><span class="chat-img pull-right">
                                                        <img src="http://placehold.it/50/FA6F57/fff&text=ME" alt="User Avatar" class="img-circle" />
                                                    </span>
                                                        <div class="chat-body clearfix">
                                                            <div class="header">
                                                                <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>13 mins ago</small>
                                                                <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                                            </div>
                                                            <p>
                                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                                                dolor, quis ullamcorper ligula sodales.
                                                            </p>
                                                        </div>
                                                    </li>
                                                    <li class="left clearfix"><span class="chat-img pull-left">
                                                        <img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle" />
                                                    </span>
                                                        <div class="chat-body clearfix">
                                                            <div class="header">
                                                                <strong class="primary-font">Jack Sparrow</strong> <small class="pull-right text-muted">
                                                                    <span class="glyphicon glyphicon-time"></span>14 mins ago</small>
                                                            </div>
                                                            <p>
                                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                                                dolor, quis ullamcorper ligula sodales.
                                                            </p>
                                                        </div>
                                                    </li>
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




</html>


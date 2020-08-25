var ws;
var userContentType;
var agentName;
var pickedSessionId;
var hasAgentActivedSession = false;
var blockedUser;

function connect() {
    var userId = $("#email").val();
    var username = $("#userName").val();
    var comentario = $("#comentario").val();
    var tipoAsunto = $( "#tipoAsunto option:selected" ).text();
    userContentType = "CustomerUserMessage";

    var host = document.location.host;
    ws = new WebSocket("wss://"+host+"/bogota/chatEndPoint/CUSTOMER/"
                        +userId+"/"
                        +username+"/"
                        +comentario+"/"
                        +tipoAsunto+"");

    ws.onmessage = function(event) {
        var message = JSON.parse(event.data);
        document.getElementById("receiverUser").value = message.from;
        printReceivedMessage(message.userName, message.content);
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var receiverUser =  $("#receiverUser").val();
    var agentName =  $("#userName").val();
    var json = JSON.stringify({
        "content":content,
        "to": receiverUser,
        "contentType": userContentType,
        "userName": agentName
    });
    ws.send(json);
    printMyMessage(agentName, content);
}

function displayMessage (evt) {
    var host = document.location.host;
    ws = new WebSocket("wss://"+host+"/bogota/chatEndPoint/AGENTSESSION/"+evt.data.agentId+"/"+evt.data.agentName+"/NoData/NoData");
    document.getElementById("receiverUser").value = evt.data.sessionId;
    document.getElementById("userName").value = evt.data.agentName;
    userContentType = "AgentUserMessage";
    agentName = evt.data.agentName;
    blockedUser = evt.data.userId;

    printReceivedMessage(evt.data.userName, evt.data.content);
    ws.onmessage = function(event) {
        var message = JSON.parse(event.data);
        console.log(message);
        if(message.contentType == "closeSession"){
            refreshPage();
        }else{
            printReceivedMessage(evt.data.userName, message.content);
        }
    };

    var json = JSON.stringify({
        "from": blockedUser,
        "userSessionId" : evt.data.sessionId,
        "contentType": "blockSession"
    });
    ws.onopen = () => ws.send(json);
}

function closeSession(){
    sendTo = document.getElementById("receiverUser").value;
    if(hasAgentActivedSession){//Unblock Customer session
        var json = JSON.stringify({
            "from": blockedUser,
            "userSessionId" : document.getElementById("receiverUser").value,
            "contentType": "unBlockCustomer",
        });
        ws.send(json);
    }else{//Close customer session
        var json = JSON.stringify({
            "to": sendTo,
            "contentType": "closeSession",
        });
        ws.send(json);
        hasAgentActivedSession = false;
    }
     refreshPage();
}

function printMyMessage(usarName, content){
    document.getElementById("chatMessages").innerHTML += "<li class=\"right clearfix\"><span class=\"chat-img pull-right\">" +
    "<img src=\"http://placehold.it/50/FA6F57/fff&text=ME\" alt=\"User Avatar\" class=\"img-circle\" />" +
    "</span><div class=\"chat-body clearfix\"><div class=\"header\">" +
    "<small class=\" text-muted\"><span class=\"glyphicon glyphicon-time\"></span>13 mins ago</small>" +
    "<strong class=\"pull-right primary-font\">"+usarName+"</strong></div>" +
    "<p>"+content+"</p></div></li>";
}

function printReceivedMessage(usarName, content){
    document.getElementById("chatMessages").innerHTML +=
    "<ul id=\"chatMessages\" class=\"chat\"> <li class=\"left clearfix\"><span class=\"chat-img pull-left\">"
    + "<img src=\"http://placehold.it/50/55C1E7/fff&text="+usarName.charAt(0)+"\" alt=\"User Avatar\" class=\"img-circle\" />"
    + "</span> <div class=\"chat-body clearfix\"><div class=\"header\"><strong class=\"primary-font\">"
    + usarName + "</strong> <small class=\"pull-right text-muted\"><span class=\"glyphicon glyphicon-time\">"
    + "</span>12 mins ago</small></div><p>"+content+"</p></div></li></ul>";
}

function iFrameMessage(evt){
    if(evt.data.messageType == "pickNewChatSession"){
        if(hasAgentActivedSession){
            alert("Ya existe una session activa (Cierre la session actual para iniciar una nueva)");
        }else{
            displayMessage (evt);
            hasAgentActivedSession = true;
        }
    }
}

if (window.addEventListener) {
	window.addEventListener("message", iFrameMessage, false);
}
else {
	window.attachEvent("onmessage", iFrameMessage);
}



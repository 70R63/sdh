var ws;

function connect() {
    var username = document.getElementById("username").value;
    var host = document.location.host;
    ws = new WebSocket("wss://"+host+"/sdhstorefront/chatEndPoint/" + username);
    ws.onmessage = function(event) {
        console.log(event.data);
        var message = JSON.parse(event.data);
        document.getElementById("chatMessages").innerHTML +=
        "<ul id=\"chatMessages\" class=\"chat\"> <li class=\"left clearfix\"><span class=\"chat-img pull-left\">"
        + "<img src=\"http://placehold.it/50/55C1E7/fff&text=U\" alt=\"User Avatar\" class=\"img-circle\" />"
        + "</span> <div class=\"chat-body clearfix\"><div class=\"header\"><strong class=\"primary-font\">"
        + "Jack Sparrow</strong> <small class=\"pull-right text-muted\"><span class=\"glyphicon glyphicon-time\">"
        + "</span>12 mins ago</small></div><p>"+message.content+"</p></div></li></ul>";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var json = JSON.stringify({
        "content":content
    });

    ws.send(json);
}

function displayMessage (evt) {
	var message;
	message = "I got " + evt.data + " from " + evt.origin;
	document.getElementById("chatMessages").innerHTML +=
            "<ul id=\"chatMessages\" class=\"chat\"> <li class=\"left clearfix\"><span class=\"chat-img pull-left\">"
            + "<img src=\"http://placehold.it/50/55C1E7/fff&text=U\" alt=\"User Avatar\" class=\"img-circle\" />"
            + "</span> <div class=\"chat-body clearfix\"><div class=\"header\"><strong class=\"primary-font\">"
            + "Jack Sparrow</strong> <small class=\"pull-right text-muted\"><span class=\"glyphicon glyphicon-time\">"
            + "</span>12 mins ago</small></div><p>"+message+"</p></div></li></ul>";
}

if (window.addEventListener) {
	window.addEventListener("message", displayMessage, false);
}
else {
	window.attachEvent("onmessage", displayMessage);
}
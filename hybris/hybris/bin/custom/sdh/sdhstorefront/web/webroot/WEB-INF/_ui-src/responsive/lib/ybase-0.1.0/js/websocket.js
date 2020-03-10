var ws;

function connect() {
    var username = document.getElementById("username").value;
    
    var host = document.location.host;
    ws = new WebSocket("wss://"+host+"/sdhstorefront/chatEndPoint/" + username);

    ws.onmessage = function(event) {
    var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
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
	document.getElementById("log").innerHTML = message;
}

if (window.addEventListener) {
	window.addEventListener("message", displayMessage, false);
}
else {
	window.attachEvent("onmessage", displayMessage);
}
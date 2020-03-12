var ws;

function connect() {
    var username = document.getElementById("username").value;
    var host = document.location.host;
    ws = new WebSocket("wss://"+host+"/sdhstorefront/chatEndPoint/" + username);

    console.log("asdasdasd");

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
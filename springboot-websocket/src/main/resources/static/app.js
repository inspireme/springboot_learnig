var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation, #msgsendArea").show();
    }
    else {
        $("#conversation, #msgsendArea").hide();
    }
    $("#greetings").html("");
}

function connect() {
    if(!$("#name").val()){
        alert("please input username");
        return;
    }
    var socket = new SockJS('/simple-chat'); // endpoint
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            var msg = JSON.parse(greeting.body);
            showGreeting(msg.name + '->' + msg.content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMsg() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'content' : $("#content").val()}));
}

function sendMsg2() {
    stompClient.send("/app/hello2", {}, JSON.stringify({'name': $("#name").val(), 'content' : $("#content").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("#conversation, #msgsendArea").hide();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMsg(); });
    $( "#send2" ).click(function() { sendMsg2(); });
});
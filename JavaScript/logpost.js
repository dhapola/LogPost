var BASE_SERVICE_URL = 'http://10.10.10.6:45600/';
var INFO_SERVICE = BASE_SERVICE_URL + 'logpost-ws/info';
var WARN_SERVICE = BASE_SERVICE_URL + 'logpost-ws/warn';
var ERROR_SERVICE = BASE_SERVICE_URL + 'logpost-ws/error';

alert('test');

function logInfo(message){
    alert('q');
    postMessage(INFO_SERVICE, message);
}

function logWarn(message){
    postMessage(WARN_SERVICE, message);
}

function logError(message){
    postMessage(ERROR_SERVICE, message);
}

function postMessage(url, message){
    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "text/plain; charset=utf-8");
    xhttp.setRequestHeader("Content-Length", message.length );

    xhttp.onreadystatechange = function() {
        if (this.readyState == 200) {
           //message logged
        }
    };
    
    xhttp.send();
}
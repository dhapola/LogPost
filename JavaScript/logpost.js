/**
 * This JavaScript file encapsulates capabilities for posting log entries to
 * logpost service asynchronously. Successfully posted log entries are picked up by ELK stack
 *
 * @author  Deepesh Dhapola
 * @version 1.0
 * @since   2020-04-19
 *
 */


var BASE_SERVICE_URL = 'http://10.10.10.6:45600/';
var INFO_SERVICE = BASE_SERVICE_URL + 'logpost-ws/info';
var WARN_SERVICE = BASE_SERVICE_URL + 'logpost-ws/warn';
var ERROR_SERVICE = BASE_SERVICE_URL + 'logpost-ws/err';


/**
     * Send an information log message.
     * 
     * message - The message you would like logged.
     */
function logInfo(message) {
    postMessage(INFO_SERVICE, message);
}

/**
     * Send an warning log message.
     * 
     * message - The message you would like logged.
     */
function logWarn(message) {
    postMessage(WARN_SERVICE, message);
}

/**
     * Send an error log message.
     * 
     * message - The message you would like logged.
     */
function logError(message) {
    postMessage(ERROR_SERVICE, message);
}

/**
     * Makes HTTP POST requests.
     * 
     * url - info, warn or error URLs
     * message - The message you would like logged.
     */
function postMessage(url, message) {
    var xhttp = new XMLHttpRequest();

    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "text/plain; charset=utf-8");

    xhttp.onreadystatechange = function () {
        if (this.readyState == 200) {
            //message logged
        }
    };

    xhttp.send(message);
}

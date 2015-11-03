//import http module 
var http = require("http");

//show "Hello World" at http://localhost:8888
//create server for listening http request
//use the nonsync_even_drive_callback_function
function start(){
    http.createServer(function(request, response){
            console.log("Request received.");
            response.writeHead(200, {"Content-Type": "text/plain"});
            response.write("Hello World.");
            response.end();
            }).listen(8888);
    console.log("Server is started.");
}

exports.start = start;

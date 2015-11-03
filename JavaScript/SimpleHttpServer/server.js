var http = require("http");
var url = require("url");           //to analyze the request URL 

//show "Hello World" at http://localhost:8888
//create server for listening http request
//use the nonsync_even_drive_callback_function
function start(route){
    http.createServer(function(request, response){
            var pathname = url.parse(request.url).pathname;         //get the http request URL
            console.log("Request for "+pathname+" received.");
            
            route(pathname);            //add the router which respond to different URL
            
            response.writeHead(200, {"Content-Type": "text/plain"});
            response.write("Hello World.");
            response.end();
            }).listen(8888);
    console.log("Server is started.");
}

exports.start = start;

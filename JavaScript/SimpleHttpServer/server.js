var http = require("http");
var url = require("url");           //to analyze the request URL 

//show "Hello World" at http://localhost:8888
//create server for listening http request
//use the nonsync_even_drive_callback_function
//in order to do non-blocking operation, need the callback function when the procedure is too long
function start(route, handle){
    http.createServer(function(request, response){
            var pathname = url.parse(request.url).pathname;         //get the http request URL
            console.log("Request for "+pathname+" received.");
            //add the router which respond to different URL, and pass the URL related handle function to router, and pass the response function for the end of handle 
            route(pathname, handle, response);
            }).listen(8888);
    console.log("Server is started.");
}

exports.start = start;

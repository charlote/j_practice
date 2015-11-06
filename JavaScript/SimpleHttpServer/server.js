var http = require("http");
var url = require("url");           //to analyze the request URL 

//show "Hello World" at http://localhost:8888
//create server for listening http request
//use the nonsync_even_drive_callback_function
//in order to do non-blocking operation, need the callback function when the procedure is too long
function start(route, handle){
    http.createServer(function(request, response){
            var postData = "";
            var pathname = url.parse(request.url).pathname;         //get the http request URL
            console.log("Request for "+pathname+" received.");

            request.setEncoding("utf8");            //set UTF-8 as the data code-form
            request.addListener("data", function(postDataChunk){    //register "data" listener which collect all data chunk in 'postData' 
                postData += postDataChunk;
                console.log("Received POST data chunk '"+postDataChunk+"'");
                });
            request.addListener("end", function(){                  //router will be touched when the data collection finish and only trig one time
                //add the router which respond to different URL, and pass the URL related handle function to router, and pass the response function for the end of handle 
                route(pathname, handle, response, postData);
                });
            }).listen(8888);
    console.log("Server is started.");
}

exports.start = start;

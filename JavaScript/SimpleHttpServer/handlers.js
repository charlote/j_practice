//the request handle percedures
//in order to offer callback to the non-blocking operation, pass in server's response for callback as the end of long time procedure
var exec = require("child_process").exec;           //to do the shell command

//print 'root'
function root(response){
    console.log("Request handler 'root' was called.");
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("root");
    response.end();
}
//print all path under '/'
function start(response){
    console.log("Request handler 'start' was called.");
    //long time procedure example
    exec("find /", 
            {timeout: 10000, maxBuffer: 20000*1024},    //for non-blocking operation 
            function(error, stdout, stderr){            //callback after the handler finish
            response.writeHead(200, {"Content-Type": "text/plain"});
            response.write(stdout);
            response.end();
            });
}
//print 'upload'
function upload(response){
    console.log("Request handler 'upload' was called.");
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("upload");
    response.end();
}

exports.root = root;
exports.start = start;
exports.upload = upload;

//the request handle percedures
//in order to offer callback to the non-blocking operation, pass in server's response for callback as the end of long time procedure
var exec = require("child_process").exec;           //to do the shell command
var querystring = require("querystring");
var fs = require("fs");

//print 'root'
function root(response, postData){
    console.log("Request handler 'root' was called.");
    //display a textarea(2*30) for user to input content and a button with 'submit text' which will connect to '/upload' page
    var body = '<html>'+
        '<head>'+
        '<meta http-equiv="Content-Type" content="text/html;'+
        'charset=UTF-8" />'+
        '</head>'+
        '<body>'+
        '<form action="/upload" method="post">'+
        '<textarea name="text" rows="2" cols="30"></textarea>'+
        '<input type="submit" value="Submit text" />'+
        '</form>'+
        '</body>'+
        '</html>';

    response.writeHead(200, {"Content-Type": "text/html"});
    response.write(body);
    response.end();
}
//print all path under '/'
function start(response, postData){
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
function upload(response, postData){
    console.log("Request handler 'upload' was called.");
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("You have sent: "+querystring.parse(postData).text);
    response.end();
}
//show /tmp/test.png image on browser
function show(response, postData){
    console.log("Request handler 'show' was called");
    fs.readFile("/tmp/test.png", "binary", function(error, file){
            if(error){
                response.writeHead(500, {"Content-Type": "text/plain"});
                response.write(error+"\n");
                response.end();
            } else {
                response.writeHead(200, {"Content-Type": "image/png"});
                response.write(file, "binary");
                response.end();
            }
        });
}

exports.root = root;
exports.start = start;
exports.upload = upload;
exports.show = show;

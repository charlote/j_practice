//the request handle percedures
//in order to offer callback to the non-blocking operation, pass in server's response for callback as the end of long time procedure
var exec = require("child_process").exec;           //to do the shell command
var querystring = require("querystring");
var fs = require("fs");
var formidable = require("formidable");

//print 'root'
function root(response, request){
    console.log("Request handler 'root' was called.");
    //display a file upload module and a button with 'Upload' which will connect to '/upload' page
    var body = '<html>'+
        '<head>'+
        '<meta http-equiv="Content-Type" content="text/html;'+
        'charset=UTF-8" />'+
        '</head>'+
        '<body>'+
        '<form action="/upload" enctype="multipart/form-data" method="post">'+      //add multipart/form-data code data-type
        '<input type="file" name="upload" multipe="multipe">'+            //add upload module
        '<input type="submit" value="Upload" />'+
        '</form>'+
        '</body>'+
        '</html>';

    response.writeHead(200, {"Content-Type": "text/html"});
    response.write(body);
    response.end();
}
//print all path under '/'
function start(response, request){
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
//parse image which from '/start' image-upload-module and copy to '/tmp' than show on browser
function upload(response, request){
    console.log("Request handler 'upload' was called.");
    var form = new formidable.IncomingForm();           //send request by HTTP_POST to node.js
    console.log("about to parse");
    form.parse(request, function(error, fields, files){ 
            console.log("parsing done");
            fs.renameSync(files.upload.path, "/tmp/test.png");          //cope target file to /tmp and rename as "test.png"
            response.writeHead(200, {"Content-Type": "text/html"});
            response.write("received image:<br/>");
            response.write("<img src='/show' />");          //show image on browser
            response.end();
        });
}
//show /tmp/test.png image on browser
function show(response, request){
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

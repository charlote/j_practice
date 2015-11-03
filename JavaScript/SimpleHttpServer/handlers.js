//the request handle percedures
function root(){
    console.log("Request handler 'root' was called.");
}
function start(){
    console.log("Request handler 'start' was called.");
}

function upload(){
    console.log("Request handler 'upload' was called.");
}

exports.root = root;
exports.start = start;
exports.upload = upload;

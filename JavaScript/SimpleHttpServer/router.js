//router: respond to different URL and do the URL related handle function
function route(pathname, handle, response, request){
    console.log("About to route a request for "+pathname);
    if(typeof handle[pathname] === 'function'){         //check the handle function do exist
        handle[pathname](response, request);            //pass the response(callback) for end of handle function
    } else {
        console.log("No request handler for "+pathname);
        response.writeHead(404, {"Content-Type": "text/plain"});
        response.write("404 Not Found");
        response.end();
    }
}
exports.route = route;

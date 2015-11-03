//router: respond to different URL and do the URL related handle function
function route(pathname, handle){
    console.log("About to route a request for "+pathname);
    if(typeof handle[pathname] === 'function'){         //check the handle function do exist
        handle[pathname]();
    } else {
        console.log("No request handler for "+pathname);
    }
}
exports.route = route;

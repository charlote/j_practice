//import module
var server = require("./server");
var router = require("./router");
var handlers = require("./handlers");

//package a group of handler functions to a object --> handle (like associative array)
var handle = {}
handle["/"] = handlers.root;
handle["/start"] = handlers.start;
handle["/upload"] = handlers.upload;
handle["/show"] = handlers.show;

server.start(router.route, handle);         //start server with router, and pass the handle function to router

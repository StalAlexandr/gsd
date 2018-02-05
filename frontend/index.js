
var express = require('express');

// создаём Express-приложение
var app = express();
var path = require('path');

var cors = require('cors');
//app.use(cors());


var originsWhitelist = [
  'http://localhost:7000'      //this is my front-end url for development

];
var corsOptions = {
  origin: function(origin, callback){
        var isWhitelisted = originsWhitelist.indexOf(origin) !== -1;
        callback(null, isWhitelisted);
  },
  credentials:true
}

//here is the magic
app.use(cors(corsOptions));

app.use('/public',express.static(path.join(__dirname, '/public'))); 

console.log(path.join(__dirname, '/public'));


 app.use(function(req, res, next) {
res.setHeader('Access-Control-Allow-Origin', '*');
res.setHeader('Access-Control-Allow-Headers', 'origin, content-type, accept');
	 next();
});


// создаём маршрут для главной страницы
// http://localhost:8080/
app.get('/', function(req, res) {

res.sendFile(path.join(__dirname,  'index.html'));
});

// запускаем сервер на порту 8080
app.listen(7000);
// отправляем сообщение
console.log('Сервер стартовал!');
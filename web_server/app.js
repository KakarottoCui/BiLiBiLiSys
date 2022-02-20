const express = require('express');
const app = express();
app.set('env', 'production');
app.use(express.static('webroot'));
app.get('/', (req, res) => {
	res.sendFile('index.htm', {root: __dirname + '/webroot'});
});
const server = app.listen(10086);
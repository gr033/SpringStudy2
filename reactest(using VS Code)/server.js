var http = require("http");
var express = require("express");
var app = express();

app.use(express.static("public"));
app.use(express.bodyParser());
app.use(app.router);
const oracledb = require('oracledb');
oracledb.outFormat = oracledb.OUT_FORMAT_OBJECT;
const mypw = "sist";



app.get("/listDept",function(req,res){
	async function run() {

	let connection;

	try {
		connection = await oracledb.getConnection( {
		user          : "c##madang",
		password      : "madang",
		connectString : "localhost:1521/XE"
		});

		const result = await connection.execute(
		`select * from dept`
		);
		console.log(result.rows);
		res.send(result.rows);

	} catch (err) {
		console.error(err);
	} finally {
		if (connection) {
		try {
			await connection.close();
		} catch (err) {
			console.error(err);
		}
		}
	}
	}

	run();
});

app.post("/deleteDept", function(req,res){
	var body = req.body;	
    var dept = JSON.parse(Object.keys(body)[0])
	var dno = dept.DNO;
	// var dname = dept.DNAME;
	// var dloc = dept.DLOC;
	var sql = "delete dept where dno="+dno;
	async function run() {
		let connection;	
		try {
			connection = await oracledb.getConnection( {
			user          : "c##sist",
			password      : mypw,
			connectString : "localhost:1521/XE"
			});
			
			const result = await connection.execute(sql);
			connection.commit();
			console.log(result.rowsAffected);
			res.send("OK");;
	
		} catch (err) {
			console.error(err);
		} finally {
			if (connection) {
			try {
				await connection.close();
			} catch (err) {
				console.error(err);
			}
			}
		}
		}
	
		run();
	
	
});

app.post("/updateDept", function(req,res){
	var body = req.body;	
    var dept = JSON.parse(Object.keys(body)[0])
	var dno = dept.DNO;
	var dname = dept.DNAME;
	var dloc = dept.DLOC;
	var sql = "update dept set dname='"+dname+"',dloc='"+dloc+"' where dno="+dno;
	async function run() {
		let connection;	
		try {
			connection = await oracledb.getConnection( {
			user          : "c##sist",
			password      : mypw,
			connectString : "localhost:1521/XE"
			});
			
			const result = await connection.execute(sql);
			connection.commit();
			console.log(result.rowsAffected);
			res.send("OK");;
	
		} catch (err) {
			console.error(err);
		} finally {
			if (connection) {
			try {
				await connection.close();
			} catch (err) {
				console.error(err);
			}
			}
		}
		}
	
		run();
	
	
});

app.post("/insertDept", function(req,res){
    console.log("insertDept-----------------------------------")
	var body = req.body;	
    var dept = JSON.parse(Object.keys(body)[0]);
	var dno = dept.DNO;
	var dname = dept.DNAME;
	var dloc = dept.DLOC;

    console.log("body================================");
    console.log(body)
    console.log("dept    -----------------------------------");
    console.log(dept)
    console.log("dept   =======================================");
	var sql = "insert into dept values("+dno+",'"+dname+"','"+dloc+"')";
    console.log("sql:" + sql);

	async function run() {
		let connection;	
		try {
			connection = await oracledb.getConnection( {
			user          : "c##sist",
			password      : mypw,
			connectString : "localhost:1521/XE"
			});
			
			const result = await connection.execute(sql);
			connection.commit();
			console.log(result.rowsAffected);
			res.send("OK");;
	
		} catch (err) {
			console.error(err);
		} finally {
			if (connection) {
			try {
				await connection.close();
			} catch (err) {
				console.error(err);
			}
			}
		}
		}
	
		run();	
	
});

http.createServer(app).listen(52273, function(){
	console.log("Server Running at http://127.0.0.1:52273");
});
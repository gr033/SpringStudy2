let http = require('http');
let express = require('express');
let app = express();

app.use(express.static("public"));
app.use(express.bodyParser());
app.use(app.router);

const oracledb = require('oracledb');
oracledb.outFormat = oracledb.OUT_FORMAT_OBJECT;

app.get("/listDept", (req, res)=>{
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

http.createServer(app).listen(52273, ()=>{
    console.log('Server Running at http://127.0.0.1:52273');
});
const express = require('express'); // Import the Express module
const app = express();              // Create an Express application instance
const PORT = 3000; 
const cors = require('cors');
const commentController = require('./controllers/CommentController')

app.use(cors())
app.use(express.urlencoded({ extended: true }));
app.use(express.json())
app.use('/api/comments',commentController)

app.listen(8080, () => {
    console.log("Server listening on Port 8080")
})
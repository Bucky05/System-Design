const router = require('express').Router();
const likeRouter = require('./CommentLikeController')
const commentService = require('../services/CommentService')

router.use('/:comment_id/likes',likeRouter)
router.get('/', async (req,res) => {
     try {
        const data = await commentService.getComments(req.query.offset)
        res.json({ comments: data })
    } catch (err) {
        res.status(400).json({ error: err.message })
    }
})

router.post('/', async (req,res) => {
    try {
    const resp = await commentService.createComment({"user_id":req.body.user_id,"content":req.body.content})
    res.status(201).send()
    } catch (err) {
        res.status(500).json(err.message)
    }
})
router.delete('/:comment_id', async  ( req,res) => {
    await commentService.deleteComment(req.params.comment_id)
    res.status(204).send()
})

router.get('/:comment_id', async (req,res) => {
    const data = await commentService.getCommentById(req.params.comment_id)
    res.json({"comment":data})
})

module.exports = router;
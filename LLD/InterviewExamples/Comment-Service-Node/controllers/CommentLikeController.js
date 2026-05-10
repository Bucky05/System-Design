const router = require('express').Router({ mergeParams: true });
const commentService = require('../services/CommentService')
router.get('/', async (req,res) => {
    res.send( await commentService.getCommentLikeCount(req.params.comment_id))
})

router.post('/',async (req,res) => {
    await commentService.likeComment(req.body.user_id,req.params.comment_id)
    res.status(201).send()
})

router.delete('/', async(req,res) => {
    await commentService.unlikeComment(req.body.user_id, req.params.comment_id)
    res.status(204).send()
})

module.exports = router
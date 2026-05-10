module.exports = {
    getComments : () => {
        return `SELECT * FROM comments Limit 10 OFFSET ? `
    },
    getCommentById : () => {
        return `SELECT * FROM comments WHERE id = ?`
    },
    getCommentLikeCount : () => {
        return `SELECT like_count FROM comments WHERE id = ?`
    },
    setCommentLikeCount : () => {
        return `UPDATE comments SET like_count = ? WHERE id = ?`
    },
    getUserById : () => {
        return `SELECT * FROM users WHERE id = ?`
    },
    createComment : () => {
        return `INSERT INTO comments (status, like_count, user_id, content ) VALUES ('ACTIVE',0,?,?)`
    },
    deleteComment : () => {
        return `UPDATE comments SET status = 'DELETED' WHERE id = ?`
    },
    likeComment : () => {
        return `INSERT INTO comment_likes (user_id, comment_id) values (?,?)`
    },
    getLikeCommentByUserIdAndCommentId : () => {
        return `SELECT * FROM comment_likes WHERE user_id = ? and comment_id = ? `
    },
    unlikeComment : () => {
        return `DELETE FROM comment_likes WHERE user_id = ? AND comment_id = ?`
    }
}
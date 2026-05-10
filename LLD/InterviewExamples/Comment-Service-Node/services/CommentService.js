const conn = require('../config/db')
const queries = require('../queries/Queries')
module.exports = {
    // List all comments with offset
    getComments: async (offset) => {
        const [rows] = await conn.query(queries.getComments(), [Number(offset)]);
        return rows;
    },

    // Create a comment (matching your DTO logic)
    createComment: async (commentDTO) => {
        // Check if user exists (Optional but matches your Java orElseThrow)
        const [user] = await conn.query(queries.getUserById(), [commentDTO.user_id]);
        if (user.length === 0) throw new Error("User is not present");

        const [result] = await conn.query(queries.createComment(), [commentDTO.user_id, commentDTO.content]);
        return result;
    },

    // Get single comment
    getCommentById: getCommentById,

    // Soft delete logic
    deleteComment: async (comment_id) => {
        // MUST AWAIT here to get the actual array
        const rows = await getCommentById(comment_id);
        
        if (rows.length === 0) {
            throw new Error("Comment doesn't exist");
        }
        if (rows[0].status === 'DELETED') {
            throw new Error("Comment already deleted");
        }

        return await conn.query(queries.deleteComment(), [comment_id]);
    },

    // Like logic with check
    likeComment: async (user_id, comment_id) => {
        // 1. Verify user and comment exist
        const user = await conn.query(queries.getUserById(), [user_id]);
        const commentRows = await getCommentById(comment_id);

        if (user.length === 0) throw new Error("User not found");
        if (commentRows.length === 0) throw new Error("Comment not found");

        // 2. Check if already liked (existsByCommentAndUser)
        const [existingLike] = await conn.query(queries.getLikeCommentByUserIdAndCommentId(), [user_id, comment_id]);
        if (existingLike.length > 0) {
            throw new Error("User has already liked the comment");
        }

        // 3. Save like and increment count (Transactions recommended here)
        await conn.query(queries.likeComment(), [user_id, comment_id]);
        const likeCount = await getCommentLikeCount(comment_id)
        return await conn.query(queries.setCommentLikeCount(), [likeCount+1,comment_id]);
    },

    // Unlike logic
    unlikeComment: async (user_id, comment_id) => {
        const [existingLike] = await conn.query(queries.getLikeCommentByUserIdAndCommentId(), [user_id, comment_id]);
        if (existingLike.length === 0) {
            throw new Error("User has not liked the comment");
        }

        await conn.query(queries.unlikeComment(), [user_id, comment_id]);
        const likeCount = await getCommentLikeCount(comment_id)
        return await conn.query(queries.setCommentLikeCount(), [likeCount - 1 ,comment_id]);
    },

    getCommentLikeCount: getCommentLikeCount
};

// Helper functions (Hoisted)
async function getCommentById(comment_id) {
    const [rows] = await conn.query(queries.getCommentById(), [comment_id]);
    return rows; 
}

async function getCommentLikeCount(comment_id) {
    const [rows] = await conn.query(queries.getCommentLikeCount(), [comment_id]);
    if (rows.length === 0) throw new Error("Comment is not present");
    return rows[0].like_count;
}

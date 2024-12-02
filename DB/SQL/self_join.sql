-- Active: 1732689799045@@127.0.0.1@3306@practice

-- 댓글과 대댓글을 함께 조회
-- original : 원댓글
SELECT 
    original.id as original_id,
    original.content as original_content,
    child.id as reply_id,
    child.content as reply_content
FROM comments original 
-- parent_id 가 존재하는 대댓글을 self join
-- 대댓글이 없어도 원댓글을 조회할 수 있어야 하므로 left join
LEFT JOIN comments child ON child.parent_id = original.id
-- parent_id 가 없어야 내 부모 댓글이 없음 -> 원댓글
WHERE original.parent_id IS NULL;  -- 원댓글만 기준으로 조회
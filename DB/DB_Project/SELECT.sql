-- Active: 1732689799045@@127.0.0.1@3306@mini_db
-- 유저 : user
-- 강사 : instructor
-- 강좌 : course
-- 강의 : lecture
-- 수강평 : course_evaluate
-- 강의자료 : lecture_meta
-- 과제 : lecture_assign
-- 과제 제출 내역 : assign_submit
-- 퀴즈 : quiz
-- 퀴즈 제출 내역 : quiz_submit
-- 게시글 : post
-- 댓글 : comment
-- 학생 : student
-- 강사 북마크 : inst_bookmk
-- 강좌 북마크 : course_bookmk
-- 수강신청 : course_signup
-- 과목 : category

----------------------------------메인 페이지---------------------------------------

-- 선생님 목록 일부
SELECT u.user_name, u.user_email, i.inst_img, c.category_name
FROM instructor i
JOIN user u ON i.user_id = u.user_id
JOIN category c ON i.category_id = c.category_id
ORDER BY c.category_name
LIMIT 5

-- 강좌 목록 일부
-- 강좌 목록에서 강좌별 총 수강인원을 보여주고 싶다.

-- 문제가 발생한 코드
-- 강좌별 수강인원이 2명이 아니라 4명이 뜸
SELECT c.course_title, c.course_img, u.user_name,
	AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
	COUNT(cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
JOIN course_evaluate cev ON c.course_id = cev.course_id
JOIN course_signup cs ON c.course_id = cs.course_id
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name
LIMIT 5;

-- 디버깅
-- JOIN한 테이블 외의 것들은 다 지우고 컬럼을 모두 확인해보자
-- 문제 발견 : 수강평 테이블이 JOIN 되면서 course_signup_id가 2개씩 더 들어간 것 (데이터의 중복 발생)
SELECT *
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
JOIN course_evaluate cev ON c.course_id = cev.course_id
JOIN course_signup cs ON c.course_id = cs.course_id
ORDER BY c.course_title, u.user_id

-- 수강평 테이블과 연관된 부분을 주석 처리 해보자
SELECT c.course_title, c.course_img, u.user_name,
	-- AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
	COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
-- JOIN course_evaluate cev ON c.course_id = cev.course_id
JOIN course_signup cs ON c.course_id = cs.course_id
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name
LIMIT 5;

-- 정답 코드
-- 문제 해결 : 데이터 중복을 DISTINCT로 해결!
SELECT c.course_title, c.course_img, u.user_name,
	AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
	COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
LEFT JOIN course_evaluate cev ON c.course_id = cev.course_id
LEFT JOIN course_signup cs ON c.course_id = cs.course_id
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name
LIMIT 5;

-- 서브쿼리를 활용하면 의도했던 값이 나옴
-- 아예 다른 테이블처럼 됨 (수강평 테이블의 영향을 받지 않음)
SELECT course.course_title, course.course_start_date, course.course_date, course.course_end_date, course.course_img,
       AVG(cev.course_evaluate_point) AS avg_evaluate_point,
       (
           SELECT COUNT(*)
           FROM course_signup cs
           WHERE cs.course_id = course.course_id
       ) AS signup_count
FROM course
LEFT JOIN instructor inst ON inst.inst_id = course.inst_id
LEFT JOIN user us ON inst.user_id = us.user_id
LEFT JOIN course_evaluate cev ON course.course_id = cev.course_id
GROUP BY course.course_title, course.course_start_date, course.course_date, course.course_end_date, course.course_img, signup_count
LIMIT 5;

----------------------------------선생님 상세 페이지---------------------------------------

-- 강사 세부 페이지
SELECT u.user_name, u.user_email, i.inst_img, i.inst_career, c.category_name,
	AVG(course_evaluate_point) AS '강사 수강평점 평균'
FROM instructor i
JOIN user u ON i.user_id = u.user_id
JOIN category c ON i.category_id = c.category_id
JOIN course_evaluate cev ON i.inst_id = cev.inst_id
WHERE i.inst_id = 1
GROUP BY u.user_name, u.user_email, i.inst_img, i.inst_career, c.category_name

-- 강사가 진행중인 강좌
SELECT u.user_name, c.course_title, c.course_img,
    AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
    COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN user u ON c.user_id = u.user_id
JOIN instructor i ON u.user_id = i.user_id
LEFT JOIN course_evaluate cev ON c.course_id = cev.course_id
LEFT JOIN course_signup cs ON c.course_id = cs.course_id
WHERE c.course_end_date >= NOW()
    AND i.inst_id = 1
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name

-- 강사가 진행했던 강좌
SELECT u.user_name, c.course_title, c.course_img,
    AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
    COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN user u ON c.user_id = u.user_id
JOIN instructor i ON u.user_id = i.user_id
LEFT JOIN course_evaluate cev ON c.course_id = cev.course_id
LEFT JOIN course_signup cs ON c.course_id = cs.course_id
WHERE c.course_end_date < NOW()
    AND i.inst_id = 1
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name

-- 강사의 수강평 모음
-- 수강평이 없는 강사들도 조회될 수 있게 LEFT JOIN
SELECT i.inst_id, instructor.user_name, student.user_name, cev.course_evaluate_const, c.course_title, cev.course_evaluate_point
FROM instructor i
JOIN user instructor ON i.user_id = instructor.user_id 
LEFT JOIN course_evaluate cev ON i.inst_id = cev.inst_id
LEFT JOIN course c ON cev.course_id = c.course_id
JOIN user student ON cev.user_id = student.user_id
WHERE inst_id = 1


----------------------------------강좌 상세 페이지---------------------------------------

-- 공통
-- 강좌 기초 정보
SELECT c.course_title, c.course_img, u.user_name,
	AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
	COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
JOIN course_evaluate cev ON c.course_id = cev.course_id
JOIN course_signup cs ON c.course_id = cs.course_id
WHERE c.course_id = 1
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name

-- 강의(lecture) 목록
SELECT c.course_title, l.lecture_title, l.lecture_runtime
FROM course c
JOIN lecture l ON c.course_id = l.course_id
WHERE c.course_id = 1

-- 강좌 신청한 경우
-- 강의별 강의자료
SELECT l.lecture_title, l.lecture_const, l.lecture_runtime, lm.lecture_meta_title, lm.lecture_meta_const
FROM lecture l
JOIN lecture_meta lm ON l.lecture_id = lm.lecture_id
WHERE l.course_id = 1

-- 강의별 과제
SELECT l.lecture_title, l.lecture_const, la.lecture_assign_title, la.lecture_assign_const
FROM lecture l
LEFT JOIN lecture_assign la ON l.lecture_id = la.lecture_id
WHERE l.course_id = 1

-- 내 과제 제출 내역(T, F에 준하는 데이터)
SELECT u.user_name, l.lecture_title, la.lecture_assign_title, asm.assign_check
FROM lecture l
LEFT JOIN lecture_assign la ON l.lecture_id = la.lecture_id
LEFT JOIN assign_submit asm ON la.lecture_assign_id = asm.lecture_assign_id
JOIN user u ON asm.user_id2 = u.user_id
WHERE u.user_id = 1

-- 강의별 퀴즈
SELECT l.lecture_title, l.lecture_const, q.quiz_title, q.quiz_const
FROM lecture l
LEFT JOIN quiz q ON l.lecture_id = q.lecture_id

-- 참여 여부 / 점수
SELECT u.user_name, l.lecture_title, q.quiz_title, qs.quiz_check, qs.quiz_score
FROM lecture l
LEFT JOIN quiz q ON l.lecture_id = q.lecture_id
LEFT JOIN quiz_submit qs ON q.quiz_id = qs.quiz_id
JOIN user u ON qs.user_id = u.user_id
WHERE u.user_id = 1

-- 강좌별 qna 게시판
SELECT c.course_title, u.user_nickname, p.post_title, p.post_const, p.post_date
FROM course c
LEFT JOIN post p ON c.course_id = p.course_id
JOIN user u ON p.user_id = u.user_id
WHERE c.course_id = 1
ORDER BY p.post_date DESC

-- 게시글 + 댓글
SELECT DISTINCT c.course_title, 
    u.user_nickname, p.post_title, p.post_const, p.post_date, 
    cmus.user_nickname, cm.comment_const, cm.comment_date,
    cmcmus.user_nickname, cmcm.comment_const, cmcm.comment_date
FROM course c
LEFT JOIN post p ON c.course_id = p.course_id
LEFT JOIN user u ON p.user_id = u.user_id
LEFT JOIN comment cm ON p.post_id = cm.post_id
LEFT JOIN user cmus ON cm.user_id = cmus.user_id
LEFT JOIN comment cmcm ON cm.comment_id = cmcm.parent_id
LEFT JOIN user cmcmus ON cmcm.user_id = cmcmus.user_id


----------------------------------검색 페이지--------------------------------------
SELECT c.course_title, c.course_img, u.user_name,
    AVG(cev.course_evaluate_point) AS '수강평 평점평균'
FROM course c
LEFT JOIN instructor i ON c.inst_id = i.inst_id
LEFT JOIN user u ON i.user_id = u.user_id
LEFT JOIN category ca ON c.category_id = ca.category_id
LEFT JOIN course_evaluate cev ON c.course_id = cev.course_id
WHERE u.user_name LIKE '%수%' 
    OR c.course_title like '%입%'
    OR ca.category_name LIKE '%기%'
GROUP BY c.course_title, c.course_img, u.user_name;

----------------------------------마이 페이지---------------------------------------

-- 어떤 테이블을 기준으로 조인을 시작해야할지 아직 잘 감이 안오는 것 같다
-- 내가 신청한 강좌 목록
SELECT stu.user_name, inst.user_name ,c.course_title, c.course_start_date, c.course_end_date
FROM course_signup cs
LEFT JOIN user stu ON cs.user_id = stu.user_id
LEFT JOIN course c ON cs.course_id = c.course_id
JOIN user inst ON c.user_id = inst.user_id
WHERE stu.user_id = 1;

SELECT student.user_name, instructor.user_name, c.course_title, c.course_start_date, c.course_end_date
FROM user student
LEFT JOIN course_signup cs ON student.user_id = cs.user_id
LEFT JOIN course c ON cs.course_id = c.course_id
JOIN user instructor ON c.user_id = instructor.user_id
WHERE student.user_id = 1

-- 관심등록한 선생님
SELECT me.user_name, instructor.user_name AS '관심등록한 선생님', ibm.inst_create_date
FROM user me
LEFT JOIN inst_bookmk ibm ON me.user_id = ibm.user_id
LEFT JOIN user instructor ON ibm.user_id2 = instructor.user_id
WHERE me.user_id = 1

-- 내가 관심 등록한 강좌
SELECT DISTINCT us.user_name, c.course_title, inst.user_name, c.course_img
FROM course c
JOIN user inst ON c.user_id = inst.user_id
LEFT JOIN course_bookmk cbm ON c.course_id = cbm.course_id
LEFT JOIN user us ON cbm.user_id = us.user_id
WHERE us.user_id = 1

SELECT student.user_name, instructor.user_name, c.course_title, c.course_start_date, c.course_end_date
FROM user student
LEFT JOIN course_signup cs ON student.user_id = cs.user_id
LEFT JOIN course c ON cs.course_id = c.course_id
JOIN user instructor ON c.user_id = instructor.user_id
WHERE student.user_id = 1

-- 내 게시글 목록
SELECT us.user_name, post.post_title, post.post_const, post.post_date, post.post_type
FROM post
LEFT JOIN `user` us ON post.user_id = us.user_id
LEFT JOIN  course c ON post.course_id = c.course_id
WHERE us.user_id = 1

-- 내 댓글 목록
SELECT p.post_title, comm.comment_const, comm.comment_date
FROM comment comm
LEFT JOIN `user` us ON us.user_id = comm.user_id
LEFT JOIN post p ON comm.post_id = p.post_id
WHERE us.user_id = 1

----------------------------------게시판 & 댓글--------------------------------------

-- 게시판
SELECT p.post_title, p.post_const, p.post_date, u.user_nickname, c.course_title
FROM post p
LEFT JOIN user u ON p.user_id = u.user_id
LEFT JOIN course c ON p.course_id = c.course_id
WHERE p.post_type = '질문/답변 게시판'

-- 게시글 내 댓글
SELECT p.post_title, parcomm.comment_const, comm.comment_const
FROM comment parcomm
LEFT JOIN post p ON parcomm.post_id = p.post_id
LEFT JOIN comment comm ON parcomm.comment_id = comm.parent_id
WHERE p.post_id = 2;
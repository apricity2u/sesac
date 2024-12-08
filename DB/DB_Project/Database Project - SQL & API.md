- ERD 작성 시 테이블 및 컬럼명 잘 적기
- 화면 구성 및 렌더링할 항목들 생각해서 쿼리문 작성하기
- 참고자료를 많이 찾아보기
	- 참고한 사이트 : 이투스, 인프런

---
## `/`
## 1. 메인 페이지

#### 화면 구성

- 선생님 목록으로 이동 버튼을 누르면 선생님 모음 페이지로 이동
- 강좌 목록 이동 버튼을 누르면 강좌 모음 페이지로 이동
- 검색창에 선생님, 과목, 강좌 검색 가능
- 마이페이지 버튼을 누르면 마이페이지로 이동
- 선생님 목록과 강좌 목록 일부를 메인 페이지에서 랜더링
	- **선생님, 강좌 목록 페이지는 위 쿼리문에서 LIMIT만 제외하고 재활용하기**

![[Pasted image 20241205100535.png]]

---
###### 선생님 목록 일부

![[Pasted image 20241205101328.png]]

- **Info**
	- 선생님의 이름 / 이메일 / 강사 프로필 이미지 / 담당 과목
- **Table**
	- 유저 : `user`
	- 선생님 : `instructor`
	- 과목 : `category`

```sql
SELECT u.user_name, u.user_email, i.inst_img, c.category_name
FROM instructor i
JOIN user u ON i.user_id = u.user_id
JOIN category c ON i.category_id = c.category_id
ORDER BY c.category_name
LIMIT 5;
```

---
###### 강좌 목록 일부

![[Pasted image 20241205104040.png]]

- **Info**
	- 강좌 제목, 강좌 이미지, 선생님 이름,  강좌 평점 평균, 수강한 인원 수

- **Table**
	- 강좌 : `course`
	- 선생님 : `instructor`
	- 유저 : `user`
	- 수강평 : `course_evaluate`
	- 수강신청 : `course_signup`

```sql
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
```

---
## 2. 선생님 세부 페이지

#### 화면 구성

- 선생님 상세 정보 
- 선생님이 진행 중인 강좌 목록
- 선생님이 진행 했던 강좌 목록
- 수강평 모음

![[Pasted image 20241205134202.png]]

---
### `/instructor/:instructor_id`
###### 선생님 상세 정보

![[Pasted image 20241207231420.png]]

- **Info**
	- 선생님 이름, 이메일, 강사 프로필 이미지, 강사 이력, 담당 과목, 선생님 수강평점 평균

- **Table**
	- 유저 : `user`
	- 선생님 : `instructor`
	- 과목 : `category`
	- 수강평 : `course_evaluate`

```sql
SELECT u.user_name, u.user_email, i.inst_img, i.inst_career, c.category_name,
	AVG(course_evaluate_point) AS '강사 수강평점 평균'
FROM instructor i
JOIN user u ON i.user_id = u.user_id
JOIN category c ON i.category_id = c.category_id
LEFT JOIN course_evaluate cev ON i.inst_id = cev.inst_id
WHERE i.inst_id = 1
GROUP BY u.user_name, u.user_email, i.inst_img, i.inst_career, c.category_name
```

- **API**

| instructor        | 강사          |
| ----------------- | ----------- |
| insturctor_img    | 강사 / 프로필이미지 |
| insturctor_career | 강사 / 이력     |
| user              | 유저          |
| user_name         | 유저 / 이름     |
| category          | 과목          |
| category_name     | 과목 / 이름     |
```json
{
	"instructor_id" : 1,
	"user" : {
		"user_id" : 2,
		"user_name" : '박영희',
		"user_email" : 'younghee2@example.com',
	},
	"insturctor_img" : 'youngheeimg.png',
	"instructor_career" : '10년 경력의 자바 전문가'
	"category" : {
		"category_id" : 1,
		"category_name" : '자바'
	}
	
}
```

---
### `/instructor/:instructor_id/courses`
###### 진행 중인 강좌 / 진행 했던 강좌


![[Pasted image 20241205134730.png]]

- **Info**
	- 강좌 이름, 강좌 이미지, 강좌별 수강평점 평균, 강좌 총 수강인원

- **Table**
	- 강좌 : `course`
	- 선생님 : `instructor`
	- 유저 : `user`
	- 수강평 : `course_evaluate`
	- 수강신청 : `course_signup`

---
##### 진행 중인 강좌

```sql
SELECT c.course_title, c.course_img, u.user_name,
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
```

- **API**

| course_title            | 강좌명       |
| ----------------------- | --------- |
| course_img              | 강좌이미지     |
| instructor              | 강사        |
| user                    | 유저        |
| user_name               | 유저 / 이름   |
| course_evaluate_average | 수강평 평점 평균 |
| course_total_signup     | 강좌 총 수강인원 |
```json
[{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : null,
	"course_total_student" : 2
},{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : null,
	"course_total_student" : 2
}
]
```

---
##### 진행 했던 강좌

```sql
SELECT c.course_title, c.course_img, u.user_name,
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
```

- **API**

| course_title            | 강좌명       |
| ----------------------- | --------- |
| course_img              | 강좌이미지     |
| instructor              | 강사        |
| user                    | 유저        |
| user_name               | 유저 / 이름   |
| course_evaluate_average | 수강평 평점 평균 |
| course_total_signup     | 강좌 총 수강인원 |

```json
[{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : 5,
	"course_total_student" : 2
},{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : null,
	"course_total_student" : 2
}
]
```

---
### `/instructor/:instructor_id/reviews`
##### 수강평 모음

![[Pasted image 20241205134741.png]]
- **Info**
	- 강좌 이름, 강좌 이미지, 수강생 닉네임, 수강평 작성일자, 수강평 점수, 수강평 내용

- **Table**
	- 강좌: `course`
	- 유저(수강생 정보): `user`
	- 수강평 : `course_evaluate`

```sql
SELECT i.inst_id, instructor.user_name, student.user_name, 
	c.course_title, cev.course_evaluate_const, 
	cev.course_evaluate_point
FROM instructor i
JOIN user instructor ON i.user_id = instructor.user_id 
LEFT JOIN course_evaluate cev ON i.inst_id = cev.inst_id
LEFT JOIN course c ON cev.course_id = c.course_id
JOIN user student ON cev.user_id = student.user_id
WHERE i.inst_id = 1
```

- **API**

| course_title          | 강좌명      |
| --------------------- | -------- |
| instructor            | 강사       |
| user                  | 저        |
| user_name             | 유저 / 이름  |
| course_evaluate       | 수강평      |
| course_evaluate_const | 수강평 / 내용 |
| course_evaluate_point | 수강평 / 점수 |

```json
{
	"instructor_id" : 1,
	"user" : {
		"user_id" : 2,
		"user_name" : '박영희'
	},
	"course_evaluate" : [{
		"user_id" : 1,
		"user_name" : '김철수',
		"course_title" : '자바 입문',
		"course_evaluate_const" : '기초부터 자세히 설명해줘서 많은 도움이 되었습니다.',
		"course_evaluate_point" : 5
	},{
		"user_id" : 1,
		"user_name" : '김철수',
		"course_title" : '자바 입문',
		"course_evaluate_const" : '기초부터 자세히 설명해줘서 많은 도움이 되었습니다.',
		"course_evaluate_point" : 5
	}]
}
```

---
## 3. 강좌 세부 페이지

#### 화면 구성
-  공통
	- 강좌 기초 정보 (+수강평 평점평균) / 강의 목록
- 강좌 신청한 경우
	- 강의자료 / 과제 / 퀴즈 / Q&A 게시판
		- 과제 제출 내역
		- 퀴즈 참여 여부 / 점수
		- 게시판 내 게시글 / 댓글

---
### `/course/:course_title`
##### 강좌 기초 정보

![[Pasted image 20241205172418.png]]

- **Info**
	- 강좌 제목, 강좌 소개, 강좌 이미지, 수강 평점 평균, 총 수강인원, 선생님 이름, 과목 이름
	- **강좌 테이블에 강좌 소개도 컬럼으로 있으면 좋을 것 같다**

- **Table**
	- 강좌 : `course`
	- 선생님 : `instructor`
	- 유저 : `user`
	- 수강평 : `course_evaluate`
	- 수강신청 : `course_signup`

```sql
SELECT c.course_title, c.course_img, u.user_name,
	AVG(cev.course_evaluate_point) AS '수강평 평점 평균',
	COUNT(DISTINCT cs.course_signup_id) AS '강좌 총 수강인원'
FROM course c
JOIN instructor i ON c.inst_id = i.inst_id
JOIN user u ON i.user_id = u.user_id
LEFT JOIN course_evaluate cev ON c.course_id = cev.course_id
LEFT JOIN course_signup cs ON c.course_id = cs.course_id
GROUP BY c.course_id, c.course_title, c.course_img, u.user_name
```

- **API**

| course_title            | 강좌명       |
| ----------------------- | --------- |
| course_img              | 강좌이미지     |
| instructor              | 강사        |
| user                    | 유저        |
| user_name               | 유저 / 이름   |
| course_evaluate_average | 수강평 평점 평균 |
| course_total_signup     | 강좌 총 수강인원 |

```json
{
	"course_title" : "자바 입문",
	"course_img" : NULL,
	"instructor" : {
		"inst_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_average" : 5,
	"course_total_signup" : 2 
}
```


---
### `/course/:course_title/lectures`
##### 강의 목록

![[Pasted image 20241205172315.png]]

- **Info**
	- 강좌 이름, 강의 제목, 강의 시간

- **Table**
	- 강좌 : `course`
	- 강의 : `lecture`

```sql
SELECT c.course_title, l.lecture_title, l.lecture_runtime
FROM course c
JOIN lecture l ON c.course_id = l.course_id
WHERE c.course_id = 1
```

- **API**

| course_title    | 강좌명       |
| --------------- | --------- |
| lecture         | 강의        |
| lecture_title   | 강의 / 강의명  |
| lecture_runtime | 강의 / 강의시간 |

```json
{
	"course_id" : 1
	"course_title" : "자바 입문"
	"lecture" : [{
		"lecture_id" : 1,
		"lecture_title" : "강의 제목 1"
		"lecture_runtime" : "01:30:00"
	},{
		"lecture_id" : 2,
		"lecture_title" : "강의 제목 2"
		"lecture_runtime" : "00:45:00"
	}
	]
}
```
---
### `/course/:course_title/:lecture_id/lecture_metas`
##### 강의 자료

- **Info**
	- 강의 제목, 강의 내용, 강의 시간, 강의자료 제목, 강의자료 내용

- **Table**
	- 강의 : `lecture`
	- 강의자료 : `lecture_meta`
	- 강좌 : `course`

```sql
SELECT l.lecture_title, l.lecture_const, l.lecture_runtime, lm.lecture_meta_title, lm.lecture_meta_const
FROM lecture l
JOIN lecture_meta lm ON l.lecture_id = lm.lecture_id
WHERE l.course_id = 1
```

- **API**

| lecture_title      | 강의명       |
| ------------------ | --------- |
| lecture_const      | 강의 / 내용   |
| lecture_runtime    | 강의 / 러닝타임 |
| lecture_meta       | 강의자료      |
| lecture_meta_title | 강의자료 / 제목 |
| lecture_meta_const | 강의자료 / 설명 |

```json
{
	"lecture_id" : 1,
	"lecture_title" : "강의 제목 1",
	"lecture_const" : "강의 설명 1",
	"lecture_runtime" : "01:30:00",
	"lecture_meta" : [{
		"lecture_meta_id" : 1,
		"lecture_meta_title" : "메타 제목 1",
		"lecture_meta_const" : "메타 설명 1"
	}, {
		"lecture_meta_id" = 2
		"lecture_meta_title" : "메타 제목 2",
		"lecture_meta_const" : "메타 설명 2"
	}]
}
```

---
### `/course/:course_title/:lecture_title/assignment`
##### 강의별 과제

- **Info**
	- 강의 제목, 강의 내용, 과제 제목, 과제 내용

- **Table**
	- 강의 : `lecture`
	- 과제 : `lecture_assign`

```sql
SELECT l.lecture_title, l.lecture_const, la.lecture_assign_title, la.lecture_assign_const
FROM lecture l
LEFT JOIN lecture_assign la ON l.lecture_id = la.lecture_id
WHERE l.course_id = 1
```

- **API**

| lecture_title        | 강의명     |
| -------------------- | ------- |
| lecture_const        | 강의 / 내용 |
| lecture_assign_title | 과제 / 제목 |
| lecture_assign_const | 과제 / 내용 |
```json
{
	"lecture_id" : 1,
	"lecture_title" : "강의 제목 1"
	"lecture_const" : "강의 내용 1"
	"lecture_assign" : [{
		"lecture_assign_id" : 1,
		"lecture_assign_title" : "과제 제목 1",
		"lecture_assign_const" : "과제 내용 1"
	},{
		"lecture_assign_id" : 2,
		"lecture_assign_title" : "과제 제목 2",
		"lecture_assign_const" : "과제 내용 2"
	}]
}
```

---
## `/course/:course_title/:lecture_title/:assignment_id/:user_id`
##### 과제 제출내역

- **Info**
	- 강의 제목, 과제 제목, 수강생 이름, 과제 제출여부

- **Table**
	- 강의 : `lecture`
	- 과제 : `lecture_assign`
	- 과제제출 : `assign_submit`
	- 유저(수강생) : `user`

```sql
SELECT u.user_name, l.lecture_title, 
	la.lecture_assign_title, asm.assign_check
FROM lecture l
LEFT JOIN lecture_assign la ON l.lecture_id = la.lecture_id
LEFT JOIN assign_submit asm ON la.lecture_assign_id = asm.lecture_assign_id
JOIN user u ON asm.user_id2 = u.user_id
WHERE u.user_id = 1
```

- **API**

| user_name            | 이름               |
| -------------------- | ---------------- |
| assign_submit        | 과제 제출            |
| lecture              | 강의               |
| lecture_title        | 강의/제목            |
| lecture_assign       | 과제               |
| lecture_assign_title | 과제 / 제목          |
| assign_submit_check  | 과제제출 / 내역( T/F ) |

**내가 나의 과제 제출 내역을 확인할 때**
```json
{
	"user_id" : 1,
	"user_name" : '김철수',
	"assign_submit" : {
		"lecture_id" : 1,
		"lecture_title" : '강의 제목 1',
		"lecture_assign" : [{
			"lecture_assign_id" : 1,
			"lecture_assign_title" : '과제 제목 1',
			"assign_submit_check" : true
		},{
			"lecture_assign_id" : 2,
			"lecture_assign_title" : '과제 제목 2',
			"assign_submit_check" : false
		}]
	}
}
```

**선생님이 강의별 학생들의 과제 제출 내역을 확인할 때**
```json
{
	"lecture_id" : 1,
	"lecture_title" : "강의 제목 1"
	"lecture_assign" : [{
		"lecture_assign_id" : 1,
		"lecture_assign_title" : "과제 제목 1",
		"user" : [{
			"user_id" : 1,
			"user_name" : '김철수',
			"assign_submit" : true
		},{
			"user_id" : 3,
			"user_name" : '김민수',
			"assign_submit" : false
		}]
	},{
		"lecture_assign_id" : 2,
		"lecture_assign_title" : "과제 제목 2",
		"user" : [...]
	}]
}
```


---
## `/course/:course_title/:lecture_title/:quiz
##### 강의별 퀴즈

- **Info**
	- 강의 제목, 강의 내용, 퀴즈 제목, 퀴즈 내용

- **Table**
	- 강의 : `lecture`
	- 퀴즈 : `quiz`

```sql
SELECT l.lecture_title, l.lecture_const, q.quiz_title, q.quiz_const
FROM lecture l
LEFT JOIN quiz q ON l.lecture_id = q.lecture_id
```

- **API**

| lecture       | 강의      |
| ------------- | ------- |
| lecture_title | 강의 / 제목 |
| lecture_const | 강의 / 내용 |
| quiz          | 퀴즈      |
| quiz_title    | 퀴즈 / 제목 |
| quiz_const    | 퀴즈 / 내용 |

```json
{
	"lecture_id" : 1,
	"lecture_title" : "강의 제목 1"
	"lecture_const" : "강의 내용 1"
	"quiz" : [{
		"quiz_id" : 1,
		"quiz_title" : "퀴즈 제목 1",
		"quiz_const" : "퀴즈 내용 1"
	},{
		"quiz_id" : 2,
		"quiz_title" : "퀴즈 제목 2",
		"quiz_const" : "퀴즈 내용 2"
	}]
}
```
---
## `/course/:course_title/:lecture_title/:quiz_id/:user_id`
##### 퀴즈 참여 여부 / 점수

- **Info**
	- 수강생 이름, 강의명, 퀴즈 제목, 퀴즈 참여 여부, 점수

- **Table**
	- 강의 : `lecture`
	- 퀴즈 : `quiz`
	- 퀴즈제출 : `quiz_submit`
	- 유저(수강생) : `user`

```sql
SELECT u.user_name, l.lecture_title, q.quiz_title, qs.quiz_check, qs.quiz_score
FROM lecture l
LEFT JOIN quiz q ON l.lecture_id = q.lecture_id
LEFT JOIN quiz_submit qs ON q.quiz_id = qs.quiz_id
JOIN user u ON qs.user_id = u.user_id
WHERE u.user_id = 1
```

- **API**

| user_name         | 이름                |
| ----------------- | ----------------- |
| quiz_submit       | 퀴즈 제출             |
| lecture           | 강의                |
| lecture_title     | 강의/제목             |
| quiz              | 퀴즈                |
| quiz_title        | 퀴즈 / 제목           |
| quiz_submit_check | 퀴즈 제출 / 내역( T/F ) |
| quiz_submit_score | 퀴즈 점수             |

```json
{
	"user_id" : 1,
	"user_name" : '김철수',
	"quiz_submit" : {
		"lecture_id" : 1,
		"lecture_title" : '강의 제목 1',
		"lecture_assign" : [{
			"quiz_id" : 1,
			"quiz_title" : '과제 제목 1',
			"quiz_submit_check" : true,
			"quiz_submit_score" : 90
		},{
			"quiz_id" : 2,
			"quiz_title" : '과제 제목 2',
			"quiz_submit_check" : false,
			"quiz_submit_score" : null
		}]
	}
}
```
---
## `/course/:course_title/QNA`
##### 강좌 내 Q&A 게시판

![[Pasted image 20241206082306.png]]

- **Info**
	- 강의 제목, 유저 닉네임, 게시글 제목, 게시글 내용, 

- **Table**
	- 강의 : `lecture`
	- 퀴즈 : `quiz`

```sql
SELECT c.course_title, u.user_nickname, p.post_title, p.post_const, p.post_date
FROM course c
LEFT JOIN post p ON c.course_id = p.course_id
JOIN user u ON p.user_id = u.user_id
ORDER BY p.post_date DESC
```

- **API**

| course        | 강좌       |
| ------------- | -------- |
| course_title  | 강좌 / 이름  |
| user          | 유저       |
| user_nickname | 유저 / 닉네임 |
| post          | 게시글      |
| post_title    | 게시글 / 제목 |
| post_const    | 게시글 / 내용 |
| post_date     | 게시글 / 날짜 |

```json
{
	"course_id" : 1,
	"course_title" : '자바 입문',
	"posts" : [{
		"post_id" : 1,
		"post_title" : '자바 클래스 설계',
		"post_const" : '클래스를 설계할 때 고려해야 할 점은 무엇인가요?',
		"post_date" : '2024-01-20 16:10:00'
		"user" : {
			'user_id' : 1,
			'user_nickname' : '철수'
		},{
		"post_id" : 2,
		"post_title" : '자바 질문',
		"post_const" : '자바 변수 선언 관련 질문입니다.',
		"post_date" : '2024-01-01 10:00:00'
		"user" : {
			'user_id' : 1,
			'user_nickname' : '철수'
		}
	}]
}
```
---
## `/course/:course_title/QNA/:post_id`
##### 게시글 내 댓글

![[Pasted image 20241206082245.png]]

```sql
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
```

- **API**

| course        | 강좌       |
| ------------- | -------- |
| course_title  | 강좌 / 이름  |
| user          | 유저       |
| user_nickname | 유저 / 닉네임 |
| post          | 게시글      |
| post_title    | 게시글 / 제목 |
| post_const    | 게시글 / 내용 |
| post_date     | 게시글 / 날짜 |
| comment       | 댓글       |
| comment_const | 댓글 / 내용  |
| comment_date  | 댓글 / 날짜  |

```json
{
	"course_id" : 1,
	"course_title" : '자바 입문',
	"posts" : {
		"post_id" : 1,
		"post_title" : '자바 클래스 설계',
		"post_const" : '클래스를 설계할 때 고려해야 할 점은 무엇인가요?',
		"post_date" : '2024-01-20 16:10:00'
		"user" : {
			"user_id" : 1,
			"user_nickname" : '철수'
		},
		"comment" : {
			"comment_id" : 1,
			"user" : {
				"user_id" : 2,
				"user_nickname" : '영희쌤'
			},
			"comment_const" : '자바 클래스와 객체의 차이는 많이 중요하죠. 클래스는 청사진이고 객체는 실체입니다.'			
		}
	}
}
```

---
## 4. 검색 페이지
## `/search?query={input}`

- 선생님, 강좌,  과목을 검색했을 때, 연관있는 강좌를 조회할 수 있다.

![[Pasted image 20241206081024.png]]

```sql
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
```

- **API**

| course_title            | 강좌명       |
| ----------------------- | --------- |
| course_img              | 강좌이미지     |
| instructor              | 강사        |
| user                    | 유저        |
| user_name               | 유저 / 이름   |
| course_evaluate_average | 수강평 평점 평균 |
```json
[{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : null,
},{
	"course_title" : "자바 입문",
	"course_img" : null,
	"instructor" : {
		"instructor_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_name" : "박영희"
		}
	},
	"course_evaluate_avg" : null,
}
]
```

---
## 5. 마이페이지

## `/mypage`
### 화면 구성 

- 내가 신청한 강좌 목록 
- 내가 관심 등록한 선생님
- 내가 관심 등록한 강좌 
- 내 게시글 목록
- 내 댓글 목록

- 전체 일부 랜더링
---
## `/mypages/signup`
###### 내가 신청한 강좌 목록

- 필요한 정보
	- 강좌 제목, 강좌 이미지, 선생님 이름,  강좌 평점 평균, 강좌 기간?

- 필요한 테이블
	- 유저 : 'user'
	- 강사 : 'instructor'
	- 과목 : 'category'
	- 강좌 : 'course'
	- 수강 신청 : 'course_signup'

``` sql
SELECT stu.user_name, inst.user_name ,c.course_title, c.course_start_date, c.course_end_date
FROM course_signup cs
LEFT JOIN user stu ON cs.user_id = stu.user_id
LEFT JOIN course c ON cs.course_id = c.course_id
LEFT JOIN instructor i ON c.inst_id = i.inst_id
LEFT join user inst ON i.user_id = inst.user_id
WHERE stu.user_id = 1
```

- **API**

| user              | 유저       |
| ----------------- | -------- |
| user_name         | 유저 / 이름  |
| course            | 강좌       |
| course_title      | 강좌 / 이름  |
| course_start_date | 강좌 / 개강일 |
| course_end_date   | 강좌 / 종강일 |
| instructor        | 선생님      |
```json
{
	"user_id" : 1,
	"user_name" : '김철수'
	"course_sign_up" : [{
		"course_id" : 1,
		"course_title" : '자바 입문',
		"instructor" : {
			"instructor_id" : 1,
			"user" : {
				"user_id" : 2,
				"user_name" : '박영희'
			}
		}
		"course_start_date" : '2024-01-01',
		"course_end_date" : '2024-01-31'
	},{
		"course_id" : 3,
		"course_title" : '파이썬 심화',
		"instructor" : {
			"instructor_id" : 2,
			"user" : {
				"user_id" : 4,
				"user_name" : '홍길동'
			}
		}
		"course_start_date" : '2024-02-01',
		"course_end_date" : '2024-03-31'
	}]
}
```

---
## `/mypages/instructors`
###### 내가 관심 등록한 선생님

- 필요한 정보
	- 선생님 이름, 선생님 이미지

- 필요한 테이블
	- 유저 : 'user'
	- 강사 : 'instructor'
	- 강사 북마크 : 'inst_bookmk'

```sql
SELECT us.user_name, inst.inst_img
FROM inst_bookmk inb
LEFT JOIN instructor inst ON inb.user_id2 = inst.user_id
LEFT JOIN `user` us ON inst.user_id = us.user_id
```

- **API**

| user               | 유저             |
| ------------------ | -------------- |
| user_name          | 유저 / 이름        |
| instructor         | 선생님            |
| inst_bookmark_date | 선생님 / 관심등록한 시간 |

```json
{
	"user_id" : 1,
	"user_name" : '김철수'
	"instructor" : [{
		"instructor" : {
			"instructor_id" : 1,
			"user" : {
				"user_id" : 2,
				"user_name" : '박영희'
			},
			"inst_bookmark_date" : '2024-12-05 10:47:41'
		}
	},{
		"instructor" : {
			"instructor_id" : 2,
			"user" : {
				"user_id" : 4,
				"user_name" : '홍길동'
			},
			"inst_bookmark_date" : '2024-12-05 10:47:41'
		}
	}]
}
```
---
## `/mypages/courses`
###### 내가 관심 등록한 강좌
- 필요한 정보
	- 유저 이름, 강좌 제목, 강좌 이미지, 선생님 이름,  강좌 평점 평균, 강좌 평점, 강좌 기간

- 필요한 테이블
	- 유저 : 'user'
	- 강좌 : 'course'
	- 강좌 북마크 : 'course_bookmk'
	- 강좌 수강평 : 'course_evaluate'
	- 강사 : 'instructor'

``` sql
SELECT DISTINCT us.user_name,cour.course_title,inst.user_name , cour.course_img, ce.course_evaluate_point
FROM course cour
LEFT JOIN course_bookmk cobo ON cour.course_id = cobo.course_id
LEFT JOIN user us ON cobo.user_id = us.user_id
LEFT JOIN course_evaluate ce ON cour.course_id = ce.course_id
LEFT JOIN instructor i ON cour.inst_id = i.inst_id
LEFT JOIN user inst ON i.user_id = inst.user_id
WHERE us.user_id = 1
```

- **API**

| user                 | 유저            |
| -------------------- | ------------- |
| user_name            | 유저 / 이름       |
| course               | 강좌            |
| course_title         | 강좌 / 이름       |
| course_bookmark_date | 강좌 / 관심등록한 시간 |
| instructor           | 선생님           |
```json
{
	"user_id" : 1,
	"user_name" : '김철수'
	"course" : [{
		"course_id" : 1,
		"course_title" : '자바 입문',
		"instructor" : {
			"instructor_id" : 1,
			"user" : {
				"user_id" : 2,
				"user_name" : '박영희'
			}
		}
		"course_bookmark_date" : '2024-01-01'
	},{
		"course_id" : 3,
		"course_title" : '파이썬 심화',
		"instructor" : {
			"instructor_id" : 2,
			"user" : {
				"user_id" : 4,
				"user_name" : '홍길동'
			}
		}
		"course_bookmark_date" : '2024-02-01'
	}]
}
```
---
## `/mypages/posts`
###### 내 게시글 목록
- 필요한 정보
	- 게시글 타입, 게시글 제목, 게시글 내용, 작성 시간

- 필요한 테이블
	- 유저 : 'user'
	- 강좌 : 'course'
	- 게시글 : 'post'

``` sql
SELECT us.user_name, post.post_title, post.post_const, post.post_date, post.post_type
FROM post
LEFT JOIN `user` us ON post.user_id = us.user_id
LEFT JOIN  course cour ON post.course_id = cour.course_id;
```

- **API**

| user          | 유저                       |
| ------------- | ------------------------ |
| user_nickname | 유저 / 닉네임                 |
| post          | 게시글                      |
| post_title    | 게시글 / 제목                 |
| post_const    | 게시글 / 내용                 |
| post_date     | 게시글 / 날짜                 |
| post_type     | 게시글 / 게시글유형(질문 or 스터디모집) |

```json
{
	"user_id" : 1,
	"user_nickname" : '철수',
	"posts" [{
		"post_id" : 1,
		"post_title" : '자바 질문',
		"post_content" : '자바 변수 선언 관련 질문입니다.'
		"post_date" : '2024-01-01 10:00:00'
		"post_type" : '질문/답변 게시판'
	},{
		"post_id" : 2,
		"post_title" : '데이터베이스 기초',
		"post_content" : 'SQL에서 JOIN의 종류와 차이를 알고 싶습니다.'
		"post_date" : '2024-01-06 10:30:00'
		"post_type" : '질문/답변 게시판'
	}]
}
```
---
## `/mypages/comments`
###### 내 댓글 목록
- 필요한 정보
	- 댓글 내용, 작성 시간, 

- 필요한 테이블
	- 유저 : 'user'
	- 댓글 : 'comment'
	- 댓글 원 게시글 : 'post'

```sql
SELECT comm.comment_const, comm.comment_date
FROM comment comm
LEFT JOIN `user` us ON us.user_id = comm.user_id
LEFT JOIN post ON comm.post_id = post.post_id;
```

- **API**

| user          | 유저       |
| ------------- | -------- |
| user_nickname | 유저 / 닉네임 |
| post          | 게시글      |
| post_title    | 게시글 / 제목 |
| comment       | 댓글       |
| comment_const | 댓글 / 내용  |
| comment_date  | 댓글 / 날짜  |

```json
{
	"user_id" : 3,
	"user_name" : '민수',
	"comment" : [{
		"comment_id" : 2,
		"comment_const" : '좋은 설명 감사합니다.'
		"post" : {
			"post_id" : 2,
			"post_title" : '자바 질문'
		}
	},{
		"comment_id" : 2,
		"comment_const" : '좋은 설명 감사합니다.'
		"post" : {
			"post_id" : 2,
			"post_title" : '자바 질문'
		}
	}]
}
```

---

## 6. 게시판 & 댓글

## `/board`

##### 게시판

![[Pasted image 20241206081134.png]]

- **Info**
	- 게시글 제목, 내용, 작성일자, 작성자 닉네임, 강좌명

- **Table**
	- 게시글 : `post`
	- 유저(게시글 작성자) : `user`
	- 강좌 : `course`

```sql
SELECT p.post_title, p.post_const, p.post_date, u.user_nickname, c.course_title
FROM post p
LEFT JOIN user u ON p.user_id = u.user_id
LEFT JOIN course c ON p.course_id = c.course_id
WHERE p.post_type = '질문/답변 게시판'
```

- **API**

| course        | 강좌       |
| ------------- | -------- |
| course_title  | 강좌 / 이름  |
| user          | 유저       |
| user_nickname | 유저 / 닉네임 |
| post          | 게시글      |
| post_title    | 게시글 / 제목 |
| post_const    | 게시글 / 내용 |
| post_date     | 게시글 / 날짜 |

```json
{
	"질문/답변 게시판" : [{
		"post_id" : 1,
		"post_title" : '자바 질문',
		"post_const" : '자바 변수 선언 관련 질문입니다.'
		"post_date" : '2024-01-01 10:00:00'
		"user" : {
			"user_id" : 1,
			"user_nickname" : '철수'
		}
		"course" : {
			"course_id" : 1,
			"course_title" : '자바 입문'
		}
	}],
	"스터디모집 게시판" : [{
		"post_id" : 1,
		"post_title" : '자바 질문',
		"post_const" : '자바 변수 선언 관련 질문입니다.'
		"post_date" : '2024-01-01 10:00:00'
		"user" : {
			"user_id" : 1,
			"user_nickname" : '철수'
		}
		"course" : {
			"course_id" : 1,
			"course_title" : '자바 입문'
		}
	}]
}
```
---
## `/:post_id`
##### 댓글

![[Pasted image 20241206081221.png]]

- **Info**
	- 댓글 , 내용, 작성일자, 작성자 닉네임, 강좌명

- **Table**
	- 게시글 : `post`
	- 댓글 : `comment` - `parcomm`
	- 대댓글 : `comment` - `comm`


```sql
SELECT p.post_title, parcomm.comment_const, comm.comment_const
FROM comment parcomm
LEFT JOIN post p ON parcomm.post_id = p.post_id
LEFT JOIN comment comm ON parcomm.comment_id = comm.parent_id
WHERE p.post_id = 2;
```

- **API**

| user          | 유저       |
| ------------- | -------- |
| user_nickname | 유저 / 닉네임 |
| post          | 게시글      |
| post_title    | 게시글 / 제목 |
| post_const    | 게시글 / 내용 |
| post_date     | 게시글 / 날짜 |
| comment       | 댓글       |
| comment_const | 댓글 / 내용  |
| comment_date  | 댓글 / 날짜  |

```json
{
	"post_id" : 1,
	"post_title" : '자바 클래스 설계',
	"post_const" : '클래스를 설계할 때 고려해야 할 점은 무엇인가요?',
	"post_date" : '2024-01-20 16:10:00'
	"user" : {
		"user_id" : 1,
		"user_nickname" : '철수'
	},
	"comment" : {
		"comment_id" : 1,
		"user" : {
			"user_id" : 2,
			"user_nickname" : '영희쌤'
		},
		"comment_const" : '자바 클래스와 객체의 차이는 많이 중요하죠. 클래스는 청사진이고 객체는 실체입니다.'
		"comment" : {
			"comment_id" : 2,
			"user" : {
				"user_id" : 3,
				"user_nickname" : '민수'
			},
			"comment_const" : '좋은 설명 감사합니다.'
		}		
	}
}
```
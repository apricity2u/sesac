const posts = [
  { id: 1, title: "첫 번째 포스트", content: "첫 번째 포스트 내용" },
  { id: 2, title: "두 번째 포스트", content: "두 번째 포스트 내용" },
  { id: 3, title: "세 번째 포스트", content: "세 번째 포스트 내용" },
];

const comments = [
  { id: 1, postId: 1, content: "첫 번째 댓글" },
  { id: 2, postId: 2, content: "두 번째 댓글" },
  { id: 3, postId: 1, content: "세 번째 댓글" },
  { id: 4, postId: 2, content: "네 번째 댓글" },
  { id: 5, postId: 3, content: "다섯 번째 댓글" },
  { id: 6, postId: 2, content: "여섯 번째 댓글" },
  { id: 7, postId: 3, content: "일곱 번째 댓글" },
  { id: 8, postId: 3, content: "여덟 번째 댓글" },
  { id: 9, postId: 1, content: "아홉 번째 댓글" },
  { id: 10, postId: 3, content: "열 번째 댓글" },
];

// 1. 모든 posts 의 번호 id, 제목 title을 출력한다.

posts.forEach((post) => {
  console.log(post.id, post.title);
});

console.log();
// 2. 게시글 번호 postId 가 1인 모든 comments 를 출력한다.

comments.forEach((comment) => {
  if (comment.postId === 1) console.log(comment);
});

console.log();
// 3. 개별 posts 에 연관된 comments를 구분해서 출력한다.

for (let i = 0; i < posts.length; i++) {
  const post = posts[i];
  console.log(`${i + 1}번 Post`);
  console.log(post);

  console.log(`${i + 1}번 Post의 Comments`);
  for (let comment of comments) {
    if (comment.postId === i + 1) {
      console.log(comment);
    }
  }
}

// posts.forEach((post) => {
//   const postId = post.id;
//   console.log(`${post.id}번 Post`);
//   console.log(post);

//   console.log(`${post.id}번 Post의 Comments`);
//   comments.forEach((comment) => {
//     if (comment.postId === postId) {
//       console.log(comment);
//     }
//   });
// });

console.log();
// 4. 개별 posts 당 연관된 comments 의 수를 출력한다.

for (let i = 0; i < posts.length; i++) {
  cnt = 0;

  for (let comment of comments) {
    if (comment.postId === i + 1) {
      cnt++;
    }
  }
  console.log(`${i + 1}번 게시글의 댓글 수 ${cnt}`);
}

// posts.forEach((post) => {
//   const postId = post.id;

//   let comment_count = 0;

//   comments.forEach((comment) => {
//     if (comment.postId === postId) {
//       comment_count = comment_count + 1;
//     }
//   });

//   console.log(`${postId}번 게시글의 댓글 수 ${comment_count}`);
// });

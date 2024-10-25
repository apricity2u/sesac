// delete
// Q. 무엇을 하고 싶은가?
// A. 서버의 리소스를 삭제한다

// 무엇이 필요해?
// 1. URL
// 2. posts (path params)
// 3. {id} : 삭제하고 싶은 게시글 번호
// 4. method : 'delete'

async function deletePost() {
  const response = await fetch('https://jsonplaceholder.typicode.com/posts/1', {
    method: 'DELETE',
  });
  const text = await response.text();
  console.log(text); // 출력 안됨 왜? 삭제 됐으니까
}

deletePost();

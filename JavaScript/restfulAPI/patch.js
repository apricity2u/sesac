// patch
// Q. 무엇을 하고 싶은가?
// A. 서버의 리소스를 부분적으로 수정하고 싶다

// 무엇이 필요해?
// 1. URL
// 2. posts (path params)
// 3. {id} // 수정하고 싶은 게시글 번호
// 4. method : patch
// 5. body : 내가 수정하고 싶은 내용 일부

fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'PATCH',
  body: JSON.stringify({
    title: 'foo',
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => response.json())
  .then((json) => console.log(json))
  .catch((error) => console.error(error));

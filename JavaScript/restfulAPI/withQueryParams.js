// URL과 quary params를 분리해서 관리하는 것!

const baseURL = 'https://jsonplaceholder.typicode.com/posts';
const params = new URLSearchParams({
  userId: 1, // key : value 형태로 입력
});

const URL = `${baseURL}?${params}`;
// 아래 URL과 동일하다.
// userId 1번의 게시글만 보고 싶다!
// https://jsonplaceholder.typicode.com/posts?userId=1

fetch(URL)
  .then((response) => response.json())
  .then((json) => console.log(json))
  .catch((error) => console.error(error))

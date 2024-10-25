// put
// Q. 무엇을 하고 싶은지?
// A. 서버의 리소스를 수정하고 싶다!

// 무엇이 필요한가?
// 1. URL
// 2. posts (path params)
// 3. {id} // 수정하고 싶은 id
// 4. method : 'put'
// 5. body : '수정할 데이터'

async function updatePost() {
  try {
    const response = await fetch(
      'https://jsonplaceholder.typicode.com/posts/1',
      {
        method: 'PUT',
        body: JSON.stringify({
          id: 1,
          title: 'foo',
          body: 'bar',
          userId: 1,
        }),
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        },
      }
    );
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

updatePost();

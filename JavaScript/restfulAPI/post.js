// Post
// Q. 내가 하고 싶은 것은?
// A. 데이터를 전송해서 새로운 리소스를 생성합니다.

// 그렇다면 필요한 것은?
// 1. URL
// 2. posts (path params)
// 3. method : 'POST'
// 4. body : 수정할 내용

// posts/create 형식으로 사용하면 안되는 이유는?
// create 는 '만든다'는 행위에 대한 내용
// url 은 데이터를 식별할 수 있으면 됨 
// 행위에 대한 내용은 필요없는 정보이며 이 정보가 들어가면 RESTful API 가 아님
// method : 'post' 에서 행위를 실행할 것.

async function createPost() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
      method: 'POST',
      body: JSON.stringify({ // string 형태로 변환 {"", "", ""}
                              // json 형태로 데이터를 전달하자
        title: 'foo',
        body: 'bar',
        userId: 1,
      }),
      headers: { 
        'Content-type': 'application/json; charset=UTF-8',
        // 이 값이 없으면 이 자료가 json 형태인지를 인지하지 못함
        // 데이터를 위한 데이터인 메타데이터
      },
    });

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

createPost();
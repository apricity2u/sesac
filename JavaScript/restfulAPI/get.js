// get

// Q. 무엇을 하고 싶은가?
// A. 나는 데이터를 가져오고 싶어. 

// 그럼 뭐가 필요하지?
// 1. URL
// 2. posts (path params)
// 3. {id} : ex. 몇 번째 게시글인지


fetch("https://jsonplaceholder.typicode.com/posts/1")
  .then((response) => response.json())
  .then((json) => {
    // console.log(json)) // 게시글 1번 데이터를 출력합니다.
    const title = json.title; 
    console.log(title); // 게시글 1번 데이터의 title을 출력합니다.
  })
  .catch((error) => console.error(error));


// async 과 await를 사용하는 버전
// 조회 시에 id 값이 중요하니까 텍스트 탬플릿으로 내가 원하는 게시글을 가져올 수 있다. 
async function getPost(postId) {
  const response = await fetch(
    `https://jsonplaceholder.typicode.com/posts/${postId}`
  );
  const data = await response.json();
  console.log(data);
}

getPost(3); // 3번째 게시글을 조회합니다.



// id 없이 post 전체에서 접근하는 방법
async function getPostById() {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts`);
  const data = await response.json();

  // data는 배열이라는 object로 되어있고, forEach로 각 원소를 꺼냅니다. (value)
  // value는 object 형태이기 때문에 value.title 를 출력하면 title만 출력됩니다.
  data.forEach((value) => {
    console.log(value.title);
  });

  // title을 모아놓은 새로운 배열을 출력하고 싶다면?
  // map 함수를 사용해서 각 원소(객체)의 title만 뽑아 titles라는 새로운 배열에 할당합니다.
  const titles = data.map((value) => value.title);
  console.log(titles);
}

getPostById();
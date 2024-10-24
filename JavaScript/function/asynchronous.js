async function fetchUrl(url) {
  try {
    const response = await fetch(url);
    const data = await response.json();

    console.log(data);
  } catch (error) {
    // 비동기 처리 중 오류 발생 시 실행
    console.error("오류 발생");
    console.error(error.name); // TypeError 과 같은 형태
    console.error(error.message); // fetch failed 과 같은 형태 
  }
}
const url = "https://jsonplaceholder.typicode.com/todos/1";

fetchUrl(url);

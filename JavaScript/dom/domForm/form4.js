const form = document.querySelector("form");
form.addEventListener("submit", async (e) => {
  e.preventDefault();

  // form에 입력한 데이터를 매번 선택하기 번거로움
  // new FormData(form) => form에 있는 데이터를 모두 가져옴
  // Object.fromEntries(formData) => key : value 형태로 된 object로 만들어줌
  // => 왜 object로 바꾸는지? json 형태로 사용해야하기 때문
  const formData = new FormData(form);
  const objectData = Object.fromEntries(formData);

  const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    // body 안에 objectData 입력
    body: JSON.stringify(objectData),
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  });

  const data = await response.json();
  const { title, body } = data;

  const divTag = document.createElement("div");
  divTag.textContent = `${title} : ${body}`;
  document.querySelector("body").append(divTag);

  // 내가 입력한 값이 사라짐 (기본값으로 돌아감)
  form.reset();
});

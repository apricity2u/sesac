fetch(url, options)
  // fetch : 응답을 받는 역할
  // url : 요청을 보낼 대상
  // options : HTTP 요청 추가 정보 설정 가능한 객체 {}
      // options에는
      // url에 대한 정보인 'header' 
      // ex. 데이터가 어떤 형태로 되어있는지 알려줌

      // http 요청 방식인 'method'를 설정할 수 있다

      // http 요청 시 추가 전송할 데이터 'body'를 추가 작성할 수 있다

  .then((response) => response.json()) 
  // 응답 데이터가 json이라는 것을 알고 있기 때문에 JSON으로 자료 변환
  // 곧 javaScript 객체를 반환함
  // { status : 200, statusText : 'OK', headers~~~ }
  // promise를 반환함 => promise(response)  
  // 그래서 async 과 await를 사용해줘야함 
  // 비동기 처리 형태로 데이터를 받는데 얼마나 걸릴지 모르기 때문

  .then((data) => console.log(data)) // 데이터를 처리

  .catch((error) => console.error("Error:", error)); // 에러 처리

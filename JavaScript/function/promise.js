const newPromise = new Promise((resolve, reject) => {
  const flag = true;

  if (flag === true) {
    resolve('작업 성공');
  } else {
    reject('작업 실패');
  }
});

newPromise
  .then((result) => { // 비동기 동작이 끝나면!
    console.log(result);
    return 'haha' // then에서 연쇄적으로 들어감 (성공하면)
  })
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.error(error);
  })
  .finally(() => {
    console.log('작업 완료');
  });

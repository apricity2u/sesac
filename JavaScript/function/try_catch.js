function checkAge(num) {
  if (typeof num !== 'number') {
    throw new Error('숫자가 아닙니다.');
  } else if (num < 0) {
    throw new Error('나이가 음수입니다.');
  }
  console.log(num);
}

try {
  // checkAge('문자열'); // Error 발생
  checkAge(-3); // Error 발생
  // checkAge(3); // Error 발생 X
} catch (error) {
  console.error(error.message); // 나이가 음수입니다. (에러(빨간줄))
  console.log(error.message); // 나이가 음수입니다. (텍스트)
} finally {
  console.log('어찌됐건 실행됨.'); // 어찌됐건 실행됨
}

const numbers = [1, 2, 3, 4];

const doubled = numbers.map( // doubled 라는 함수는 
                            // numbers라는 array에 괄호 안에 있는 함수를 적용할거야
    (num) => {
    return num * 2;
    // numbers라는 array에 있는 요소들을 매개변수 num에 넣을거고.
    // 2를 곱한 값을 반환할거야
}
);

console.log(doubled); // [2, 4, 6, 8]

// arr = [x, y, z] 배열에
// new_arr = [f(x), f(y), f(z)] 함수를 적용하는 것이 바로 map 


const strNumbers = ['1', '2', '3', '4'] 
// string 형태로 된 숫자
console.log(parseInt('1')) // 1
console.log('1') // '1'

const intNumbers = [1, 2, 3, 4] 
// 숫자형 형태로 된 숫자

const changeType = strNumbers.map (
    // changeType이라는 함수는 strNumbers라는 array에 
    // 괄호 안에 있는 기능을 사용할거야 
    (num) => {
        return parseInt(num)
    }
    // num 이라는 매개변수에 array에 있는 요소들을
    // 인자로 받아서 return 할거야 
)

console.log(changeType)
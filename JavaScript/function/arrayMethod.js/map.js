const numbers = [1, 2, 3, 4];

const doubled = numbers.map(
    (num) => {
    return num * 2;
}
);

console.log(doubled); // [2, 4, 6, 8]

// arr = [x, y, z]
// new_arr = [f(x), f(y), f(z)]


const strNumbers = ['1', '2', '3', '4']
console.log(parseInt('1')) // 1
console.log('1') // '1'

const intNumbers = [1, 2, 3, 4]

const changeType = strNumbers.map (
    (num) => {
        return parseInt(num)
    }
)

console.log(changeType)
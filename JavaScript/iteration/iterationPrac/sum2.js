const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

// for

let sum = 0;

for (i = 0; i < nums.length; i++) {
  sum += nums[i];
}

console.log(sum);

console.log('---------------');

// while

let sum2 = 0;
let a = 0;

while (a < nums.length) {
  sum2 += nums[a];
  a++;
}

console.log(sum2);

console.log('-------------');
// while + break

let sum3 = 0;
let b = 0;

while (nums.length) {
  sum3 += nums[b];
  b++;

  if (b === 9) break;
}

console.log(sum3);

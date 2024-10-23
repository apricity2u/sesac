const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];

const notLog = [1, 4, 5, 7];
// not log 안에 내가 뽑은 숫자가 들어있니?
// 들이있으면 출력하지 않을게!

// 들어있지 않은 것을 체크하기 위해서는 모든 리스트를 뒤져봐야함
// 들어있는 경우를 체크하기 위해서는 한 번이면 충분함
// 모든 경우를 돌면서 한번이라도 만나면 걔는 들어있는 것

for (let num of arr) {
  let isInNotLog = false; // 처음엔 num이 notLog에 들어있지 않은 상태로 셋팅

  for (let notLogNum of notLog) {
    if (num === notLogNum) {
      isInNotLog = true; // arr에서 뽑은 num이 notLog에서 뽑은 notLogNum이랑 같으면 들어있는거니까
      break; // 멈춰! (두 숫자가 같다는게 확인되면 더이상 확인 안해도 되니까!)
    }
  }

  if (isInNotLog) continue; // num= notLogNum 이 같으면 true로 바뀌었을테니까 반복문 계속 돌아야함
  console.log(num); // 안들어있으면 출력 = 두 숫자가 같지 않으면 출력

  // if (!isInNotLog){
  //   console.log(num)
  // }
}

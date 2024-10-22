//100점일 때 A학점과 교수님의 총애
//90점 이상은 A
//80점 이상은 B
//그 외는 C
//40점 이하는 C학점과 학사경고

const score = 40;

if (score >= 90) {
  console.log('A');

  if (score === 100) {
    console.log('교수님의 총애');
  }
} else if (score >= 80) {
  console.log('B');
} else {
  console.log('C');

  if (score < 40) {
    console.log('학사경고');
  }
}
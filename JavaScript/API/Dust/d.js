// lodash 불러오기
var _ = require('lodash');

async function fetchDustInfo() {
  const URL =
    'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=%2BiEaRW7xrORUYANDjKPrnvW9DAAqDJNKv3E4sm3Vwbes8db4rFSa%2FTnEVPEmaCWv1BzeVE2ek9Fv8onYt9obpQ%3D%3D&returnType=json&numOfRows=30&pageNo=1&stationName=%EC%A2%85%EB%A1%9C%EA%B5%AC&dataTerm=MONTH&ver=1.0';
  const res = await fetch(URL);
  let data = await res.json();

  data = data.response.body.items;

  averageData = {};
  
  for (let datum of data) {
    // 날짜 - 시간으로 나누기 (공백을 기준으로 split)
    // datum.dataTime.split('') => array ['2024-10-29', '14:00'] => 0번째 인덱스만 가져오기
    let dataTime = datum.dataTime.split(' ')[0];
    // pm25Value를 parseInt로 string -> int
    let pm25Value = parseInt(datum.pm25Value);

    // averageData 날짜에 맞는 array가 있으면 array 안에 pm25Value 값을 push하고
    if (Object.keys(averageData).includes(dataTime)) {
      averageData[dataTime].push(pm25Value);
    // 없으면 array 만들어주기
    } else {
      averageData[dataTime] = [pm25Value];
    }
  }

  // 평균으로 바꿔주기
  // averageData에 있는 key값을 반복문을 돌면서 하나씩 뽑는다
  for (let key in averageData) {
    // value 값에는 pm25Value 값이 들어간 array가 할당된다
    let value = averageData[key];
    // lodash의 mean method를 사용해서 array 안에 있는 값에 대한 평균값을 구하고 value에 할당한다.
    value = _.mean(value);
    // averageData라는 object안에 key값의 value값을 변경
    averageData[key] = value;
  }
  console.log(averageData);
  
}

fetchDustInfo();

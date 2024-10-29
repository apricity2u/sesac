function filterNetWorkError(data) {
  const result = data.filter((el) => {
    if (el.pm25Flag === '통신장애') return false;

    return true;
  });
  return result;
}

async function dustRealTime() {
  const URL =
    'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%2B6ikG12lt7km0lVIFGALVV4Fg2BOVQjT%2Bz0%2Bs8SfcWvccYPmPhJdDIavTfjabYQ8dP%2F9CULekZtziOSYv4Ilmg%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0';

  const response = await fetch(URL);
  let data = await response.json();

  data = data.response.body.items;

  // 통신장애 데이터를 거르고 싶다. (통신장애인 경우 pm25Value = '-')
  // 음수나 너무 높은 값을 걸러야할 수도 있음
  data = filterNetWorkError(data);

  //초기값 설정 후 pm25Value가 가장 낮은 stationName 찾기
  let min_pm25Value = Infinity;
  let min_stationName = null;

  for (let info of data) {
    // pm25Value를 parseInt로 string -> int
    const pm25Value = parseInt(info.pm25Value);

    // if (pm25Value === "-") continue;

    if (pm25Value < min_pm25Value) {
      min_pm25Value = pm25Value;
      min_stationName = info.stationName;
    }
  }

  console.log(min_pm25Value, min_stationName);
}

dustRealTime();

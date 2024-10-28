async function dustRealTime() {
  const URL =
    "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%2B6ikG12lt7km0lVIFGALVV4Fg2BOVQjT%2Bz0%2Bs8SfcWvccYPmPhJdDIavTfjabYQ8dP%2F9CULekZtziOSYv4Ilmg%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0";

  const response = await fetch(URL);
  const data = await response.json();

  const airStatusInfo = data.response.body.items;

  let min_pm25Value = Infinity;
  let min_stationName = null;

  for (let info of airStatusInfo) {
    const pm25Value = info.pm25Value;
    const stationName = info.stationName;

    if (pm25Value === null || pm25Value === "-") continue;

    if (pm25Value < min_pm25Value) {
      min_pm25Value = pm25Value;
      min_stationName = stationName;
    }
  }

  console.log(min_pm25Value, min_stationName);
}

dustRealTime();

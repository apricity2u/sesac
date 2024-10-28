async function jungGu_Status() {
  const URL =
    "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=%2B6ikG12lt7km0lVIFGALVV4Fg2BOVQjT%2Bz0%2Bs8SfcWvccYPmPhJdDIavTfjabYQ8dP%2F9CULekZtziOSYv4Ilmg%3D%3D&returnType=json&numOfRows=100&pageNo=1&stationName=%EC%A4%91%EA%B5%AC&dataTerm=MONTH&ver=1.0";

  const response = await fetch(URL);
  const data = await response.json();

  const airStatusInfo = data.response.body.items;
  const new_airStatusInfo = [];

  for (let info of airStatusInfo) {
    const new_pmValue = {};
    const date = info.dataTime;
    const pm10Value = info.pm10Value;
    const pm25Value = info.pm25Value;

    new_pmValue["date"] = date;
    new_pmValue["pm10Value"] = pm10Value;
    new_pmValue["pm25Value"] = pm25Value;

    new_airStatusInfo.push(new_pmValue);
  }

  console.log(new_airStatusInfo);
}

jungGu_Status();

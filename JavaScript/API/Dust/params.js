async function fetchDustInfo() {
  const baseURL = 'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc';
  const path = '/getCtprvnRltmMesureDnsty';
  const params = new URLSearchParams({
    sidoName: '서울',
    ver: '1.0',
    pageNo: 1,
    numOfRows: 100,
    returnType: 'json',
    serviceKey:
      '+iEaRW7xrORUYANDjKPrnvW9DAAqDJNKv3E4sm3Vwbes8db4rFSa/TnEVPEmaCWv1BzeVE2ek9Fv8onYt9obpQ==',
    // 동작하지 않음
    // serviceKey:
    //   '%2BiEaRW7xrORUYANDjKPrnvW9DAAqDJNKv3E4sm3Vwbes8db4rFSa%2FTnEVPEmaCWv1BzeVE2ek9Fv8onYt9obpQ%3D%3D',
  });

  const URL = `${baseURL}${path}?${params}`;
  const res = await fetch(URL);
  let data = await res.text();
  console.log(data);

  // data = data.response.body.items;
}

fetchDustInfo();

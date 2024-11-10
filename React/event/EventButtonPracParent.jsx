import Button from "./EventButtonPracChild"

function App() {
  return (
    <>
      <Button onClick={(e) => alert("확인완료")} backgroundColor = 'blue'>확인</Button>
      <Button onClick={(e) => alert("취소완료")} backgroundColor = 'red'>취소</Button>
      <Button onClick={(e) => alert("보류완료")} backgroundColor = 'gray'>보류</Button>
      <Button onClick={(e) => alert("1억원을 얻었습니다")}  backgroundColor = 'pink'>1억년</Button>
    </>
  )
}

export default App

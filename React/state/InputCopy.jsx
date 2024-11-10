import {useState} from 'react'

export default function InputCopy() {

  const [myInput, setInput] = useState(" ")

  // 현재 매개변수 value에는 input태그의 value값이 들어있음
  function showContent(value) {
    // myInput이라는 state 변수에 value 값을 할당한다.
    setInput((myInput) => myInput = value)
  }

  return (
    <>
      {/* input 값을 보여줄 div 태그 */}
      <div>{myInput}</div>
      {/* input 태그 내에서 '클릭'했을 때, event가 발생한 input 태그의 value 값을 showContent의 인자로 전달 */}
      <input type="text" onChange={(event) => showContent(event.target.value)}/>
    </>
  )
}

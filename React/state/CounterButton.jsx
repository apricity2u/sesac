import {useState} from 'react'

export default function CounterButton() {

  const [num, setNum] = useState(0)

  // 숫자가 1 감소하는 함수
  function minus() {

    {/* 만약에 '0'이하일 때는 숫자가 감소하지 않으려면? */}
    if (num > 0) {
      setNum((prey) => prey-1)
    }
  }

  // 숫자가 1 증가하는 함수  
  function plus() {
    setNum((prey) => prey+1)
  }


  return (
    <>
      <div>{num}</div>
      <button onClick={minus}>-</button>
      <button onClick={plus}>+</button>
    </>
  )
}

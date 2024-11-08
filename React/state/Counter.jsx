// Q. 버튼을 누를 때마다 화면 속 숫자가 1씩 증가하게 하는 방법이 없을까?
//    - 기본값은 안보임
// A. 내가 동작을 할 때마다 렌더링을 할 수가 없다.
//    - 그럼 화면에서 숫자가 변경되는 것을 보고 싶다면 state를 활용한다.

import React, { useState } from 'react';

export default function Counter() {
  const [num, setNum] = useState(0);

  // 1. num
  // - 여기서 num은 array 처럼 num -> state -> value 이기 때문에 const로 선언한다.

  // 2. setNum
  // - num 이라는 곳에 변경되는 값을 할당하기 위한 함수(setter)
  // - 결국 num을 setNum에 담아서 컴포넌트를 다시 보여주겠다는 뜻

  // 3. useState(0)
  // num이라는 변수의 상태를 관리하겠다는 뜻
  // () 사이에는 초기값을 넣는다.

  return (
    <>
      <div>{num}</div>
      <button
        onClick={() => {
          setNum((prey) => prey + 1);
          // 위처럼 콜백함수를 사용하는 것이 일반적이다.

          // setNum(num + 1)
          // 이때 num은 이전값일 수도 있고 아닐 수도 있음
        }}
      >클릭 +
      </button>
    </>
  );
}

// Q. 버튼을 여러 개를 만들면 어떻게 될까? 아무 버튼이나 누르면 숫자가 +1씩 될까?
// A. 정답은 NO. 
//    버튼마다 각자의 state를 가지고 있기 때문에 버튼을 여러개 만들어도 내가 클릭한 버튼의 숫자만 증가한다.
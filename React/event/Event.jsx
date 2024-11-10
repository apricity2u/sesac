// function Event() {
//   // 무언가의 동작을 했을 때 그것을 trigger로 해서 특정 동작이 실행되는 것

      // #Event은 함수 실행 후에 return 되기 때문에 작동하지X
//   const EventTag = document.querySelector('#Event')

//   EventTag.addEventListener("click", () => {
//     console.log("클릭했네")
//   })

//   return <div id="Event">Event</div>
// }

// export default Event


function Event() {
  // 무언가의 동작을 했을 때 그것을 trigger로 해서 특정 동작이 실행되는 것

  function handleClick() {
    alert("클릭했네!")
  }

  return <div onClick={handleClick}>Event</div>
}

export default Event

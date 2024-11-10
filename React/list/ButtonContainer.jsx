import Button from "./Button"

export default function ButtonContainer() {

  const myButtons = [
    { text: "확인", backgroundColor: "blue" },
    { text: "취소", backgroundColor: "red" },
    { text: "보류", backgroundColor: "gray" },
    { text: "1억년", backgroundColor: "pink" },
  ];

  return (
    myButtons.map((myButton) => {

      const {text, backgroundColor} = myButton

      return <Button backgroundColor={backgroundColor}>{text}</Button>
    })
  )
}

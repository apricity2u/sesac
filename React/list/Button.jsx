export default function Button() {
  const myButtons = [
    { text: "확인", color: "blue" },
    { text: "취소", color: "red" },
    { text: "보류", color: "gray" },
    { text: "1억년", color: "pink" },
  ];

  return (
    <div>
      {myButtons.map((myButton) => {
        return <button style={{ backgroundColor: myButton.color, color : "white" }}>
          {myButton.text}
        </button>
        })}
    </div>
  );
}

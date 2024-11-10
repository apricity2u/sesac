function Button(props) {
  const { onClick } = props;

  return <button onClick={onClick}>클릭</button>;
}

function App() {
  return (
    <>
      <Button onClick={() => alert("실행")}></Button>
      <Button onClick={() => alert("취소")}></Button>
    </>
  );
}

export default App;

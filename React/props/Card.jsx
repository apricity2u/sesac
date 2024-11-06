export default function Card(props) {
  const { style, imgSrc, imgAlt } = props;

  // 스프레드 연산자로 width, height 바로 전달 가능
  // key & value 값이 같으면, 한 개만 적어도 됨
  const card = {
    ...style,
    border: "solid 1px",
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
    textAlign: "center",
    margin: "0.5rem",
  };

  return (
    <div style={card}>
      <img src={imgSrc} alt={imgAlt} width={"100"} />
      <h1>title</h1>
      <p>content</p>
    </div>
  );
}

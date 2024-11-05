export default function Card(props) {
  const { width, height, imgSrc, imgAlt } = props;

  const card = {
    width: width,
    height: height,
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

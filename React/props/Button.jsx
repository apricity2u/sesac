export default function Button(props) {
  const { text, color } = props;

  return (
    <button
      style={{
        color: "white",
        backgroundColor: color,
      }}
    >
      {text}
    </button>
  );
}

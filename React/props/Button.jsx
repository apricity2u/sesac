export default function Button(props) {
  const { name, color } = props;

  return (
    <button
      style={{
        color: "white",
        backgroundColor: color,
      }}
    >
      {name}
    </button>
  );
}

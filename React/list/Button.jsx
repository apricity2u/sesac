export default function Button({color="white", backgroundColor, children}) {

  return (
      <button style={{color, backgroundColor}}>{children}</button>
  );
}

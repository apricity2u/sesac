import Title from "./Title";
import SubTitle from "./SubTitle";
import Details from "./Details";

const menuBoard = {
  textAlign: "center",
};


export default function Menu() {
  return (
    <div style={menuBoard}>
      <Title></Title>
      <SubTitle>coffee</SubTitle>
      <Details>coffee</Details>
      <SubTitle>ade</SubTitle>
      <Details>ade</Details>
    </div>
  );
}

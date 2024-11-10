import MenuTitle from "./MenuTitle";
import MenuDetails from "./MenuDetails";
import MenuSubTitle from "./MenuSubTitle";

const menuBoard = {
  textAlign: "center",
};

const menuList = [{
  name : "아메리카노",
  price : "5.0/5.5",
  catagory : "coffee"
},{
  name : "카페라떼",
  price : "5.0/5.5",
  catagory : "coffee"
},{
  name : "바닐라라떼",
  price : "5.0/5.5",
  catagory : "coffee"
},{
  name : "카라멜마끼아또",
  price : "5.0/5.5",
  catagory : "coffee"
},{
  name : "레몬에이드",
  price : "6.0",
  catagory : "ade"
},{
  name : "자몽에이드",
  price : "6.0",
  catagory : "ade"
},{
  name : "유자에이드",
  price : "6.0",
  catagory : "ade"
},
]




export default function Menu() {
  return (
    <div style={menuBoard}>
      <MenuTitle></MenuTitle>

      <MenuSubTitle>COFFEE</MenuSubTitle>
      <ul>
        {menuList.filter((menu) => menu.catagory === "coffee").map((menu) => {

          const {name, price} = menu

          return <MenuDetails name={name} price={price}></MenuDetails>
        })}
      </ul>


      <MenuSubTitle>ADE</MenuSubTitle>
      <ul>
        {menuList.filter((menu) => menu.catagory === "ade").map((menu) => {

          const {name, price} = menu

          return <MenuDetails name={name} price={price}></MenuDetails>
        })}
      </ul>
    </div>
  );
}

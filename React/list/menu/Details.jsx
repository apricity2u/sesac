export default function Details({children}) {

  const menu = [{
    name : "아메리카노",
    price : "5.0/5,5",
    catagory : "coffee"
  },{
    name : "카페라떼",
    price : "5.0/5,5",
    catagory : "coffee"
  },{
    name : "바닐라라떼",
    price : "5.0/5,5",
    catagory : "coffee"
  },{
    name : "카라멜마끼아또",
    price : "5.0/5,5",
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

const flexbox = {
  display : "flex",
  justifyContent : "center",
  flexDirection : "column"
}

const flexboxList = {
  display : "flex",
  justifyContent : "spaceEvenly"
}

  return (
    <>
    <ul style={flexbox}>{menu.filter((item) => item.catagory === children).map((item)=> {
      const {name, price} = item

      return <li style={flexboxList}>
        <div>{name}</div>
        <div>{price}</div>
      </li>
    })}</ul>
    </>
  )
}

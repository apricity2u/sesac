const flexbox = {
  display:"flex", 
  justifyContent: "space-evenly"
}

export default function MenuDetails({name, price}) {

  return <div style={flexbox}><span>{name}</span>{price}</div>
}

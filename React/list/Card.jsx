export default function Card() {

  const sizes = [
    {width: 100, height: 100},
    {width: 200, height: 150},
    {width: 300, height: 200},
    {width: 400, height: 250},
   ]

  return (
    sizes.map((size) => {
      return <div style={{width : size.width, height: size. height, backgroundColor: "lightblue"}}>
        <h1>title</h1>
        <p>content</p>
      </div>
    })
  )
}

export default function Products() {

  const products = [
    { id: 1, name: '노트북', price: 55000 },
    { id: 2, name: '마우스', price: 15000 },
    { id: 3, name: '키보드', price: 45000 },
    { id: 4, name: '마우스패드', price: 8000 },
    { id: 5, name: '모니터', price: 150000 }
  ];

  const new_products = products.filter((product) => product.price >= 30000)

  return (
    <div>{new_products.map((new_product) => {

      const {id, name, price} = new_product

      return (
      <>
      <div>id: {id}</div> 
      <div>name: {name}</div>
      <div>price: {price}</div>
      </>
      )
    })}</div>
  )
}

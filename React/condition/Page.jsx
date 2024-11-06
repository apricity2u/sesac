function AdminPage() {
  return <div>AdminPage</div>
}

function UserPage() {
  return <div>UserPage</div>
}

export default function Page() {

  const admin = true

  return (
    <>
      <h1>나의 앱</h1>
      {/* admin, user 페이지 위치 */}
      <div>{admin ? <AdminPage></AdminPage> : <UserPage></UserPage>}</div>
    </>
  )
}


// export default function Page() {
//   const isAdmin = false
  
//   let renderedPage

//   if (isAdmin) {
//     renderedPage = <AdminPage></AdminPage>
//   }else {
//     renderedPage = <UserPage></UserPage>
//   }

//   return (
//     <>
//       <h1>나의 앱</h1>
//       {renderedPage}
//     </>
//   )
// }




// export default function Page() {

//   const admin = false
//   const user = true

//   return (
//     <>
//       <h1>나의 앱</h1>
//       {/* admin, user 페이지 위치 */}
//       <div>{admin && <AdminPage></AdminPage>}</div>
//       <div>{user && <UserPage></UserPage>}</div>
//     </>
//   )
// }

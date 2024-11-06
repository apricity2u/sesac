function AdminPage() {
  return <div>AdminPage</div>
}

function UserPage() {
  return <div>UserPage</div>
}

function ManagerPage() {
  return (
    <div>ManagerPage</div>
  )
}


export default function OtherPage() {

  const userType = "admin"

  // 삼항연산자
  return (
    <>
      <h1>나의 앱</h1>
      {/* admin, manager, user 페이지 위치 */}
      <div>{userType==='admin' ? <AdminPage></AdminPage> : (userType==='user' ? <UserPage></UserPage> : <ManagerPage></ManagerPage>)}</div>
    </>
  )

  // return (
  //   <>
  //     <h1>나의 앱</h1>
  //     {userType==='admin' && <AdminPage></AdminPage>}
  //     {userType==='user' && <UserPage></UserPage>}
  //     {userType==='manager' && <ManagerPage></ManagerPage>}
  //   </>
  // )


}

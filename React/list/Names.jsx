export default function Names() {

  const names = ['김철수', '이영희', '박민수', '정지원', '최동욱'];

  return (
    <ul>{names.map((name) => {
      return <li>{name}</li>
    })}</ul>
  )
}

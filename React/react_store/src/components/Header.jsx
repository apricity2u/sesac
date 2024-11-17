import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { changeLoignStatus } from '../store/slices/loginSlice';
// import { login, logout } from '../store/slices/loginSlice';

export default function Header() {
  const { isLogin } = useSelector((state) => state.isLogin);
  
  const buttonText = !isLogin ? '로그인' : '로그아웃';

  const dispatch = useDispatch();

  function loginStatus() {
    dispatch(changeLoignStatus({ isLogin: !isLogin }));
  }

  return (
    <header>
      <ul>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/posts">게시글로</Link>
        </li>
        {/*생각해볼 것
          로그아웃 상태일 때 게시글 생성하기를 아예 안 보여주는게 좋을지?
          로그아웃하면 홈 화면으로 돌아가게끔 하면 어떨까?
        */}
        {isLogin && (
          <li>
            <Link to="/posts/create">게시글 생성하기</Link>
          </li>
        )}
      </ul>
      <button onClick={loginStatus}>{buttonText}</button>
      {/* 
        isLogin ? 
        <button onClick={() => {dispatch(login())}}>로그아웃</button> 
        : <button onClick={() => {dispatch(logout())} }}>로그인</button>
      */}
    </header>
  );
}

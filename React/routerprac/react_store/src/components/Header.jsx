import { Link, useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { changeLoignStatus } from '../store/slices/loginSlice';

export default function Header() {
  const isLogin = useSelector((state) => state.isLogin);

  const buttonText = isLogin.isLogin ? '로그인' : '로그아웃';

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
        {buttonText === "로그인" && (
          <li>
            <Link to="/posts/create">게시글 생성하기</Link>
          </li>
        )}
      </ul>
      <button onClick={loginStatus}>{buttonText}</button>
    </header>
  );
}

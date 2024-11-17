import { Outlet } from 'react-router-dom';
import WebtoonHeader from '../../../../components/WebtoonHeader';

export default function Webtoon() {
  return (
    <>
      <WebtoonHeader></WebtoonHeader>
      <Outlet></Outlet>
      <footer>webtoon footer</footer>
    </>
  );
}

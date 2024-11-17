import { Outlet } from "react-router-dom";
import NovelHeader from '../components/NovelHeader';

export default function Novel() {
  return (
    <div className="webtoonBoard">
      <NovelHeader></NovelHeader>
      <Outlet></Outlet>
      <footer>novel footer</footer>
    </div>
  );
}

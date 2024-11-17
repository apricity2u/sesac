import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import RootLayout from "../layout/RootLayout";
import NotFound from "../pages/NotFound";
import Webtoon from "../layout/Webtoon";
import WebtoonMain from "../pages/WebtoonMain";
import WebtoonDay from "../pages/WebtoonDay";
import Novel from "../layout/Novel";
import NovelMain from "../pages/NovelMain";
import NovelGenre from "../pages/NovelGenre";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <NotFound />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: "/webtoon",
        element: <Webtoon />,
        children: [
          {
            index: true,
            element: <WebtoonMain />,
          },
          {
            path: "/webtoon/:day",
            element: <WebtoonDay />,
            // 잘못된 url로 접속했을 때 loader, action 등과 같은 방식이 있음
          },
        ],
      },
      {
        path: "/novel",
        element: <Novel />,
        children: [
          {
            index: true,
            element: <NovelMain />,
          },
          {
            path: "/novel/:genre",
            element: <NovelGenre />,
          },
        ],
      },
    ],
  },
]);

export default router;

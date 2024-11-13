import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import RootLayout from "../../RootLayout";
import NotFound from "../pages/NotFound";
import Webtoon from "../pages/Webtoon";
import WebtoonMain from "../pages/WebtoonMain";
import WebtoonDay from "../pages/WebtoonDay";
import Novel from "../pages/Novel";
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

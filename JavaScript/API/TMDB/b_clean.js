const baseURL = "https://api.themoviedb.org/3/movie";
const params = new URLSearchParams({
  api_key: "eab8c9893e725b2e167187cef66bae3d",
  language: "ko",
});

/*
- 현재 상영중인 영화의 목록을 return한다. 
*/

async function getNowPlayingMovies() {
  const path = "/now_playing";

  let URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  const movies = data.results;
  return movies;
}
/*
- 영화의 리스트를 입력받아서 vote_average가 가장 높은 영화를 반환한다.
*/
function getPopularMovie(movies) {
  const maxVoteMovie = movies.reduce((acc, cur) => {
    const accVoteAverage = acc.vote_average;
    const curVoteAverage = cur.vote_average;

    if (accVoteAverage > curVoteAverage) {
      return acc;
    } else if (accVoteAverage < curVoteAverage) {
      return cur;
    }
  });
  return maxVoteMovie;
}

async function getDetailMovie(movieID) {
  const path = `/${movieID}`;
  const URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  return data;
}

async function main() {
  // 1. 현재 상영중인 영화를 가져온다.
  const movies = await getNowPlayingMovies();
  // 2. 영화 중 가장 평점이 높은 영화를 가져온다.
  const movie = getPopularMovie(movies);
  // 3. 그 영화의 detail한 정보를 가져온다.
  const movieId = movie.id;
  const detailMovie = await getDetailMovie(movieId);

  console.log(detailMovie.revenue);
}

main();

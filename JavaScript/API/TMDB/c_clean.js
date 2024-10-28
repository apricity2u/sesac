// 현재 상영 중인 영화 중 평점(vote_average)이 7 이상인 영화를 나열하시오.

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

function upto_7(movies) {
  const vote_average_upto_7 = [];

  for (let movie of movies) {
    const vote_average = movie.vote_average;

    if (vote_average >= 7) {
      vote_average_upto_7.push(movie);
    }
  }

  console.log(vote_average_upto_7);
}

async function main() {
  // 1. 현재 상영중인 영화를 가져온다.
  const movies = await getNowPlayingMovies();

  // 2. 평점 7 이상인 영화를 나열
  const upto_7 = upto_7(movies)

  const upto_7_ver2 = movies.filter((movie) => movie.vote_average >= 7)
  console.log(upto_7_ver2)
}

main();

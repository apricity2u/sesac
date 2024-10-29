// 현재 상영 중인 영화 중 평점(vote_average)이
// 가장 높은 영화의 수익(revenue)를 찾으시오.

const baseURL = "https://api.themoviedb.org/3/movie";
const path = "/now_playing";
const params = new URLSearchParams({
  api_key: "699fc272ef469704ac75915ee54d9ab6",
  language: "ko",
});

// 1. 현재 상영 중인 영화 정보 가져오기

async function nowPlayingMovie() {
  const URL = `${baseURL}${path}?${params}`;
  // URL을 통해 응답 받기
  // 데이터를 받는데 시간이 걸리기 때문에 비동기 처리하기 (async-await)
  const response = await fetch(URL);
  const data = await response.json();

  // 영화에 대한 정보가 필요하다
  // results라는 key값의 value 값으로 array 형태로 되어있다.
  return data.results;
}

// 2. 평점이 가장 높은 영화의 아이디를 찾아보자
// 1번을 통해서 영화들의 정보를 가져왔다.
function maxVoteAverageID(movies) {
  // array 안에 원소들이 object 형태로 들어있다.
  // object 안에 있는 'vote_average'에 접근하자.

  // 초기값을 설정한다
  let maxVoteAverage = 0;
  let maxVoteId = null;

  // vote_average가 가장 높은 영화를 찾아보자
  for (let movie of movies) {
    const vote_average = movie.vote_average;
    const movieId = movie.id;

    if (maxVoteAverage < vote_average) {
      maxVoteAverage = vote_average;
      // movie의 id 값을 찾아보기
      maxVoteId = movieId;
    }
  }
  // vote_average가 가장 높은 영화의 id값 출력
  return maxVoteId;
}

// 3. 해당 영화의 아이디를 통해 영화의 details에 접근하자
async function maxVoteMovieDetails(maxVoteId) {
  const URL = `${baseURL}/${maxVoteId}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  const maxVoteRevenue = data.revenue;

  return maxVoteRevenue;
}

async function getRevenue() {
  // 현재 상영 중인 영화 정보를 가져온다
  const movies = await nowPlayingMovie();
  // 현재 상영 중인 영화 중에서 가장 평점이 높은 영화의 아이디를 찾아보자.
  const maxVoteId = maxVoteAverageID(movies);
  // 평점이 가장 높은 영화의 아이디로 영화 디테일을 가져온다.
  const maxVoteRevenue = await maxVoteMovieDetails(maxVoteId);

  console.log(maxVoteRevenue);
}

//디테일 중에 수익에 해당하는 값을 가져온다.
getRevenue();

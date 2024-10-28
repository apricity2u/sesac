// 현재 상영 중인 영화 중 평점(vote_average)이 가장 높은 영화의 포스터 이미지를 조회하시오.

async function getPost() {
  try {
    const baseURL = "https://api.themoviedb.org/3/movie";
    const path = "/now_playing";
    const params = new URLSearchParams({
      api_key: "699fc272ef469704ac75915ee54d9ab6",
      language: "ko",
    });

    const URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;

    let top_vote_average = 0;
    let top_vote_average_poster_img = null;

    for (let movie of movies) {
      const vote_average = movie.vote_average;
      const poster_img = movie.poster_path;

      if (vote_average > top_vote_average) {
        top_vote_average = vote_average;
        top_vote_average_poster_img = poster_img;
      }
    }

    console.log(`https://image.tmdb.org/t/p/w500${top_vote_average_poster_img}`);
  } catch (error) {
    console.error("Error:", error);
  }
}

getPost();

// configuration 통해서 규격화된 이미지 사이즈 정보를 찾을 수 있음

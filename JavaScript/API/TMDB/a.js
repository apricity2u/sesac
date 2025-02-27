// 현재 상영 중인 영화 중 평점(vote_average)이 가장 높은 영화를 찾으시오.

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

    let top_vote_average = 0
    let top_vote_average_movie = null

    for (let movie of movies) {
      const vote_average = movie.vote_average;

      if (vote_average > top_vote_average) {
        top_vote_average = vote_average;
        top_vote_average_movie = movie
      }
    }

    console.log(top_vote_average, top_vote_average_movie);
  } catch (error) {
    console.error("Error:", error);
  }
}

getPost();

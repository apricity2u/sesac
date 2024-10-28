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

    // reduce 는 순차적으로 누적하여 하나의 값으로 반환
    // 여기서는 object 하나씩 꺼내옴
    // acc 초기 누적값은 첫번째 object가 들어감
    const maxVoteMovie = movies.reduce((acc, cur) => {
      const accVoteAverage = acc.vote_average;
      const curVoteAverage = cur.vote_average;

      if (accVoteAverage > curVoteAverage) {
        return acc;
      } else if (accVoteAverage < curVoteAverage) {
        return cur;
      } else {
        // 같을 때
        const accVoteCount = acc.vote_count;
        const curVoteCount = cur.vote_count;

        if (accVoteCount > curVoteCount) {
          return acc;
        } else {
          return cur;
        }
        // 생략
      }
    });

    console.log(maxVoteMovie.title);
  } catch (error) {
    console.error("Error:", error);
  }
}

getPost();

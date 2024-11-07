export default function SubTitle({ children }) {
  const subTitles = [{ catagory: "coffee" }, { catagory: "ade" }];

  return (
    <>
      {subTitles
        .filter((subTitle) => subTitle.catagory === children)
        .map((subTitle) => {
          return (
            <>
              <h3>{subTitle.catagory}</h3>
              <hr></hr>
            </>
          );
        })}
    </>
  );
}

import MenuCategory from "./MenuCategory";

export default function Menu() {

// 카테고리를 모아두는 것이 데이터를 관리하는데 유용하다

  const beverages = {
    categories: ["coffee", "ade", "tea"],
    result: {
      coffee: [
        { name: "아메리카노", price: "5.0/5.5" },
        { name: "카페 라떼", price: "6.0/6.5" },
        { name: "바닐라 라떼", price: "6.0/6.5" },
      ],
      ade: [
        { name: "레몬에이드", price: "6.0" },
        { name: "자몽에이드", price: "6.0" },
        { name: "유자에이드", price: "6.0" },
      ],
      tea: [
        { name: "녹차", price: "6.0" },
        { name: "둥굴레차", price: "6.0" },
        { name: "홍차", price: "6.0" },
      ],
    },
  };

  // categories : array & result : object
  const { categories, result } = beverages;

  // const beveragesList = [[coffee, result[coffee]], [tea, result[tea]]]
  const beveragesList = categories.map((category) => {
    return [category, result[category]];
  });
 
  const menuCategories = beveragesList.map((el) => {
    const [category, beverages] = el;
    // category : "tea"
    // beverages : [
    //     { name: "녹차", price: "6.0" },
    //     { name: "둥굴레차", price: "6.0" },
    //     { name: "홍차", price: "6.0" },
    //   ]

    return (
      <MenuCategory category={category} beverages={beverages}></MenuCategory>
    );
  });

  return (
    <>
      <h1 className="text-center">MenuBetter</h1>
      <main>{menuCategories}</main>
    </>
  );
}

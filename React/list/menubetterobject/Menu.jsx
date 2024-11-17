import React from "react";
import MenuCategory from "./MenuCategory";
export default function Menu() {
  const beverages = {
    categories: ["coffee", "ade", "tea", "specialtea"],
    result: [
      { name: "아메리카노", price: "5.0/5.5", category: "coffee" },
      { name: "카페 라떼", price: "6.0/6.5", category: "coffee" },
      { name: "바닐라 라떼", price: "6.0/6.5", category: "coffee" },

      { name: "레몬에이드", price: "6.0", category: "ade" },
      { name: "자몽에이드", price: "6.0", category: "ade" },
      { name: "유자에이드", price: "6.0", category: "ade" },

      { name: "녹차", price: "6.0", category: "tea" },
      { name: "둥굴레차", price: "6.0", category: "tea" },
      { name: "홍차", price: "6.0", category: "tea" },

      { name: "녹차", price: "6.0", category: "specialtea" },
      { name: "둥굴레차", price: "6.0", category: "specialtea" },
      { name: "홍차", price: "6.0", category: "specialtea" },
    ],
  };
  const { categories, result } = beverages;

  // 빈 object를 만들고
  const beveragesObject = {};

  // 빈 object에 category를 키 값으로 가지는 데이터만 넣는다.
  // beveragesObject = {
  //   coffee : [
  //          { name: "아메리카노", price: "5.0/5.5", category: "coffee" },
  //          { name: "카페 라떼", price: "6.0/6.5", category: "coffee" },
  //          { name: "바닐라 라떼", price: "6.0/6.5", category: "coffee" }
  //   ]
  // }
  categories.forEach((category) => {
    beveragesObject[category] = result.filter((beverage) => {
      return beverage.category === category;
    });
  });

  
  // key, value 쌍을 array로 반환하는 Object.entries(obj)
  // beveragesList = [[coffee, [
  //                     { name: "아메리카노", price: "5.0/5.5", category: "coffee" },
  //                     { name: "카페 라떼", price: "6.0/6.5", category: "coffee" },
  //                     { name: "바닐라 라떼", price: "6.0/6.5", category: "coffee" }
  //                    ]
  //                   ]
  //                  ]
  const beveragesList = Object.entries(beveragesObject);

  const menuCategories = beveragesList.map((el) => {
    // el의 0번째는 category 1번째는 beverages array
    const [category, beverages] = el;
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

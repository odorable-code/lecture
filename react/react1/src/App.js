// 다른 컴포넌트를 가져와서 사용하는 방법
// import 컴포넌트명 from '컴포넌트 js파일명';
// import { 컴포넌트1, 컴포넌트2 } from '컴포넌트 js파일명';

import { Btn1, Btn2, Btn3, Btn4 } from "./Btns";
import Select from "./input";

/* 
  컴포넌트 생성방법
  1. 함수로 생성
     - 함수로 생성하는 방법이 대세
  2. 클래스로 생생

  컴포넌트 생성 방법
  방법1. 함수 선언식
  function 컴포넌트명() {
    return (
    
    )
  }
  
  방법2. 함수 표현식
  const 컴포넌트명 = function() {
    return (
    
    )
  }
  
  const 컴포넌트명 = () => {
    return (
    
    )
  }

*/

/* 주의사항
1. 컴포넌트는 대문자자로 시작해야 한다
2. return 할 때 ()가 없으면 상황에 따라 에러가 발생하니 ()를 붙여주는 습관을 들이자
3. return 안에 최상위 요소는 하나여야 한다.
*/

/*
  Select 컴포넌트를 input.js에 생성해서 구성하고
  app 컴포넌트에서 불러와서 배치
  select 컴포넌트:
  <select>
    <option>타입1</option>
    <option>타입2</option>
  </select>
  속성 이름 주의
  1. class 속성 대신 className으로
  2. for 속성 대신 htmlFor로
*/
const App = function() {
  const btnName1 = "일반버튼3";
  const btnName2 = "일반버튼4";
  return (
    <div className="App">
      <Btn1 />
      <Btn2 />
      <Btn3 text={btnName1} color={"red"} />  
      <Btn3 />
      <Btn4 text={btnName2} color={"blue"} />
      <Btn4 />
      <Select />
      {/* <label htmlFor="id">아이디</label>
      <input type="text" id="id" /> */}

    </div>
  );
}


// export default 컴포넌트명; => 이 파일에서 하나의 컴포넌트만 내보내는 경우=
// 내보낸다 => 다른 곳에서 해당 컴포넌트를 사용할 수 있다.
export default App;

// 여러 컴포넌트를 밖에서 사용할 수 있게 내보내는 방법
// export { 컴포넌트1, 컴포넌트2, ... };
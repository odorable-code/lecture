import { useEffect, useState } from "react";

// UseEffect 예제
function UseEffect() {
  let [ num, setNum ] = useState(0);
  let [ num2, setNum2 ] = useState(0);
  // 의존성 배열 생략 => 렌더링 될 때마다 싱행
  useEffect(() => {  
    console.log('useEffect 실행. 렌더링 될떄마다');
  });

  // 의존성 배열 : 빈배열 => 처음 실행때만 렌더링
  useEffect(() => {
    console.log("useEffect 함수 실행, 처음만");
  }, []);

  // 의존성 배열 :  변수 => 변수가 바뀔때마다 실행
  useEffect(() => {
    console.log("useEffect 함수 실행, num이 바뀔떄만 실행");
    // setNum(num+1); // 주석 풀면 무한루프 발생
  }, [num]);


  return (
    <div>
       <button onClick={() => setNum(num - 1)}>-</button>
       <span style={{padding: "0 10px"}}>{num}</span>
       <button onClick={() => setNum(num + 1)}>+</button>
       <hr/>
       <span>{num2}</span>
       <button onClick={() => setNum2(num2 + 1)}>+</button>
    </div>
  );
}

export default UseEffect;

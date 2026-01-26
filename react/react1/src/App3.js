import { useState } from "react";

function App3() {
	// state를 이용하여 변수 num과 setNum 함수를 가져옴
	// setNum은 num의 값을 변경한 후 렌더링함
	let [num, setNum] = useState(1);
	const plusNum = () => { setNum(num + 1); };
	const minusNum = () => { setNum(num - 1); };
	
	// destructuring(비구조화 할당) 
	let arr = [1, 2, 3];
	let [num1, num2, num3] = arr;
	console.log(num1, num2, num3);

	let obj = {
		name: "홍길동",
		age: 21
	}
	let {name, age} = obj;
	console.log(name, age);

	let arr2 = arr;
	arr2.push(4);
	console.log(arr);

	arr = [1,2,3];
	let arr3 = [...arr];
	arr3.push(4);
	console.log(arr);

	// destructuring(비구조화 할당) 예제끝

	return (
		<div>
			<h1>값 : {num}</h1>
			<button onClick={minusNum}>-</button>
			<button onClick={plusNum}>+</button>
		</div>
	);
}

export default App3;
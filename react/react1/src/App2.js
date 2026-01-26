
// state를 설명하기 위한 예제
function App2() {
	let num = 1;
	// 버튼을 클릭하면 값이 증가하나 화면의 값은 안 바뀜
	// 변수값을 바꾸고 렌더링을 해야하는데 렌더링이 안되기 때문
	const plusNum = () => {
		++num;
		console.log(num);
	};

	return (
		<div>
			<h1>값 : {num}</h1>
			<button onClick={plusNum}>+</button>
		</div>
	);
}

export default App2;
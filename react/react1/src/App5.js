import { useState } from "react";

// 버튼을 누르면 input 태그에 입력된 값을 h1태그에 추가하는 기능을 구현
function App5() {
	// useState는 배열을 반환 0번지는 변수가 1번지에는 0번지의 값을 변경하는 setter가 있다.
	let [inputText, setInputText] = useState('');
	let [printText, setPrintText] = useState('');

	const change = (e) => setInputText(e.target.value);
	const click = () => setPrintText(inputText);
	return (
		<div>
			<input onChange={change} />
			<button onClick={click}>입력</button>
			<h1>{printText}</h1>
		</div>
	);
}

export default App5;
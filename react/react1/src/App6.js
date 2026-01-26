import { useState } from "react";

function App6() {
	let [fruit, setFruit] = useState('선택된 과일이 없습니다.');
	const change = (e) => setFruit(e.target.value);

	return (
		<div>
			<h1>좋아하는 과일은?</h1>
			<select onChange={change}>
				<option value="">과일을 선택하세요</option>
				<option>사과</option>
				<option>바나나</option>
				<option>포도</option>
			</select>
			<h2>좋아하는 과일 : {fruit == "" ? "선택된 과일이 없습니다." : fruit}</h2>
		</div>
	);
}

export default App6;

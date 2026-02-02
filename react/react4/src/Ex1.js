import { useState } from "react";

export default function Ex1() {
	let [num, setNum] = useState(0);
	return (
		<div>
			<h1>메인</h1>
			<button onClick={() => setNum(num - 1)}>-</button>
			<input type="number" readonly value={num} />
			<button onClick={() => setNum(num + 1)}>+</button>
		</div>
	);                         
}
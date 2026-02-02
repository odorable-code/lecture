import { useState } from "react";

export default function Ex2() {
	let [txt, setTxt] = useState("예제")
	return (
		<div>
			<h1>{txt ? txt : "예제"}</h1>
			<input type="text" onChange={(e) => setTxt(e.target.value)} />
		</div>
	);
}
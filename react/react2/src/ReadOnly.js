// 쓰기버튼을 클릭하면 읽기 버튼으로 변경되면서 input태그에 입력할 수 있도록 변경되고

import { useState } from "react";

// 읽기버튼을 클릭하면 쓰기 버튼으로 바뀌면서  input 태그에 입력할 수 없도록 변경
function ReadOnly  () {
	let [readonly, setReadonly] = useState(true);
	let [text, setText] = useState("쓰기");
	const onclick = e => {
		setReadonly(!readonly);
		setText(readonly? "읽기" : "쓰기");
	}

	const onclick2 = ( ) => setReadonly(!ReadOnly);

	 return (
		<div>
			<input type="text" readOnly={readonly} />
			<button onClick={onclick}>{text}</button>
			<button onClick={onclick2}>{readonly? "쓰기모드로" : "읽기모드로"}</button>
		</div>
	 )
}

export default ReadOnly;
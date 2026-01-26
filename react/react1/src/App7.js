// 접기 버튼을 누르면 더보기로 바뀌고 내용이 감춰짐

import { useState } from "react";

// 더보기 버튼을 누르면 글자가 접기로 바뀌꾸 내용이 보임
function App7() { 

	// const click = (e) => {
	// 	const contentBox = e.target.nextSibling;
	// 	contentBox.style.display = e.target.textContent === '접기' ? 'none' : 'block';
	// 	e.target.textContent = contentBox.style.display === 'none' ? '더보기' : '접기';
	// }

	const [isOpen, setOpen] = useState(true);

	return (
		<div>
			<button onClick={() => setOpen(!isOpen)}>{isOpen? "접기" : "더보기"}</button>
			{
				isOpen ?
				<div>
					내용입니다.
				</div>
				:
				<div></div>
			}
		</div>
	);
}

export default App7;

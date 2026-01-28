// 분을 입력받으면 초로 변환하는 컴포넌트

import { useState } from "react";

// 숫자를 입력하면 입력된 숫자에 해당하는 초가 바로 출력되도록 구현
function Convert() {
	let [seconds, setSeconds] = useState(0);
	return ( 
		<div>
			<div>
				<input type="number" onChange={e => setSeconds(e.target.value)} value={seconds} />
			</div>
			<input type="number" disabled={true} value={seconds * 60} />
		</div>
	);
}

export default Convert;
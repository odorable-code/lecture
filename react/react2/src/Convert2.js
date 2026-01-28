// 분을 입력받으면 초로 변환하는 컴포넌트

import { useState } from "react";

// 숫자를 입력하면 입력된 숫자에 해당하는 초가 바로 출력되도록 구현
function Convert2() {
	let [secs, setSecs] = useState(0);
	return ( 
		<div>
			<div>
				<input type="number" disabled={true} value={parseInt(secs/60)} />
			</div>
			<input type="number" onChange={e => setSecs(e.target.value)} value={secs} />
		</div>
	);
}

export default Convert2;
import { useState } from "react";

function Convert3() {
	let [amount, setAmount] = useState(0);
	let [flag, setFlag] = useState(true);
	const changeAmount = e => setAmount(e.target.value);
	const btnClick = () => {
		setAmount(flag? amount / 60 : amount * 60);
		setFlag(!flag);
	}
	return ( 
		<div>
			<div>
				<input type="number" disabled={flag} onChange={changeAmount} value={flag? parseInt(amount/60) : parseInt(amount)} />
				<button onClick={btnClick}>변환</button>
			</div>
			<input type="number" disabled={!flag} onChange={changeAmount} value={flag? parseInt(amount) : parseInt(amount * 60)} />
		</div>
	);
}

export default Convert3;
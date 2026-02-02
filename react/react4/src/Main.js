import { useState } from "react";
import Ex1 from "./Ex1";
import Ex2 from "./Ex2";

export default function Main() {
	const [isOpen1, setIsOpen1] = useState(false);
	const [isOpen2, setIsOpen2] = useState(false);

	const showEx = (label) => {
		// label이 예제1이면 isOpen1을 토글하고 (true => false , false => true) isOpen2를 false로
		if (label == "예제1" ) {
			setIsOpen1(!isOpen1);
			setIsOpen2(false);
		}
		// 아니면 (예제2이면) isOpen2를 토글하고  isOpen1을 false 
		else {
			setIsOpen2(!isOpen2);
			setIsOpen1(false);
		}
	};

	return (
		<div>
			<h1>메인</h1>
			<div>
				<button onClick={() => setIsOpen1(!isOpen1)}>예제1: {isOpen1 ? "접기" : "보기"}</button>
				<button onClick={() => setIsOpen2(!isOpen2)}>예제2: {isOpen2 ? "접기" : "보기"}</button>
			</div>
			{isOpen1 ? <Ex1 /> : null}
			{isOpen2 ? <Ex2 /> : null}
		</div>
	);
}
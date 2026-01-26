/*
	이벤트 등록시 주의사항
	1. onclick -> onClick (카멜표기법)
	2. 함수 호출이 아닌 함수 전달
	   onClick={함수명} (X)
	   onClick={함수명()} (O)
	   onClick={() => 함수명()} (O)
  
*/
function Btn1() {
	// 버튼 클릭할때 호출될 함수
	const btnClick = () => alert("클릭"); 

	return (
		<button onClick={btnClick}>일반 버튼1</button>
	);
}

const Btn2 = () => {
	return (
		<button>일반 버튼2</button>
	)
}



// 부모가 보낸 정보를 props 객체로 받음
const Btn3 = function(props) {
	return (
		<button style={{color: props.color}}>{props.text}</button>
	)
}

// 부모가 보낸 정보를 객체로 받음
const Btn4 = function({text="버튼", color}) {
	return (
		<button style={{color: color}}>{text}</button>
	)
}

// 예전 리액트에서는 반영됐으나 18버전 이후로는 지양하기 때문에 적용 안됨
// Btn3.defaultProps = {
// 	text: "버튼",
// 	color: "green"
// };

export { Btn1, Btn2, Btn3, Btn4 };

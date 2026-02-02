import { useEffect, useState } from "react";
import "./list.css"; 
// 비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력.
// url: /api/v1/todos
// method: get

export default function List() {
	let [todos, setTodos] = useState([]);
	let [isReload, setIsReload] = useState(true);
	let [date, setDate] = useState("");
	useEffect(() => {
		if (isReload) {
			getTodos();
		}
	}, []);

	const getTodos = async (date) => {
		if (!date) {
			date = ""
		}
		try {
			const resp = await fetch('/api/v1/todos?date=' + date);
			if (resp.ok) {
				const res = await resp.json();
				setTodos(res);
				setDate(date);
				setIsReload(false);
			}
		} catch (error) {
			console.log(error);
		}
}
const btnClick = (num) => {
	const sendDeleteTodo = async () => {
		try {
			const resp = await fetch(`/api/v1/todos/${num}`, {
				method: "DELETE",
			})
		
			if (resp.ok) {
				const res = await resp.text();
				alert(res);
				setTodos(todos.filter(t => t.num !== num));
				setIsReload(true);
			}
		} catch (err) {
			console.log(err);
		}
	}

	sendDeleteTodo();
}

	const dateTodosClick = function(date) {
		setDate(date);
		setIsReload(true);
		getTodos(date);
	}
	return (
		<div>
			<h1>할 일 목록</h1>
			<button onClick={() => dateTodosClick("")}>전체 조회</button>
			<input type="date" onChange={(e) => dateTodosClick(e.target.value)} value={date} />
			<Todos todos={todos} delBtnClick={btnClick} date={date} setIsReload={setIsReload} />
		</div>
	);
}

function Todos({todos, delBtnClick, date, setIsReload }) {
	return (
		<ul class="todo-list">
			{
				date === '' ?
				<h2>전체</h2> : 
				<h2>{date}</h2>
			}

			{todos.length === 0?
			 <li><h3>등록된 할일이 없습니다.</h3></li> :
			 todos.map(todo => (
				<Todo date={date} todo={todo} delBtnClick={delBtnClick} key={todo.num} setIsReload={setIsReload} />
			))}
		</ul>
	);
}

function Todo({ todo, date, delBtnClick, setIsReload }) {
	let [isUpdate, setIsUpdate] = useState(false);
	let [text, setText] = useState(todo.text);

	const fetchUpdate = async function(num) {
		try {
			const resp = await fetch("/api/v1/todos/" + num, {
				method: "PUT",
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ text, num })
			})

			if (resp.ok) {
				const res = await resp.json();
				if (res) {
					alert("수정했습니다.")
					setIsUpdate(false);
					setIsReload(true);
				} else {
					alert("수정하지 못했습니다.");
				}
			}
		} catch (err) {
			console.error(err);
		}
	}

	return (
		<li key={todo.num} className="todo-item">
			{
				isUpdate ?
				<div>
					<input type="text" value={text} onChange={(e) => setText(e.target.value)} />
					<button onClick={() => fetchUpdate(todo.num)}>수정</button>
					<button onClick={() => setIsUpdate(false)}>취소</button>
				</div>
				:
				<span>
					{
						date === '' ?
						<span className="todo-date">{todo.date}</span> :
						null
					}
					<span className="todo-text">{text}</span>
					<button className="todo-btn" onClick={() => delBtnClick(todo.num)}>&times;</button>
					<button onClick={() => setIsUpdate(true)}>수정</button>
				</span>
			}
		</li>
	);
}
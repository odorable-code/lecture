
function MapApp() {
  const list = [ 
    { name: "홍길동", age: 21 },
    { name: "둘리", age: 31 },
    { name: "고길동", age: 41 }  
  ];


  return (
    <div>
      <ul>
      {
        list.map((item) => {
          return (
            <li>
              <span>{item.name} : </span> -
              <span>{item.age}</span>
            </li>
          );
        })
      }
      </ul>
    </div>
  );
}

export default MapApp;

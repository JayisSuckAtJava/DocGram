
// create
const boardList = document.querySelector("#boardList");

boardList.addEventListener("focusin",()=>{
    let option = "width=500, height=600, top=30, left=30, resizable=no, scrollbar=no, loaction=no";

    window.open("./popup.html","해시태그 선택",option);
})


//dept




//detail


// notice1

function getUserName1() {

ist = document.getElementById('list');

if (confirm("수정 하시겠습니까?") == true){ 
//true는 확인버튼을 눌렀을 때 코드 작성
//  console.log("완료되었습니다.");
location.href="수정페이지로 이동";
}else{
// false는 취소버튼을 눌렀을 때, 취소됨
console.log("취소되었습니다");
}     
}
// 삭제
function getUserName2() {

ist = document.getElementById('list');

if (confirm("삭제 하시겠습니까?") == true){ 
//true는 확인버튼을 눌렀을 때 코드 작성
console.log("완료되었습니다.");
}else{
// false는 취소버튼을 눌렀을 때, 취소됨
console.log("취소되었습니다");
}     
}

// popup

function ajax() {
    const sel = document.querySelector("#sel").value
    const text = document.querySelector("#text").value
    const con = document.querySelector("#container")
    alert(`${text} , ${sel}`)

    let ajaxData;

    const data = axios({
        url: '검색주소',
        method: 'get',
        params: {
            '내가 주는 키': sel ,
            '내가 주는 키': text
        }
    });
    data.then(function (result) {
        console.log(result.data);
        ajaxData = reuslt.data;
    });

    //ajaxData.?

    con.innerHTML = ajaxData;
}
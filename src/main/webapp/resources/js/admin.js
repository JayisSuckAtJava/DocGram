// user
          function getUserName1() {
    
              ist = document.getElementById('list');
    
              if (confirm("수정 하시겠습니까?") == true) {
                //true는 확인버튼을 눌렀을 때 코드 작성
                //  console.log("완료되었습니다.");
                location.href = "수정페이지로 이동";
              } else {
                // false는 취소버튼을 눌렀을 때, 취소됨
                console.log("취소되었습니다");
              }
            }
            // 삭제
            function getUserName2() {
    
              ist = document.getElementById('list');
    
              if (confirm("삭제 하시겠습니까?") == true) {
                //true는 확인버튼을 눌렀을 때 코드 작성
                console.log("완료되었습니다.");
              } else {
                // false는 취소버튼을 눌렀을 때, 취소됨
                console.log("취소되었습니다");
              }
            }

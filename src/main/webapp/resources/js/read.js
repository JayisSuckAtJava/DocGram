
// search

 const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.getAttribute("key");
    console.log(first)
    v.addEventListener("click", () => {
      alert(`hi u are in ${first}`)
      window.location.href = `board/${first}`
    })
  })

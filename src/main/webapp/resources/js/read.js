
// search

 const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.innerHTML;
    console.log(first)
    v.addEventListener("click", () => {
      window.location.href = `/board/${first}`
    })
  })
  
  const trs_star = document.querySelectorAll(".list-body-star > tr");
  trs_star.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.nextElementSibling.innerHTML;
    console.log(first)
    v.addEventListener("click", () => {
      window.location.href = `/board/${first}`
    })
  })

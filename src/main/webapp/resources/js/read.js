
// search

 const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    let first = v.firstElementChild.innerHTML;
    v.addEventListener("click", () => {
      window.location.href = `/board/${first}`
    })
  })
  
  const trs_star = document.querySelectorAll(".list-body-star > tr");
  trs_star.forEach((v) => {
    let first = v.firstElementChild.nextElementSibling.innerHTML;
    v.addEventListener("click", () => {
      window.location.href = `/board/${first}`
    })
  })

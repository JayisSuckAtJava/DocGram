function page() {




let query = location.search;
let url = location.pathname;
const searchParams = new URLSearchParams(query);
console.log(searchParams);
const obj2 = Object.fromEntries(searchParams);
let page;
if(obj2.page == null || obj2.page == "") {
    page = 1;
}else{
    page = obj2.page;
}



        let startPage = (parseInt(page/10) * 10) +1;
        let prev = ( startPage == 1 ) ? 1 : startPage-2
        let endPage = startPage +9;

        let html = '<ul class="pagination">';
            html = html + `<li class="page-item"><a class="page-link" href="${url}?page=${prev}">Previous</a></li>`;
            for (let i = startPage; i < endPage; i++ ){
        html += `<li class="page-item ${page == i ? 'active' : ''}">
            <a class="page-link" href="${url}?page=${i}">${i}</a>
            </li>`;
        }  
        html = html + `<li class="page-item"><a class="page-link" href="${url}?page=${endPage}">Previous</a></li>`;
        html += '</ul>';
        
        const pagenation = document.querySelector("#pagenation");
         pagenation.innerHTML += html;
         
}
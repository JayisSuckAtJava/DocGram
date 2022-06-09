function pageinget() {
function QueryStringToJSON(str) {
    var pairs = str.split('&');
    var result = {};
    pairs.forEach(function (pair) {
        pair = pair.split('=');
        var name = pair[0]
        var value = pair[1]
        if (name.length)
            if (result[name] !== undefined) {
                if (!result[name].push) {
                    result[name] = [result[name]];
                }
                result[name].push(value || '');
            } else {
                result[name] = value || '';
            }
    });
    return (result);
}
let query = location.search
let path = location.pathname
console.log(path+query)
string = query.substring(1);
var obj = QueryStringToJSON(string);
let queryIs = "";
let page = 0;
for(let key in obj) {
    if(key == "page"){
        page = obj[key];
    }else{
    	if(queryIs == ""){
	        queryIs = queryIs + key + "=" + obj[key];
    	}else {
    		queryIs = queryIs + "&" + key + "=" + obj[key];
    	}
        
    }
}
        let url = path+"?"+queryIs;
        let startPage = (parseInt(page/10) * 10) +1;
        let prev = ( startPage == 1 ) ? 1 : startPage-2
        let endPage = startPage +9;

        let html = '<ul class="pagination">';
            html = html + `<li class="page-item"><a class="page-link" href="${url}&page=${prev}">Previous</a></li>`;
            for (let i = startPage; i < endPage; i++ ){
        html += `<li class="page-item ${page == i ? 'active' : ''}">
            <a class="page-link" href="${url}&page=${i}">${i}</a>
            </li>`;
        }  
        html = html + `<li class="page-item"><a class="page-link" href="${url}&page=${endPage}">Next</a></li>`;
        html += '</ul>';
        
        const pagenation = document.querySelector("#pagenation");
         pagenation.innerHTML += html;
}
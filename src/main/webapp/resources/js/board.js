
window.onload = () => {
	const boards = document.querySelectorAll('.board-title');
	
	for(board of boards){
		board.addEventListener('click',(e) => {
			location.href = './info?id=' + e.target.dataset.num;
		});
	}
};

function fnReWrite(num){
	//alert(num);
	const txtReMemo = document.getElementById("txtReMemo");
	
	if(txtReMemo.value.length < 1){
		alert('?Ç¥?ö©?ùÑ ?ûÖ?†•?ï¥ Ï£ºÏÑ∏?öî.');
		txtReMemo.focus();
		return;
	}
	
	if(txtReMemo.value.length > 200){
		alert('200?ûê ÍπåÏ?? ?ûÖ?†• Í∞??ä• ?ï©?ãà?ã§.');
		txtReMemo.focus();
		return;
	}
	
	const refrm = document.createElement('form');
	refrm.action = "./rewrite";
	refrm.method = "post"

	document.body.appendChild(refrm);
	
	const inputNum = document.createElement('input');
	inputNum.name = "board_idx";
	inputNum.value = num;
	
		
	refrm.appendChild(inputNum);
	refrm.appendChild(txtReMemo);
	
	refrm.submit();	
		
}

function fnConfirm(val, url){
	if(confirm(val + ' «œΩ√∞⁄Ω¿¥œ±Ó?')){
		location.href = url;
	};
}







/**
 * 
 */
//console.log('123 한글');
const btn_xhttp_post = document.getElementById('btn-xhttp-post');
const post_pizza_name = document.getElementById('post-pizza-name');
const post_pizza_price = document.getElementById('post-pizza-price');
const post_pizza_calories = document.getElementById('post-pizza-calories');
const out3 = document.getElementById('out3');

const xhttp_post_ins = new XMLHttpRequest();


xhttp_post_ins.addEventListener('readystatechange', (e) => {
    
    const readyState = e.target.readyState;    

    if(readyState == 4){
        const responseText = e.target.responseText;
        const httpStatus = e.target.status;

        console.log(responseText);
        console.log('httpStatus : ', httpStatus);
        
        if(httpStatus == 200){
            out3.innerText = '등록 성공';
            out3.style.color = 'green';
        }else{
            out3.innerText = '등록 실패';
            out3.style.color = 'red';
        }
    }
});

btn_xhttp_post.addEventListener('click', (e) => {

    const pizza = {
        //id : 0,
        name : post_pizza_name.value,
        price : post_pizza_price.value,
        calories :post_pizza_calories.value
    }
    //xhttp_post_ins.open('POST', '/restful/pizza/addjson');
    xhttp_post_ins.open('POST', '/restful/sample/pizza');
    
    // 요청 해더 설정
    xhttp_post_ins.setRequestHeader('Content-type','application/json; charset=utf-8');    
    // Object -> JSON (stringfy)
    xhttp_post_ins.send(JSON.stringify(pizza) );
});



const btn1 = document.getElementById('btn-xhttp');
const btn2 = document.getElementById('btn-xhttp-put');
const out = document.getElementById('out');
const selName = document.getElementById('selName');
const txtPrice = document.getElementById('txtPrice');
const txtCalories = document.getElementById('txtCalories');
const txtId = document.getElementById('txtId');

const btn3 = document.getElementById('btn-xhttp-put2');
const xhttp3 = new XMLHttpRequest();

const xhttpGet = new XMLHttpRequest();

xhttpGet.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;

    if(readyState == 4){
        const responseText = e.target.responseText;
        const pizza = JSON.parse(responseText);

        txtPrice.value = pizza.price;        
        txtCalories.value = pizza.calories;
        txtId.value = pizza.id;
    }

});

xhttp3.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;

    if(readyState == 4){
        const responseText = e.target.responseText;

        console.log(responseText);
        
        if(responseText == 1){
            out.innerText = '수정 성공';
            out.style.color = 'green';
        }else{
            out.innerText = '수정 실패';
            out.style.color = 'red';
        }

    }
});

btn3.addEventListener('click', (e) => {

    const pizza = {
        id : txtId.value,
        name : selName.options[selName.selectedIndex].text,
        price : txtPrice.value,
        calories :txtCalories.value
    }

    // console.log('input pizza id value : ', txtId.value);
    // console.log('input pizza name value : ', selName.options[selName.selectedIndex].text);
    // console.log('input pizza price value : ', txtCalories.value);
    // console.log('input pizza calories value : ', txtPrice.value);

    // GET방식은 주소뒤에 ?name=value& .. 로 실어 보내면 되지만
    // 그외에 방식은 send() 메서드에 데이터를 실어 보낸다
    xhttp3.open('PUT', '/restful/sample/pizza');
    // 요청 해더 설정
    xhttp3.setRequestHeader('Content-type','application/json; charset=utf-8');    
    // Object -> JSON (stringfy)
    xhttp3.send(JSON.stringify(pizza) );
});


// 1.Ajax를 위한 xhttp 인스턴스 생성
const xhttpUpt = new XMLHttpRequest();

xhttpUpt.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('서버로 비동기 요청 보냈다');
    }else if(readyState == 2){
        console.log('서버가 내 요청을 받았다');
    }else if(readyState == 3){
        console.log('서버가 내 요청에 대한 처리를 시작했다');
    }else if(readyState == 4){
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답이 도착했다');
        console.log('응답은 responseText에 들어있다', responseText);
    }else {
        console.log('?? : ', readyState , ',' , responseText);
    }

});

// 전송
btn2.addEventListener('click', () => {

    var data = {};
    data.id = txtId.value;
    //data.name  = selName.options[selName.selectedIndex].value.split("/")[3];
    // const selName = document.getElementById('selName');
    // selName.options[selName.selectedIndex].value;
    // selName.options[selName.selectedIndex].text;
    data.name  = selName.options[selName.selectedIndex].text;
    data.price  = txtPrice.value;
    data.calories  = txtCalories.value;
    var json = JSON.stringify(data);

    xhttpUpt.open("PUT", '/restful/pizza/addjson', true);
    xhttpUpt.setRequestHeader('Content-type','application/json; charset=utf-8');    
    xhttpUpt.send(json);

});

// 선택
selName.addEventListener('change', () => {

    txtPrice.value = "";
    txtCalories.value = "";
    txtId.value = "";

    const xhttp = new XMLHttpRequest();

    xhttp.open('GET', '/restful/pizza/addjson/' + selName.options[selName.selectedIndex].value, true)
    xhttp.onload = function () {
        const pizza = JSON.parse(xhttp.responseText);
        if (xhttp.readyState == 4 && xhttp.status == "200") {
            //console.log(pizza);
            txtPrice.value = pizza.price;        
            txtCalories.value = pizza.calories;
            txtId.value = pizza.id;
        } else {
            console.log("error");
        }
    }
    xhttp.send();


    // //console.log(selName.options[selName.selectedIndex].value);
    // const getData = selName.options[selName.selectedIndex].value;
    // //console.log(getData.length);
    // txtId.readOnly = false;
    // if(getData.length > 0){
    //     const arrValue = getData.split("/");
    //     // console.log(arrValue[0]);
    //     // console.log(arrValue[1]);
    //     // console.log(arrValue[2]);
    //     txtPrice.value = arrValue[1];        
    //     txtCalories.value = arrValue[2];
    //     txtId.value = arrValue[0];
    // }else{
    //     txtPrice.value = "";
    //     txtCalories.value = "";
    //     txtId.value = "";
    // }
    // txtId.readOnly = true;
});


// AJAZ

const xhttp = new XMLHttpRequest();

// 2.xhttp에 이벤트 설정
xhttp.addEventListener('readystatechange', (e) => {
    //console.log('readystatechange event : ', e);

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('서버로 비동기 요청 보냈다');
    }else if(readyState == 2){
        console.log('서버가 내 요청을 받았다');
    }else if(readyState == 3){
        console.log('서버가 내 요청에 대한 처리를 시작했다');
    }else if(readyState == 4){
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답이 도착했다');
        console.log('응답은 responseText에 들어있다', responseText);

        // JSON 문자열 -> Javascript Object로 변환
        const pizza = JSON.parse(responseText);

        console.log('pizza name: ', pizza.name);
        //console.log('pizza calories: ', pizza[calories]);

        const pizzaDiv = document.createElement('div');

        pizzaDiv.innerText = `${pizza.name}[${pizza.calories}]`;

        out.appendChild(pizzaDiv);

    }else {
        console.log('?? : ', readyState , ',' , responseText);
    }

});

btn1.addEventListener('click', (e) => {
    // 3. 새로운 xhttp 연결을 설정
    xhttp.open('GET', '/restful/sample/pizza/22');

    // 4. 원하는 타이밍에 요청을 전송
    xhttp.send();
});
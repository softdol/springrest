/**
 * 
 */
//console.log('123 �ѱ�');
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
            out3.innerText = '��� ����';
            out3.style.color = 'green';
        }else{
            out3.innerText = '��� ����';
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
    
    // ��û �ش� ����
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
            out.innerText = '���� ����';
            out.style.color = 'green';
        }else{
            out.innerText = '���� ����';
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

    // GET����� �ּҵڿ� ?name=value& .. �� �Ǿ� ������ ������
    // �׿ܿ� ����� send() �޼��忡 �����͸� �Ǿ� ������
    xhttp3.open('PUT', '/restful/sample/pizza');
    // ��û �ش� ����
    xhttp3.setRequestHeader('Content-type','application/json; charset=utf-8');    
    // Object -> JSON (stringfy)
    xhttp3.send(JSON.stringify(pizza) );
});


// 1.Ajax�� ���� xhttp �ν��Ͻ� ����
const xhttpUpt = new XMLHttpRequest();

xhttpUpt.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('������ �񵿱� ��û ���´�');
    }else if(readyState == 2){
        console.log('������ �� ��û�� �޾Ҵ�');
    }else if(readyState == 3){
        console.log('������ �� ��û�� ���� ó���� �����ߴ�');
    }else if(readyState == 4){
        console.log('������ ó���� ������ �� ��û�� ���� ������ �����ߴ�');
        console.log('������ responseText�� ����ִ�', responseText);
    }else {
        console.log('?? : ', readyState , ',' , responseText);
    }

});

// ����
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

// ����
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

// 2.xhttp�� �̺�Ʈ ����
xhttp.addEventListener('readystatechange', (e) => {
    //console.log('readystatechange event : ', e);

    const readyState = e.target.readyState;
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('������ �񵿱� ��û ���´�');
    }else if(readyState == 2){
        console.log('������ �� ��û�� �޾Ҵ�');
    }else if(readyState == 3){
        console.log('������ �� ��û�� ���� ó���� �����ߴ�');
    }else if(readyState == 4){
        console.log('������ ó���� ������ �� ��û�� ���� ������ �����ߴ�');
        console.log('������ responseText�� ����ִ�', responseText);

        // JSON ���ڿ� -> Javascript Object�� ��ȯ
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
    // 3. ���ο� xhttp ������ ����
    xhttp.open('GET', '/restful/sample/pizza/22');

    // 4. ���ϴ� Ÿ�ֿ̹� ��û�� ����
    xhttp.send();
});